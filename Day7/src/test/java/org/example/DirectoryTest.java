package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryTest {

    @Test
    void empty_directory_returns_zero() {
        Directory directory = new Directory("dir1");
        assertEquals(0, directory.calculateTotalStorageSpace());
    }

    @Test
    void directory_with_just_files_sums_them() {
        Directory directory = new Directory("dir1");

        directory.contents.add(new File("a.txt", 200022));
        directory.contents.add(new File("b", 938));

        assertEquals(200960, directory.calculateTotalStorageSpace());
    }

    @Test
    void directory_with_directory_inside_includes_its_files() {
        Directory directory = new Directory("dir1");

        directory.contents.add(new File("a.txt", 200022));
        directory.contents.add(new File("b", 938));

        Directory subDirectory = new Directory("dir2");
        subDirectory.parent = directory;
        subDirectory.contents.add(new File("c.exe", 8383));
        directory.contents.add(subDirectory);

        assertEquals(209343, directory.calculateTotalStorageSpace());
    }

    @Test
    void calculate_for_test_values_directory() {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            FileSystem fileSystem = fileParser.buildFileSystem();

            Directory testDirectory = fileSystem.directories.get("e/a//");
            assertEquals(584, testDirectory.calculateTotalStorageSpace());

            testDirectory = fileSystem.directories.get("a//");
            assertEquals(94853, testDirectory.calculateTotalStorageSpace());

            testDirectory = fileSystem.directories.get("d//");
            assertEquals(24933642, testDirectory.calculateTotalStorageSpace());

            testDirectory = fileSystem.directories.get("/");
            assertEquals(48381165, testDirectory.calculateTotalStorageSpace());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    void get_full_name_for_root() {
        Directory directory = new Directory("/");
        assertEquals("/", directory.getFullName());
    }


    @Test
    void get_full_name_for_subdirectory() {
        Directory rootDirectory = new Directory("/");
        Directory subDirectory = new Directory("dir1");
        subDirectory.parent = rootDirectory;

        assertEquals("dir1//", subDirectory.getFullName());
    }

    @Test
    void get_full_name_for_subSubDirectory() {
        Directory rootDirectory = new Directory("/");
        Directory subDirectory = new Directory("dir1");
        Directory subSubDirectory = new Directory("dir2");
        subSubDirectory.parent = subDirectory;
        subDirectory.parent = rootDirectory;

        assertEquals("dir2/dir1//", subSubDirectory.getFullName());
    }
}