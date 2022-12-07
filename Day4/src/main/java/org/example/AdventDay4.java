package org.example;

import java.io.FileInputStream;
import java.util.List;

public class AdventDay4 {

    public static void main(String[] args) {

        int count = countFullyOverlapping("src/input.txt");

        System.out.printf("The count of pairs where one contains the other is %d\n", count);

        count = countAnyOverlapping("src/input.txt");
        System.out.printf("The count of pairs where any overlap occurs is %d\n", count);
    }

    public static int countFullyOverlapping(String fileName) {
        int count = 0;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<Pair> pairs = fileParser.getPairs();

            for (Pair pair : pairs) {
                if (pair.doesFullyContainOther()) {
                    count++;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return count;
    }

    public static int countAnyOverlapping(String fileName) {
        int count = 0;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<Pair> pairs = fileParser.getPairs();

            for (Pair pair : pairs) {
                if (pair.doesOverlap()) {
                    count++;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return count;
    }
}