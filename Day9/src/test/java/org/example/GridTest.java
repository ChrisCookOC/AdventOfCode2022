package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Grid.HEADER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GridTest {

    Grid gridShortMode;
    Grid gridLongMode;

    @BeforeEach
    void beforeEach() {
        gridShortMode = new Grid(false);
        gridLongMode = new Grid(true);
    }

    @Test
    void should_move_head_1_right_if_direction_is_R() {
        gridShortMode.moveHead("R");

        assertEquals(gridShortMode.stringCoords.get(HEADER), new Coordinate(0, 1, false));
        assertEquals(gridShortMode.stringCoords.get(1), new Coordinate(0, 0, true));

        assertTrue(gridShortMode.grid.contains(new Coordinate(0, 1, false)));
    }

    @Test
    void should_move_head_1_left_if_direction_is_L() {
        gridShortMode.moveHead("L");

        assertEquals(gridShortMode.stringCoords.get(HEADER), new Coordinate(0, -1, false));
        assertEquals(gridShortMode.stringCoords.get(1), new Coordinate(0, 0, true));

        assertTrue(gridShortMode.grid.contains(new Coordinate(0, -1, false)));
    }

    @Test
    void should_move_head_1_up_if_direction_is_U() {
        gridShortMode.moveHead("U");

        assertEquals(gridShortMode.stringCoords.get(HEADER), new Coordinate(1, 0, false));
        assertEquals(gridShortMode.stringCoords.get(1), new Coordinate(0, 0, true));

        assertTrue(gridShortMode.grid.contains(new Coordinate(1, 0, false)));
    }

    @Test
    void should_move_head_1_down_if_direction_is_D() {
        gridShortMode.moveHead("D");

        assertEquals(gridShortMode.stringCoords.get(HEADER), new Coordinate(-1, 0, false));
        assertEquals(gridShortMode.stringCoords.get(1), new Coordinate(0, 0, true));

        assertTrue(gridShortMode.grid.contains(new Coordinate(-1, 0, false)));
    }

    @Test
    void should_move_head_4_right_if_instruction_is_R_4() {
        gridShortMode.performInstruction(new Instruction("R", 4));

        assertEquals(gridShortMode.stringCoords.get(HEADER), new Coordinate(0, 4, false));
        assertEquals(gridShortMode.stringCoords.get(1), new Coordinate(0, 3, true));

        assertTrue(gridShortMode.grid.contains(new Coordinate(0, 1, true)));
        assertTrue(gridShortMode.grid.contains(new Coordinate(0, 2, true)));
        assertTrue(gridShortMode.grid.contains(new Coordinate(0, 3, true)));
        assertTrue(gridShortMode.grid.contains(new Coordinate(0, 4, false)));
    }

    @Test
    void zero_distance_between_head_and_tail_when_same_coord() {

        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 0, false));
        gridShortMode.stringCoords.put(1, new Coordinate(0, 0, false));

        assertEquals(0, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

    }

    @Test
    void distance_one_between_head_and_tail_when_next_to_eachother() {
        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(0, 0, true));

        assertEquals(1, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(2, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(1, 1, true));

        assertEquals(1, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(-1, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(-1, 0, true));

        assertEquals(1, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(1, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(2, 1, true));

        assertEquals(1, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 0, false));
        gridShortMode.stringCoords.put(1, new Coordinate(1, 1, true));

        assertEquals(1, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));
    }

    @Test
    void distance_two_between_head_and_tail_when_two_apart() {
        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 2, false));
        gridShortMode.stringCoords.put(1, new Coordinate(0, 0, true));

        assertEquals(2, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(3, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(1, 1, true));

        assertEquals(2, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(-1, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(-1, -1, true));

        assertEquals(2, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(1, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(3, 1, true));

        assertEquals(2, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 0, false));
        gridShortMode.stringCoords.put(1, new Coordinate(2, 2, true));

        assertEquals(2, gridShortMode.calculateDistanceBetweenTwoCoords(HEADER, 1));
    }

    @Test
    void move_tail_to_follow_head_when_2_away_on_right() {
        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 2, false));
        gridShortMode.stringCoords.put(1, new Coordinate(0, 0, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(0, 1, true), gridShortMode.stringCoords.get(1));

    }

    @Test
    void move_tail_to_follow_head_when_2_away_on_left() {
        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, -1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(0, 1, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(0, 0, true), gridShortMode.stringCoords.get(1));

    }

    @Test
    void move_tail_to_follow_head_when_2_away_above() {
        gridShortMode.stringCoords.put(HEADER, new Coordinate(56, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(54, 1, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(55, 1, true), gridShortMode.stringCoords.get(1));

    }

    @Test
    void move_tail_to_follow_head_when_2_away_below() {
        gridShortMode.stringCoords.put(HEADER, new Coordinate(56, 1, false));
        gridShortMode.stringCoords.put(1, new Coordinate(58, 1, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(57, 1, true), gridShortMode.stringCoords.get(1));

    }

    @Test
    void move_tail_to_follow_head_when_2_away_diagonally() {
        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 0, false));
        gridShortMode.stringCoords.put(1, new Coordinate(1, 2, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(0, 1, true), gridShortMode.stringCoords.get(1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 0, false));
        gridShortMode.stringCoords.put(1, new Coordinate(1, -2, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(0, -1, true), gridShortMode.stringCoords.get(1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 0, false));
        gridShortMode.stringCoords.put(1, new Coordinate(2, 1, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(1, 0, true), gridShortMode.stringCoords.get(1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(0, 0, false));
        gridShortMode.stringCoords.put(1, new Coordinate(-2, 1, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(-1, 0, true), gridShortMode.stringCoords.get(1));

        gridShortMode.stringCoords.put(HEADER, new Coordinate(2, 4, false));
        gridShortMode.stringCoords.put(1, new Coordinate(0, 3, true));

        gridShortMode.moveTailToFollowProceeding(HEADER, 1);
        assertEquals(new Coordinate(1, 4, true), gridShortMode.stringCoords.get(1));
    }

    @Test
    void count_how_many_visited() {

        gridShortMode.grid.add(new Coordinate(1, 0, true));
        gridShortMode.grid.add(new Coordinate(2, 0, false));
        gridShortMode.grid.add(new Coordinate(3, 0, false));
        gridShortMode.grid.add(new Coordinate(4, 0, true));

        gridShortMode.grid.add(new Coordinate(1, 1, false));
        gridShortMode.grid.add(new Coordinate(2, 1, false));
        gridShortMode.grid.add(new Coordinate(3, 1, false));
        gridShortMode.grid.add(new Coordinate(4, 1, true));

        gridShortMode.grid.add(new Coordinate(1, 2, true));
        gridShortMode.grid.add(new Coordinate(2, 2, true));
        gridShortMode.grid.add(new Coordinate(3, 2, true));
        gridShortMode.grid.add(new Coordinate(4, 2, false));

        gridShortMode.grid.add(new Coordinate(1, 3, false));
        gridShortMode.grid.add(new Coordinate(2, 3, false));
        gridShortMode.grid.add(new Coordinate(3, 3, false));
        gridShortMode.grid.add(new Coordinate(4, 3, false));

        //7 - start at 0,0 defaults to true
        assertEquals(7, gridShortMode.countVisited());

    }

    @Test
    void should_move_head_4_right_if_instruction_is_R_4_longMode() {
        gridLongMode.performInstruction(new Instruction("R", 4));

        assertEquals(gridLongMode.stringCoords.get(HEADER), new Coordinate(0, 4, false));
        assertEquals(gridLongMode.stringCoords.get(1), new Coordinate(0, 3, false));
        assertEquals(gridLongMode.stringCoords.get(2), new Coordinate(0, 2, false));
        assertEquals(gridLongMode.stringCoords.get(3), new Coordinate(0, 1, false));
        assertEquals(gridLongMode.stringCoords.get(4), new Coordinate(0, 0, true));
        assertEquals(gridLongMode.stringCoords.get(5), new Coordinate(0, 0, true));
        assertEquals(gridLongMode.stringCoords.get(6), new Coordinate(0, 0, true));
        assertEquals(gridLongMode.stringCoords.get(7), new Coordinate(0, 0, true));
        assertEquals(gridLongMode.stringCoords.get(8), new Coordinate(0, 0, true));


        assertTrue(gridLongMode.grid.contains(new Coordinate(0, 1, false)));
        assertTrue(gridLongMode.grid.contains(new Coordinate(0, 2, false)));
        assertTrue(gridLongMode.grid.contains(new Coordinate(0, 3, false)));
        assertTrue(gridLongMode.grid.contains(new Coordinate(0, 4, false)));
    }


}
