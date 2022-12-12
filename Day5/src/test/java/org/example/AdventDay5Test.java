package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay5Test {

    @Test
    void should_get_top_values_for_each_stack_after_instructions() {
        assertEquals("CMZ", AdventDay5.getTopValuesAfterInstructions_Crane9000("src/test/resources/input-test.txt"));
    }

    @Test
    void should_get_top_values_for_each_stack_after_instructions_3001() {
        assertEquals("MCD", AdventDay5.getTopValuesAfterInstructions_Crane9001("src/test/resources/input-test.txt"));
    }
}