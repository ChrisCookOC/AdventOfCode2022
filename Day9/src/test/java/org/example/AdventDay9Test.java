package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay9Test {

    @Test
    void should_count_visited_squares() {
        int count = AdventDay9.countVisitedSquares("src/test/resources/input-test.txt");
        assertEquals(13, count);
    }

    @Test
    void should_count_visited_squares_longMode() {
        int count = AdventDay9.countVisitedSquares_longMode("src/test/resources/input-test2.txt");
        assertEquals(36, count);
    }

}