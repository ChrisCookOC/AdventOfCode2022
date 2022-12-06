package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay3Test {

    @Test
    void should_find_sum_of_priorities_of_matching() {
        assertEquals(157, AdventDay3.calculateSums("src/test/resources/input-test.txt"));
    }

    @Test
    void should_find_sum_of_badges() {
        assertEquals(70, AdventDay3.calculateBadgeSum("src/test/resources/input-test-2.txt"));
    }


}