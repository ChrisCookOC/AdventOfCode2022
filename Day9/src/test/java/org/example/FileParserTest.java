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

            assertEquals(8, instructions.size());

            assertEquals("R", instructions.get(0).direction);
            assertEquals(4, instructions.get(0).amount);

            assertEquals("U", instructions.get(1).direction);
            assertEquals(4, instructions.get(1).amount);

            assertEquals("L", instructions.get(2).direction);
            assertEquals(3, instructions.get(2).amount);

            assertEquals("D", instructions.get(3).direction);
            assertEquals(1, instructions.get(3).amount);

            assertEquals("R", instructions.get(4).direction);
            assertEquals(4, instructions.get(4).amount);

            assertEquals("D", instructions.get(5).direction);
            assertEquals(1, instructions.get(5).amount);

            assertEquals("L", instructions.get(6).direction);
            assertEquals(5, instructions.get(6).amount);

            assertEquals("R", instructions.get(7).direction);
            assertEquals(2, instructions.get(7).amount);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}