package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_parse_file() {

        List<Pair> results;

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            results = fileParser.getPairs();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(6, results.size());

        assertEquals("2-4,6-8", results.get(0).toString());
        assertEquals("2-3,4-5", results.get(1).toString());
        assertEquals("5-7,7-9", results.get(2).toString());
        assertEquals("2-8,3-7", results.get(3).toString());
        assertEquals("6-6,4-6", results.get(4).toString());
        assertEquals("2-6,4-8", results.get(5).toString());

    }

}