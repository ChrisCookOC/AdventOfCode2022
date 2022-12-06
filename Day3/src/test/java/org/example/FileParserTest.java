package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_parse_file_for_rucksack_pairs() {

        List<String> results;

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            results = fileParser.getRucksacks();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(6, results.size());
        assertEquals("vJrwpWtwJgWrhcsFMMfFFhFp", results.get(0));
        assertEquals("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", results.get(1));
        assertEquals("PmmdzqPrVvPwwTWBwg", results.get(2));
        assertEquals("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", results.get(3));
        assertEquals("ttgJtRGJQctTZtZT", results.get(4));
        assertEquals("CrZsJsPPZsGzwwsLwLmpwMDw", results.get(5));

    }


    @Test
    void should_parse_file_for_trios() {

        List<Trio> results;

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            results = fileParser.getTrios();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, results.size());
        assertEquals("vJrwpWtwJgWrhcsFMMfFFhFp", results.get(0).getElf1());
        assertEquals("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", results.get(0).getElf2());
        assertEquals("PmmdzqPrVvPwwTWBwg", results.get(0).getElf3());
        assertEquals("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", results.get(1).getElf1());
        assertEquals("ttgJtRGJQctTZtZT", results.get(1).getElf2());
        assertEquals("CrZsJsPPZsGzwwsLwLmpwMDw", results.get(1).getElf3());

    }

}