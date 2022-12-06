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

    public List<String> getRucksacks() throws IOException {

        List<String> rucksacks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                rucksacks.add(line);

            }
        }

        return rucksacks;
    }

    public List<Trio> getTrios() throws IOException {
        List<Trio> rucksacks = new ArrayList<>();

        Trio trio = new Trio("", "", "");


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                switch (++count) {
                    case 1 -> trio.setElf1(line);
                    case 2 -> trio.setElf2(line);
                    case 3 -> trio.setElf3(line);
                    case 4 -> {
                        rucksacks.add(trio);
                        trio = new Trio("", "", "");
                        count = 1;
                        trio.setElf1(line);
                    }
                }
            }
        }

        rucksacks.add(trio);

        return rucksacks;

    }
}
