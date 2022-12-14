package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

    @Test
    void should_build_file_system() {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            FileSystem fileSystem = fileParser.buildFileSystem();

            assertEquals(4,fileSystem.directories.size());

            Directory rootDirectory = fileSystem.directories.get("/");
            assertEquals("/", rootDirectory.name);
            assertNull(rootDirectory.parent);
            assertEquals(4,rootDirectory.contents.size());

            Directory subDirectory = (Directory) rootDirectory.contents.get(0);
            assertEquals("a", subDirectory.name);
            assertEquals(rootDirectory, subDirectory.parent);
            assertEquals(4,subDirectory.contents.size());

            Directory subSubDirectory = (Directory) subDirectory.contents.get(0);
            assertEquals("e", subSubDirectory.name);
            assertEquals(subDirectory, subSubDirectory.parent);
            assertEquals(1, subSubDirectory.contents.size());

            File file = (File) subSubDirectory.contents.get(0);
            assertEquals("i", file.name);
            assertEquals(584, file.size);
            assertEquals(subSubDirectory, file.parent);

            file = (File) subDirectory.contents.get(1);
            assertEquals("f", file.name);
            assertEquals(29116, file.size);
            assertEquals(subDirectory, file.parent);

            file = (File) subDirectory.contents.get(2);
            assertEquals("g", file.name);
            assertEquals(2557, file.size);
            assertEquals(subDirectory, file.parent);

            file = (File) subDirectory.contents.get(3);
            assertEquals("h.lst", file.name);
            assertEquals(62596, file.size);
            assertEquals(subDirectory, file.parent);

            file = (File) rootDirectory.contents.get(1);
            assertEquals("b.txt", file.name);
            assertEquals(14848514, file.size);
            assertEquals(rootDirectory, file.parent);

            file = (File) rootDirectory.contents.get(2);
            assertEquals("c.dat", file.name);
            assertEquals(8504156, file.size);
            assertEquals(rootDirectory, file.parent);

             subDirectory = (Directory) rootDirectory.contents.get(3);
            assertEquals("d", subDirectory.name);
            assertEquals(rootDirectory, subDirectory.parent);
            assertEquals(4, subDirectory.contents.size());

            file = (File) subDirectory.contents.get(0);
            assertEquals("j", file.name);
            assertEquals(4060174, file.size);
            assertEquals(subDirectory, file.parent);

            file = (File) subDirectory.contents.get(1);
            assertEquals("d.log", file.name);
            assertEquals(8033020, file.size);
            assertEquals(subDirectory, file.parent);

            file = (File) subDirectory.contents.get(2);
            assertEquals("d.ext", file.name);
            assertEquals(5626152, file.size);
            assertEquals(subDirectory, file.parent);

            file = (File) subDirectory.contents.get(3);
            assertEquals("k", file.name);
            assertEquals(7214296, file.size);
            assertEquals(subDirectory, file.parent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}