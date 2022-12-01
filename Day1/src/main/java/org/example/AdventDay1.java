package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class AdventDay1 {

    private final InputStream file;

    public AdventDay1(InputStream file) {
        this.file = file;
    }

    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("Day1/src/input.txt")) {
            AdventDay1 adventDay1 = new AdventDay1(fileInputStream);

            List<Integer> sortedCalories = adventDay1.getSortedCalorieList();

            System.out.printf("The elf with the most calories has %d calories%n", adventDay1.runAdventDay1(sortedCalories));

            System.out.printf("The top three elves have %d calories%n", adventDay1.runAdventDay2(sortedCalories));
        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

    }

    protected int runAdventDay1(List<Integer> sortedCalories) {
        return sortedCalories.get(0);
    }

    protected int runAdventDay2(List<Integer> sortedCalories) {
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += sortedCalories.get(i);
        }

        return sum;
    }

    protected List<Integer> getSortedCalorieList() throws IOException {
        FileParser fileParser = new FileParser(file);

        Map<Integer, List<Integer>> elves = fileParser.getCalorieLists();
        Map<Integer, Integer> elfCalorieSums = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> elf : elves.entrySet()) {
            elfCalorieSums.put(elf.getKey(), CalorieCalculator.calculateCalories(elf.getValue()));
        }

        List<Integer> sortedCalories = new ArrayList<>(elfCalorieSums.values().stream().sorted().toList());
        Collections.reverse(sortedCalories);

        return sortedCalories;
    }


}