package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    Grid grid;

    @BeforeEach
    void beforeEach() {
        grid = new Grid();
        grid.gridWidth = 5;
        grid.gridHeight = 5;
        setupGrid();
    }

    private void setupGrid() {
        grid.grid.put(new Coordinate(1, 1), new Tree(3));
        grid.grid.put(new Coordinate(1, 2), new Tree(0));
        grid.grid.put(new Coordinate(1, 3), new Tree(3));
        grid.grid.put(new Coordinate(1, 4), new Tree(7));
        grid.grid.put(new Coordinate(1, 5), new Tree(3));

        grid.grid.put(new Coordinate(2, 1), new Tree(2));
        grid.grid.put(new Coordinate(2, 2), new Tree(5));
        grid.grid.put(new Coordinate(2, 3), new Tree(5));
        grid.grid.put(new Coordinate(2, 4), new Tree(1));
        grid.grid.put(new Coordinate(2, 5), new Tree(2));

        grid.grid.put(new Coordinate(3, 1), new Tree(6));
        grid.grid.put(new Coordinate(3, 2), new Tree(5));
        grid.grid.put(new Coordinate(3, 3), new Tree(3));
        grid.grid.put(new Coordinate(3, 4), new Tree(3));
        grid.grid.put(new Coordinate(3, 5), new Tree(2));

        grid.grid.put(new Coordinate(4, 1), new Tree(3));
        grid.grid.put(new Coordinate(4, 2), new Tree(3));
        grid.grid.put(new Coordinate(4, 3), new Tree(5));
        grid.grid.put(new Coordinate(4, 4), new Tree(4));
        grid.grid.put(new Coordinate(4, 5), new Tree(9));

        grid.grid.put(new Coordinate(5, 1), new Tree(3));
        grid.grid.put(new Coordinate(5, 2), new Tree(5));
        grid.grid.put(new Coordinate(5, 3), new Tree(3));
        grid.grid.put(new Coordinate(5, 4), new Tree(9));
        grid.grid.put(new Coordinate(5, 5), new Tree(0));

    }

    @Test
    void should_return_true_when_edge_trees() {
        assertTrue(grid.isEdgeTree(new Coordinate(1, 1)));
        assertTrue(grid.isEdgeTree(new Coordinate(1, 2)));
        assertTrue(grid.isEdgeTree(new Coordinate(1, 3)));
        assertTrue(grid.isEdgeTree(new Coordinate(1, 4)));
        assertTrue(grid.isEdgeTree(new Coordinate(1, 5)));

        assertTrue(grid.isEdgeTree(new Coordinate(5, 1)));
        assertTrue(grid.isEdgeTree(new Coordinate(5, 2)));
        assertTrue(grid.isEdgeTree(new Coordinate(5, 3)));
        assertTrue(grid.isEdgeTree(new Coordinate(5, 4)));
        assertTrue(grid.isEdgeTree(new Coordinate(5, 5)));

        assertTrue(grid.isEdgeTree(new Coordinate(2, 1)));
        assertTrue(grid.isEdgeTree(new Coordinate(3, 1)));
        assertTrue(grid.isEdgeTree(new Coordinate(4, 1)));

        assertTrue(grid.isEdgeTree(new Coordinate(2, 5)));
        assertTrue(grid.isEdgeTree(new Coordinate(3, 5)));
        assertTrue(grid.isEdgeTree(new Coordinate(4, 5)));
    }

    @Test
    void should_return_false_when_inner_trees() {
        assertFalse(grid.isEdgeTree(new Coordinate(2, 2)));
        assertFalse(grid.isEdgeTree(new Coordinate(2, 3)));
        assertFalse(grid.isEdgeTree(new Coordinate(2, 4)));

        assertFalse(grid.isEdgeTree(new Coordinate(3, 2)));
        assertFalse(grid.isEdgeTree(new Coordinate(3, 3)));
        assertFalse(grid.isEdgeTree(new Coordinate(3, 4)));

        assertFalse(grid.isEdgeTree(new Coordinate(4, 2)));
        assertFalse(grid.isEdgeTree(new Coordinate(4, 3)));
        assertFalse(grid.isEdgeTree(new Coordinate(4, 4)));

    }

    @Test
    void edge_trees_are_always_visible() {
        assertTrue(grid.isTreeVisible(new Coordinate(1, 1)));
        assertTrue(grid.isTreeVisible(new Coordinate(1, 2)));
        assertTrue(grid.isTreeVisible(new Coordinate(1, 3)));
        assertTrue(grid.isTreeVisible(new Coordinate(1, 4)));
        assertTrue(grid.isTreeVisible(new Coordinate(1, 5)));

        assertTrue(grid.isTreeVisible(new Coordinate(5, 1)));
        assertTrue(grid.isTreeVisible(new Coordinate(5, 2)));
        assertTrue(grid.isTreeVisible(new Coordinate(5, 3)));
        assertTrue(grid.isTreeVisible(new Coordinate(5, 4)));
        assertTrue(grid.isTreeVisible(new Coordinate(5, 5)));

        assertTrue(grid.isTreeVisible(new Coordinate(2, 1)));
        assertTrue(grid.isTreeVisible(new Coordinate(3, 1)));
        assertTrue(grid.isTreeVisible(new Coordinate(4, 1)));

        assertTrue(grid.isTreeVisible(new Coordinate(2, 5)));
        assertTrue(grid.isTreeVisible(new Coordinate(3, 5)));
        assertTrue(grid.isTreeVisible(new Coordinate(4, 5)));
    }

    @Test
    void visible_from_top_and_left_is_visible() {
        assertTrue(grid.isTreeVisible(new Coordinate(2, 2)));
    }

    @Test
    void visible_from_top_and_right_is_visible() {
        assertTrue(grid.isTreeVisible(new Coordinate(2, 3)));
    }


    @Test
    void not_visible_from_all_sides() {
        assertFalse(grid.isTreeVisible(new Coordinate(2, 4)));
    }

    @Test
    void visible_from_left_if_trees_to_left_are_smaller() {
        assertTrue(grid.isVisibleFromLeft(new Coordinate(2, 2)));
        assertTrue(grid.isVisibleFromLeft(new Coordinate(5, 4)));
    }

    @Test
    void not_visible_from_left_if_tree_to_left_is_equal() {
        assertFalse(grid.isVisibleFromLeft(new Coordinate(2, 3)));
    }

    @Test
    void not_visible_from_left_if_trees_to_left_are_taller() {
        assertFalse(grid.isVisibleFromLeft(new Coordinate(2, 4)));
    }

    @Test
    void visible_from_right_if_trees_to_right_are_smaller() {
        assertTrue(grid.isVisibleFromRight(new Coordinate(2, 3)));
    }

    @Test
    void not_visible_from_right_if_tree_to_right_is_equal() {
        assertFalse(grid.isVisibleFromRight(new Coordinate(4, 1)));
    }

    @Test
    void not_visible_from_right_if_trees_to_right_are_taller() {
        assertFalse(grid.isVisibleFromRight(new Coordinate(2, 4)));
    }

    @Test
    void visible_from_top_if_trees_above_are_smaller() {
        assertTrue(grid.isVisibleFromTop(new Coordinate(2, 2)));
    }

    @Test
    void not_visible_from_top_if_tree_above_is_equal() {
        assertFalse(grid.isVisibleFromTop(new Coordinate(3, 2)));
    }

    @Test
    void not_visible_from_top_if_trees_above_are_taller() {
        assertFalse(grid.isVisibleFromTop(new Coordinate(4, 2)));
    }

    @Test
    void visible_from_bottom_if_trees_below_are_smaller() {
        assertTrue(grid.isVisibleFromBelow(new Coordinate(3, 1)));
    }

    @Test
    void not_visible_from_bottom_if_tree_below_is_equal() {
        assertFalse(grid.isVisibleFromBelow(new Coordinate(4, 1)));
    }

    @Test
    void not_visible_from_bottom_if_trees_below_are_taller() {
        assertFalse(grid.isVisibleFromBelow(new Coordinate(4, 4)));
    }

    @Test
    void calculate_how_many_visible() {
        assertEquals(21, grid.howManyTreesAreVisible());
    }

    @Test
    void calculate_visibility_from_top() {
        assertEquals(1, grid.calculateVisibilityAbove(new Coordinate(2, 3)));
        assertEquals(2, grid.calculateVisibilityAbove(new Coordinate(4, 3)));

    }

    @Test
    void calculate_visibility_from_left() {
        assertEquals(1, grid.calculateVisibilityLeft(new Coordinate(2, 3)));
        assertEquals(2, grid.calculateVisibilityLeft(new Coordinate(4, 3)));

    }

    @Test
    void calculate_visibility_from_bottom() {
        assertEquals(2, grid.calculateVisibilityBelow(new Coordinate(2, 3)));
        assertEquals(1, grid.calculateVisibilityBelow(new Coordinate(4, 3)));
    }

    @Test
    void calculate_visibility_from_right() {
        assertEquals(2, grid.calculateVisibilityRight(new Coordinate(2, 3)));
        assertEquals(2, grid.calculateVisibilityRight(new Coordinate(4, 3)));

    }

    @Test
    void calculate_scenic_score() {
        assertEquals(4, grid.getScenicScore(new Coordinate(2, 3)));
        assertEquals(8, grid.getScenicScore(new Coordinate(4, 3)));
    }

    @Test
    void find_highest_scenic_score() {
        assertEquals(8, grid.getHighestScenicScore());
    }
}