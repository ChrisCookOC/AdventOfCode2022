package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_get_instructions() {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            List<Instruction> instructions = fileParser.getInstructions();

            assertEquals(146, instructions.size());

            assertEquals("addx 15", instructions.get(0).instruction);
            assertEquals("addx -11", instructions.get(1).instruction);
            assertEquals("addx 6", instructions.get(2).instruction);
            assertEquals("noop", instructions.get(27).instruction);
            assertEquals("noop", instructions.get(56).instruction);
            assertEquals("addx -3", instructions.get(87).instruction);
            assertEquals("noop", instructions.get(90).instruction);
            assertEquals("addx 3", instructions.get(123).instruction);
            assertEquals("noop", instructions.get(145).instruction);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}