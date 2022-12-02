package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class AdventDay2 {

    public static void main(String[] args) {

        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());

        int sum = calculateScore("src/input.txt");

        System.out.printf("Your score is %d%n", sum);


    }

    public static int calculateScore(String file) {
        int sum = 0;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<Round> rounds = fileParser.getHands();


            for (Round round : rounds) {
                round.setPlayer2(getPlayer2sHand(round));
                sum += WinCalculator.getScore(round);
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return sum;
    }

    public static Hand getPlayer2sHand(Round round) {
        return getPlayer2sHand(round.getPlayer1(), round.getResult());
    }

    public static Hand getPlayer2sHand(Hand player1sHand, Result wantedResult) {

        switch (wantedResult) {
            case LOSE:
                switch (player1sHand) {
                    case ROCK -> {
                        return Hand.SCISSORS;
                    }
                    case PAPER -> {
                        return Hand.ROCK;
                    }
                    case SCISSORS -> {
                        return Hand.PAPER;
                    }
                }

            case DRAW:
                return player1sHand;

            case WIN:
                switch (player1sHand) {
                    case ROCK -> {
                        return Hand.PAPER;
                    }
                    case PAPER -> {
                        return Hand.SCISSORS;
                    }
                    case SCISSORS -> {
                        return Hand.ROCK;
                    }
                }
        }

        return null;
    }

}