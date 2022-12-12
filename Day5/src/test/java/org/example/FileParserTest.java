package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_parse_file() {

        Stacks results;

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            results = fileParser.getStack();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(3, results.stacks.size());

        Stack stackOne = results.stacks.get(0);
        assertEquals(2, stackOne.items.size());
        assertEquals("Z", stackOne.items.get(0));
        assertEquals("N", stackOne.items.get(1));

        Stack stackTwo = results.stacks.get(1);
        assertEquals(3, stackTwo.items.size());
        assertEquals("M", stackTwo.items.get(0));
        assertEquals("C", stackTwo.items.get(1));
        assertEquals("D", stackTwo.items.get(2));

        Stack stackThree = results.stacks.get(2);
        assertEquals(1, stackThree.items.size());
        assertEquals("P", stackThree.items.get(0));

        assertEquals(4, results.instructions.size());
        assertEquals(1, results.instructions.get(0).quantityToMove);
        assertEquals(1, results.instructions.get(0).startColumn);
        assertEquals(0, results.instructions.get(0).endColumn);

        assertEquals(3, results.instructions.get(1).quantityToMove);
        assertEquals(0, results.instructions.get(1).startColumn);
        assertEquals(2, results.instructions.get(1).endColumn);

        assertEquals(2, results.instructions.get(2).quantityToMove);
        assertEquals(1, results.instructions.get(2).startColumn);
        assertEquals(0, results.instructions.get(2).endColumn);

        assertEquals(1, results.instructions.get(3).quantityToMove);
        assertEquals(0, results.instructions.get(3).startColumn);
        assertEquals(1, results.instructions.get(3).endColumn);
    }

    @Test
    void should_get_number_of_columns() {
        List<String> lines = List.of("[D]", "[N] [C]", "[Z] [M] [P]", " 1   2   3", "", "move 1 from 2 to 1", "move 3 from 1 to 3");

        FileParser fileParser = new FileParser(null);
        assertEquals(3, fileParser.getNumberOfStacks(lines));

        lines = List.of("[D]", "[N] [C]", "[Z] [M] [P] [F]", " 1   2   3   4   5", "", "move 1 from 2 to 1", "move 3 from 1 to 3");

        assertEquals(5, fileParser.getNumberOfStacks(lines));

    }

    @Test
    void should_split_line_when_all_columns() {
        FileParser fileParser = new FileParser(null);

        String line = "[Z] [M] [P] [F]";

        String[] values = {"Z", "M", "P", "F" };

        assertArrayEquals(values, fileParser.parseLine(line, 4));

        line = "     [M]     [F]    ";
        values = new String[]{"", "M", "", "F", "" };

        assertArrayEquals(values, fileParser.parseLine(line, 5));
    }
}