package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay10Test {

    AdventDay10 adventDay10;

    @BeforeEach
    void beforeEach() {
        adventDay10 = new AdventDay10("src/test/resources/input-test.txt");
    }

    @Test
    void should_sum_signal_strengths_every_twenty() {
        int sum = adventDay10.sumSignalStrengths();
        assertEquals(13140, sum);
    }

    @Test
    void should_draw_crt() {

        adventDay10.sumSignalStrengths();
        String display = adventDay10.displayCRT();
        assertEquals("""
                ##..##..##..##..##..##..##..##..##..##..
                ###...###...###...###...###...###...###.
                ####....####....####....####....####....
                #####.....#####.....#####.....#####.....
                ######......######......######......####
                #######.......#######.......#######.....
                """, display);
    }

}