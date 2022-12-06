package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class AdventDay3 {

    public static void main(String[] args) {

        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());

        int sum = calculateSums("src/input.txt");

        System.out.printf("The sum is %d\n", sum);

        sum = calculateBadgeSum("src/input.txt");
        System.out.printf("The badge sum is %d\n", sum);

    }


    public static int calculateSums(String file) {
        PriorityCalculator priorityCalculator = new PriorityCalculator();

        int sum = 0;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<String> rucksacks = fileParser.getRucksacks();

            for (String rucksack : rucksacks) {
                String[] rucksackContents = priorityCalculator.splitBetweenRucksacks(rucksack);
                String matching = priorityCalculator.findMatchingLetterInRucksacks(rucksackContents);
                sum += priorityCalculator.getPriorityForItem(matching);
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return sum;

    }

    public static int calculateBadgeSum(String file) {
        PriorityCalculator priorityCalculator = new PriorityCalculator();

        int sum = 0;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<Trio> trios = fileParser.getTrios();

            for (Trio trio : trios) {
                String badge = priorityCalculator.findBadgeInTrio(trio);
                sum += priorityCalculator.getPriorityForItem(badge);
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return sum;

    }
}