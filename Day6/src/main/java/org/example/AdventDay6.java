package org.example;

import java.io.FileInputStream;

public class AdventDay6 {

    public static void main(String[] args) {

        int[] value = findStartOfPacketAndMessageMarkers("src/input.txt");

        System.out.printf("The start of packet marker is %d\n", value[0]);
        System.out.printf("The start of message marker is %d\n", value[1]);
    }

    public static int[] findStartOfPacketAndMessageMarkers(String fileName) {
        int[] startPoint = new int[2];

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            Message message = fileParser.getMessage();

            startPoint[0] = message.findStartOfPacketMarker();
            startPoint[1] = message.findStartOfMessageMarker();

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return startPoint;

    }

}