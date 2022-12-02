package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay2Test {

    @Test
    void should_calculate_total() {

        assertEquals(12, AdventDay2.calculateScore("src/test/resources/input-test.txt"));
    }

    @Test
    void should_calculate_player2s_hand() {

        assertEquals(Hand.SCISSORS, AdventDay2.getPlayer2sHand(Hand.ROCK, Result.LOSE));
        assertEquals(Hand.ROCK, AdventDay2.getPlayer2sHand(Hand.PAPER, Result.LOSE));
        assertEquals(Hand.PAPER, AdventDay2.getPlayer2sHand(Hand.SCISSORS, Result.LOSE));

        assertEquals(Hand.ROCK, AdventDay2.getPlayer2sHand(Hand.ROCK, Result.DRAW));
        assertEquals(Hand.PAPER, AdventDay2.getPlayer2sHand(Hand.PAPER, Result.DRAW));
        assertEquals(Hand.SCISSORS, AdventDay2.getPlayer2sHand(Hand.SCISSORS, Result.DRAW));

        assertEquals(Hand.PAPER, AdventDay2.getPlayer2sHand(Hand.ROCK, Result.WIN));
        assertEquals(Hand.SCISSORS, AdventDay2.getPlayer2sHand(Hand.PAPER, Result.WIN));
        assertEquals(Hand.ROCK, AdventDay2.getPlayer2sHand(Hand.SCISSORS, Result.WIN));

    }

}