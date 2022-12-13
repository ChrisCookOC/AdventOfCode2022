package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_parse_file() {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            Message message = fileParser.getMessage();

            assertEquals("mjqjpqmgbljsphdztnvjfqwrcgsmlb", message.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}