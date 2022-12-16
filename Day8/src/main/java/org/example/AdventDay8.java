package org.example;

import java.io.FileInputStream;

public class AdventDay8 {

    public static void main(String[] args) {

        int count = countVisibleTrees("src/input.txt");

        System.out.printf("The number of visible trees is %d\n", count);

        int score = findHighestScenicRating("src/input.txt");
        System.out.printf("The highest scenic score possible is %d\n", score);

    }

    public static int countVisibleTrees(String fileName) {
        int count;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            Grid grid = fileParser.buildGrid();

            count = grid.howManyTreesAreVisible();

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return count;
    }

    public static int findHighestScenicRating(String fileName) {
        int score;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            Grid grid = fileParser.buildGrid();

            score = grid.getHighestScenicScore();

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return score;
    }
}