package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CycleTest {

    @Test
    void should_calculate_signal_strength() {
        Cycle cycle = new Cycle(10, 9);
        assertEquals(90, cycle.calculateSignalStrength());
    }

}