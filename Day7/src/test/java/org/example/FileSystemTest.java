package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    FileSystem fileSystem;

    @BeforeEach
    void beforeEach() {
        fileSystem = new FileSystem();
        fileSystem.currentDirectory = new Directory("dir1");
        fileSystem.currentDirectory.parent = new Directory("/");
        fileSystem.addDirectoryToCollection(fileSystem.currentDirectory);
        fileSystem.addDirectoryToCollection(fileSystem.currentDirectory.parent);

    }

    @Test
    void should_change_to_route_directory_if_cd_slash() {
        CommandLine instruction = new CommandLine("$ cd /");

        fileSystem.executeChangeDirectoryCommand(instruction);

        assertEquals("/", fileSystem.currentDirectory.name);

    }

    @Test
    void should_change_to_preexisting_non_root_directory() {
        Directory directory2 = new Directory("dir2");
        directory2.parent = fileSystem.directories.get("/");

        fileSystem.addDirectoryToCollection(directory2);
        CommandLine instruction = new CommandLine("$ cd dir2");

        fileSystem.executeChangeDirectoryCommand(instruction);

        assertEquals("dir2", fileSystem.currentDirectory.name);
    }

    @Test
    void should_change_to_new_directory() {

        CommandLine instruction = new CommandLine("$ cd dir2");

        fileSystem.executeChangeDirectoryCommand(instruction);

        assertEquals("dir2", fileSystem.currentDirectory.name);
        assertEquals("dir1", fileSystem.currentDirectory.parent.name);

        assertTrue(fileSystem.directories.containsKey("dir2/dir1//"));
    }

    @Test
    void should_add_files_to_directory_contents() {
        CommandLine commandLine = new CommandLine("14848514 b.txt");

        fileSystem.addFileToDirectoryContents(commandLine);

        assertEquals(1, fileSystem.currentDirectory.contents.size());

        File file = (File) fileSystem.currentDirectory.contents.get(0);
        assertEquals("b.txt", file.name);
        assertEquals(14848514, file.size);
        assertEquals("dir1", file.parent.name);
    }

    @Test
    void should_add_directory_to_directory_contents() {
        CommandLine commandLine = new CommandLine("dir dir2");

        fileSystem.addDirectoryToDirectoryContents(commandLine);

        assertEquals(1, fileSystem.currentDirectory.contents.size());

        Directory directory = (Directory) fileSystem.currentDirectory.contents.get(0);
        assertEquals("dir2", directory.name);
        assertEquals("dir1", directory.parent.name);

        assertTrue(fileSystem.directories.containsKey("dir2/dir1//"));
    }

    @Test
    void should_allow_same_name_for_directories_at_different_levels() {
        CommandLine commandLine = new CommandLine("dir dir2");

        fileSystem.addDirectoryToDirectoryContents(commandLine);

        assertEquals(1, fileSystem.currentDirectory.contents.size());

        Directory directory = (Directory) fileSystem.currentDirectory.contents.get(0);
        assertEquals("dir2", directory.name);
        assertEquals("dir1", directory.parent.name);

        assertTrue(fileSystem.directories.containsKey("dir2/dir1//"));

        fileSystem.executeChangeDirectoryCommand(new CommandLine("$ cd dir2"));
        fileSystem.addDirectoryToDirectoryContents(new CommandLine("dir dir1"));

        directory = (Directory) fileSystem.currentDirectory.contents.get(0);
        assertEquals("dir1", directory.name);
        assertEquals("dir2", directory.parent.name);
        assertTrue(fileSystem.directories.containsKey("dir1/dir2/dir1//"));
        assertEquals(4, fileSystem.directories.size());

    }


    @Test
    void should_navigate_up_a_directory() {
        CommandLine instruction = new CommandLine("$ cd ..");

        fileSystem.executeChangeDirectoryCommand(instruction);

        assertEquals("/", fileSystem.currentDirectory.name);
        assertNull(fileSystem.currentDirectory.parent);
    }

    @Test
    void should_get_directories_in_ordered_list() {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            FileSystem fileSystem = fileParser.buildFileSystem();

            List<Directory> sortedList = fileSystem.sortDirectoriesBySize();

            assertEquals("e", sortedList.get(0).name);
            assertEquals("a", sortedList.get(1).name);
            assertEquals("d", sortedList.get(2).name);
            assertEquals("/", sortedList.get(3).name);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
