package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay6Test {

    @Test
    void should_find_start_of_packet_and_message_markers() {
        int[] results = AdventDay6.findStartOfPacketAndMessageMarkers("src/test/resources/input-test.txt");
        assertEquals(7, results[0]);
        assertEquals(19, results[1]);
    }

}