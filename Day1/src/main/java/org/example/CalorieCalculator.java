package org.example;

import java.util.List;

public class CalorieCalculator {

    public static int calculateCalories(List<Integer> calories) {

        int sum = 0;

        for (int calorie : calories) {
            sum += calorie;
        }
        return sum;
    }
}
