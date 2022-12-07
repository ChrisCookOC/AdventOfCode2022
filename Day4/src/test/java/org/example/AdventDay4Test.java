package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay4Test {

    @Test
    void should_count_how_many_fully_overlaps() {
        assertEquals(2, AdventDay4.countFullyOverlapping("src/test/resources/input-test.txt"));
    }

    @Test
    void should_count_how_many_overlaps() {
        assertEquals(4, AdventDay4.countAnyOverlapping("src/test/resources/input-test.txt"));
    }

}