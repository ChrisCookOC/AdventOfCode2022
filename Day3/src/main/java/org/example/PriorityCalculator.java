package org.example;

public class PriorityCalculator {

    private final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public int getPriorityForItem(String item) {
        return letters.indexOf(item) + 1;
    }

    public String[] splitBetweenRucksacks(String source) {

        int size = source.length();
        String[] result = new String[2];

        result[0] = source.substring(0, size / 2);
        result[1] = source.substring(size / 2, size);

        return result;
    }

    public String findMatchingLetterInRucksacks(String rucksack1, String rucksack2) {

        for (int counter = 0; counter < rucksack1.length(); counter++) {

            if (rucksack2.contains(rucksack1.substring(counter, counter + 1))) {
                return rucksack1.substring(counter, counter + 1);
            }

        }

        return "";
    }

    public String findMatchingLetterInRucksacks(String[] rucksackContents) {
        return findMatchingLetterInRucksacks(rucksackContents[0], rucksackContents[1]);
    }

    public String findBadgeInTrio(Trio trio) {
        for (int counter = 0; counter < trio.getElf1().length(); counter++) {

            if (trio.getElf2().contains(trio.getElf1().substring(counter, counter + 1))) {

                if (trio.getElf3().contains(trio.getElf1().substring(counter, counter + 1))) {
                    return trio.getElf1().substring(counter, counter + 1);
                }
            }

        }

        return "";
    }
}
