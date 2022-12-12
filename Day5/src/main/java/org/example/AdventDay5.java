package org.example;

import java.io.FileInputStream;

public class AdventDay5 {

    public static void main(String[] args) {

        String value = getTopValuesAfterInstructions_Crane9000("src/input.txt");

        System.out.printf("The top columns spell %s\n", value);

        value = getTopValuesAfterInstructions_Crane9001("src/input.txt");

        System.out.printf("The top columns spell %s\n", value);
    }

    public static String getTopValuesAfterInstructions_Crane9000(String fileName) {
        String result;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            Stacks stacks = fileParser.getStack();
            for (Instruction instruction : stacks.instructions) {
                stacks.performInstruction_Crane9000(instruction);
            }
            result = stacks.getValuesFromTopOfStacks();

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return result;
    }

    public static String getTopValuesAfterInstructions_Crane9001(String fileName) {
        String result;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            Stacks stacks = fileParser.getStack();
            for (Instruction instruction : stacks.instructions) {
                stacks.performInstruction_Crane9001(instruction);
            }
            result = stacks.getValuesFromTopOfStacks();

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return result;
    }

   /* public static int countFullyOverlapping(String fileName) {
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
    }*/
}