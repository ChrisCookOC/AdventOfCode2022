package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinCalculatorTest {

    @Test
    void should_have_result_score_6_when_player2_wins() {

        assertEquals(6, WinCalculator.getResultScore(Hand.ROCK, Hand.PAPER));
        assertEquals(6, WinCalculator.getResultScore(Hand.PAPER, Hand.SCISSORS));
        assertEquals(6, WinCalculator.getResultScore(Hand.SCISSORS, Hand.ROCK));
    }

    @Test
    void should_have_result_score_3_when_draw() {

        assertEquals(3, WinCalculator.getResultScore(Hand.ROCK, Hand.ROCK));
        assertEquals(3, WinCalculator.getResultScore(Hand.PAPER, Hand.PAPER));
        assertEquals(3, WinCalculator.getResultScore(Hand.SCISSORS, Hand.SCISSORS));
    }

    @Test
    void should_have_result_score_0_when_player2_loses() {

        assertEquals(0, WinCalculator.getResultScore(Hand.PAPER, Hand.ROCK));
        assertEquals(0, WinCalculator.getResultScore(Hand.SCISSORS, Hand.PAPER));
        assertEquals(0, WinCalculator.getResultScore(Hand.ROCK, Hand.SCISSORS));
    }

    @Test
    void should_add_result_and_play_score() {
        assertEquals(8, WinCalculator.getScore(Hand.ROCK, Hand.PAPER));
        assertEquals(9, WinCalculator.getScore(Hand.PAPER, Hand.SCISSORS));
        assertEquals(7, WinCalculator.getScore(Hand.SCISSORS, Hand.ROCK));
    }


}