package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay8Test {

    @Test
    void should_count_number_of_trees_visible() {
        int count = AdventDay8.countVisibleTrees("src/test/resources/input-test.txt");
        assertEquals(21, count);
    }

    @Test
    void should_find_best_scenic_rating() {
        int rating = AdventDay8.findHighestScenicRating("src/test/resources/input-test.txt");
        assertEquals(8, rating);
    }

}