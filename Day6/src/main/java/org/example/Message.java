package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public class Message {
    private String message;

    int findStartOfPacketMarker() {

        for (int i = 0; i < message.length() - 4; i++) {
            String[] values = new String[4];

            for (int j = 0; j < 4; j++) {
                values[j] = message.substring(i + j, i + j + 1);
            }

            String[] uniqueValues = Arrays.stream(values).distinct().toArray(String[]::new);
            if (Arrays.equals(values, uniqueValues)) {
                return i + 4;
            }

        }

        return 0;
    }

    int findStartOfMessageMarker() {

        for (int i = 0; i < message.length() - 14; i++) {
            String[] values = new String[14];

            for (int j = 0; j < 14; j++) {
                values[j] = message.substring(i + j, i + j + 1);
            }

            String[] uniqueValues = Arrays.stream(values).distinct().toArray(String[]::new);
            if (Arrays.equals(values, uniqueValues)) {
                return i + 14;
            }

        }

        return 0;
    }

}
