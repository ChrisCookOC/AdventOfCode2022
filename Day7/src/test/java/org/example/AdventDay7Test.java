package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay7Test {

    @Test
    void should_find_total_of_folders_less_than_100000() {
        int sum = AdventDay7.findTotalOfFoldersLessThan100000("src/test/resources/input-test.txt");
        assertEquals(95437, sum);
    }

    @Test
    void should_find_smallest_folder_that_will_be_large_enough_to_remove() {

        assertEquals(24933642, AdventDay7.findSizeOfSmallestThatMeetsRequirements("src/test/resources/input-test.txt"));

    }
}