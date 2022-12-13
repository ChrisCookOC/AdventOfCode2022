package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTest {

    @Test
    void should_find_start_of_packet_marker() {

        Message message = new Message("mjqjpqmgbljsphdztnvjfqwrcgsmlb");

        assertEquals(7, message.findStartOfPacketMarker());

        message = new Message("bvwbjplbgvbhsrlpgdmjqwftv" +
                "ncz");
        assertEquals(5, message.findStartOfPacketMarker());

        message = new Message("nppdvjthqldpwncqszvftbrmjlhg");
        assertEquals(6, message.findStartOfPacketMarker());

        message = new Message("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        assertEquals(10, message.findStartOfPacketMarker());

        message = new Message("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        assertEquals(11, message.findStartOfPacketMarker());
    }

    @Test
    void should_find_start_of_message_marker() {

        Message message = new Message("mjqjpqmgbljsphdztnvjfqwrcgsmlb");

        assertEquals(19, message.findStartOfMessageMarker());

        message = new Message("bvwbjplbgvbhsrlpgdmjqwftv" +
                "ncz");
        assertEquals(23, message.findStartOfMessageMarker());

        message = new Message("nppdvjthqldpwncqszvftbrmjlhg");
        assertEquals(23, message.findStartOfMessageMarker());

        message = new Message("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        assertEquals(29, message.findStartOfMessageMarker());

        message = new Message("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        assertEquals(26, message.findStartOfMessageMarker());
    }

}