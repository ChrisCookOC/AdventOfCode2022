package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriorityCalculatorTest {

    PriorityCalculator priorityCalculator = new PriorityCalculator();

    @Test
    void should_return_1_for_a() {
        assertEquals(1, priorityCalculator.getPriorityForItem("a"));
    }

    @Test
    void should_return_12_for_l() {
        assertEquals(12, priorityCalculator.getPriorityForItem("l"));
    }

    @Test
    void should_return_52_for_Z() {
        assertEquals(52, priorityCalculator.getPriorityForItem("Z"));
    }

    @Test
    void should_split_bags_in_half() {
        String[] rucksackContents = priorityCalculator.splitBetweenRucksacks("vJrwpWtwJgWrhcsFMMfFFhFp");
        assertEquals(2, rucksackContents.length);
        assertEquals("vJrwpWtwJgWr", rucksackContents[0]);
        assertEquals("hcsFMMfFFhFp", rucksackContents[1]);
    }

    @Test
    void should_split_bags_in_half_2() {
        String[] rucksackContents = priorityCalculator.splitBetweenRucksacks("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        assertEquals(2, rucksackContents.length);
        assertEquals("jqHRNqRjqzjGDLGL", rucksackContents[0]);
        assertEquals("rsFMfFZSrLrFZsSL", rucksackContents[1]);
    }

    @Test
    void should_find_entries_that_match() {

        String rucksack1 = "jqHRNqRjqzjGDLGL";
        String rucksack2 = "rsFMfFZSrLrFZsSL";

        assertEquals("L", priorityCalculator.findMatchingLetterInRucksacks(rucksack1, rucksack2));

    }

    @Test
    void should_find_badge_from_trio() {

        Trio trio = Trio.builder().elf1("vJrwpWtwJgWrhcsFMMfFFhFp")
                .elf2("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
                .elf3("PmmdzqPrVvPwwTWBwg").build();

        assertEquals("r", priorityCalculator.findBadgeInTrio(trio));

    }

}