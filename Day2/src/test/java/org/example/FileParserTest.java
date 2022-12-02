package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_parse_file_to_hands() {

        List<Round> results;

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            results = fileParser.getHands();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(3, results.size());
        assertEquals(Hand.ROCK, results.get(0).getPlayer1());
        assertEquals(Result.DRAW, results.get(0).getResult());

        assertEquals(Hand.PAPER, results.get(1).getPlayer1());
        assertEquals(Result.LOSE, results.get(1).getResult());

        assertEquals(Hand.SCISSORS, results.get(2).getPlayer1());
        assertEquals(Result.WIN, results.get(2).getResult());

    }

}