package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private final InputStream file;

    public FileParser(InputStream file) {
        this.file = file;
    }

    public List<Round> getHands() throws IOException {

        List<Round> rounds = new ArrayList<>();

        Hand player1 = null;
        Result result = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] values = line.split(" ");

                switch (values[0]) {
                    case "A" -> player1 = Hand.ROCK;
                    case "B" -> player1 = Hand.PAPER;
                    case "C" -> player1 = Hand.SCISSORS;
                }

                switch (values[1]) {
                    case "X" -> result = Result.LOSE;
                    case "Y" -> result = Result.DRAW;
                    case "Z" -> result = Result.WIN;
                }

                rounds.add(new Round(player1, result));


            }
        }

        return rounds;
    }
}
