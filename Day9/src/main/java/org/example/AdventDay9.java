package org.example;

import java.io.FileInputStream;
import java.util.List;

public class AdventDay9 {

    public static void main(String[] args) {

        int count = countVisitedSquares("src/input.txt");
        System.out.printf("The number of visited squares is %d\n", count);

        count = countVisitedSquares_longMode("src/input.txt");
        System.out.printf("The number of visited squares in long rope mode is %d\n", count);
    }

    public static int countVisitedSquares(String fileName) {
        int count;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<Instruction> instructions = fileParser.getInstructions();

            Grid grid = new Grid(false);
            for (Instruction instruction : instructions) {
                grid.performInstruction(instruction);
            }

            count = grid.countVisited();
        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return count;
    }

    public static int countVisitedSquares_longMode(String fileName) {
        int count;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<Instruction> instructions = fileParser.getInstructions();

            Grid grid = new Grid(true);
            for (Instruction instruction : instructions) {
                grid.performInstruction(instruction);
            }

            count = grid.countVisited();
        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return count;
    }

}