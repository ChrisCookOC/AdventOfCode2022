package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalorieCalculatorTest {

    @Test
    void should_return_value_if_one_calorie() {
        List<Integer> list = new ArrayList<>();
        list.add(1232);

        assertEquals(1232, CalorieCalculator.calculateCalories(list));
    }

    @Test
    void should_sum_up_all_calories() {
        List<Integer> list = new ArrayList<>();
        list.add(1232);
        list.add(322);
        list.add(9932);
        list.add(123);

        assertEquals(11609, CalorieCalculator.calculateCalories(list));
    }

    @Test
    void should_return_zero_if_none() {
        assertEquals(0, CalorieCalculator.calculateCalories(new ArrayList<>()));
    }

}