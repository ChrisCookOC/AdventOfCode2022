package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {

    @Test
    void should_return_false_if_no_overlap_for_fully_contained() {
        Pair pair = new Pair(new Range(1, 1), new Range(2, 2));
        assertFalse(pair.doesFullyContainOther());

        pair = new Pair(new Range(1231, 4223), new Range(8988, 10002));
        assertFalse(pair.doesFullyContainOther());
    }

    @Test
    void should_return_true_if_equal_for_fully_contained() {
        Pair pair = new Pair(new Range(1, 1), new Range(1, 1));
        assertTrue(pair.doesFullyContainOther());

        pair = new Pair(new Range(8988, 10002), new Range(8988, 10002));
        assertTrue(pair.doesFullyContainOther());
    }

    @Test
    void should_return_true_if_elf1_fully_contains_elf2_for_fully_contained() {
        Pair pair = new Pair(new Range(1, 10), new Range(1, 1));
        assertTrue(pair.doesFullyContainOther());

        pair = new Pair(new Range(8988, 10002), new Range(9202, 10002));
        assertTrue(pair.doesFullyContainOther());

        pair = new Pair(new Range(1, 10000), new Range(12, 232));
        assertTrue(pair.doesFullyContainOther());
    }

    @Test
    void should_return_true_if_elf2_fully_contains_elf1_for_fully_contained() {
        Pair pair = new Pair(new Range(1, 1), new Range(1, 10));
        assertTrue(pair.doesFullyContainOther());

        pair = new Pair(new Range(9202, 10002), new Range(8988, 10002));
        assertTrue(pair.doesFullyContainOther());

        pair = new Pair(new Range(12, 232), new Range(1, 10000));
        assertTrue(pair.doesFullyContainOther());
    }

    @Test
    void should_return_false_if_partial_overlap_for_fully_contained() {
        Pair pair = new Pair(new Range(1, 10), new Range(8, 12));
        assertFalse(pair.doesFullyContainOther());

        pair = new Pair(new Range(1231, 4223), new Range(3223, 10002));
        assertFalse(pair.doesFullyContainOther());

        pair = new Pair(new Range(5443, 12343), new Range(12, 5999));
        assertFalse(pair.doesFullyContainOther());

    }

    @Test
    void should_return_false_if_no_overlap_for_any_overlap() {
        Pair pair = new Pair(new Range(1, 1), new Range(2, 2));
        assertFalse(pair.doesOverlap());

        pair = new Pair(new Range(1231, 4223), new Range(8988, 10002));
        assertFalse(pair.doesOverlap());

    }

    @Test
    void should_return_true_if_equal_for_any_overlap() {
        Pair pair = new Pair(new Range(1, 1), new Range(1, 1));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(8988, 10002), new Range(8988, 10002));
        assertTrue(pair.doesOverlap());
    }

    @Test
    void should_return_true_if_elf1_fully_contains_elf2_for_any_overlap() {
        Pair pair = new Pair(new Range(1, 10), new Range(1, 1));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(8988, 10002), new Range(9202, 10002));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(1, 10000), new Range(12, 232));
        assertTrue(pair.doesOverlap());
    }

    @Test
    void should_return_true_if_elf2_fully_contains_elf1_for_any_overlap() {
        Pair pair = new Pair(new Range(1, 1), new Range(1, 10));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(9202, 10002), new Range(8988, 10002));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(12, 232), new Range(1, 10000));
        assertTrue(pair.doesOverlap());
    }

    @Test
    void should_return_true_if_partial_overlap_for_any_overlap() {
        Pair pair = new Pair(new Range(1, 10), new Range(8, 12));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(1231, 4223), new Range(3223, 10002));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(5443, 12343), new Range(12, 5999));
        assertTrue(pair.doesOverlap());

    }

    @Test
    void should_return_true_if_endpoints_overlap() {
        Pair pair = new Pair(new Range(1, 10), new Range(10, 12));
        assertTrue(pair.doesOverlap());

        pair = new Pair(new Range(1023, 10245), new Range(12, 1023));
        assertTrue(pair.doesOverlap());
    }
}