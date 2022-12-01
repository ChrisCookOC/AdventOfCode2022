package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventDay1Test {

    @Test
    void should_find_highest_elf() {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test-input.txt")) {

            AdventDay1 adventDay1 = new AdventDay1(fileInputStream);
            List<Integer> sortedCalories = adventDay1.getSortedCalorieList();
            int highestElf = adventDay1.runAdventDay1(sortedCalories);
            assertEquals(54564, highestElf);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void should_find_highest_3_calories_count() {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test-input-2.txt")) {
            AdventDay1 adventDay1 = new AdventDay1(fileInputStream);
            List<Integer> sortedCalories = adventDay1.getSortedCalorieList();

            int sumOfHighestThree = adventDay1.runAdventDay2(sortedCalories);

            assertEquals(287229, sumOfHighestThree);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}