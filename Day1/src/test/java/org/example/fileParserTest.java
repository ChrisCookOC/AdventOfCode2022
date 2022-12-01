package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_return_list_of_calories_for_each_elf() throws IOException {

        Map<Integer, List<Integer>> results;

        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test-input.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            results = fileParser.getCalorieLists();

        }

        assertEquals(3, results.size());

        List<Integer> elf = results.get(0);
        assertEquals(2, elf.size());
        assertEquals(12342, elf.get(0));
        assertEquals(42222, elf.get(1));

        elf = results.get(1);
        assertEquals(1, elf.size());
        assertEquals(33333, elf.get(0));

        elf = results.get(2);
        assertEquals(5, elf.size());
        assertEquals(12, elf.get(0));
        assertEquals(123, elf.get(1));
        assertEquals(1245, elf.get(2));
        assertEquals(2344, elf.get(3));
        assertEquals(5, elf.get(4));

    }

}