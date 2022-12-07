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

    public List<Pair> getPairs() throws IOException {

        List<Pair> pairs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] ranges = line.split(",");

                String[] pair1 = ranges[0].split("-");
                Range rangeElf1 = new Range(Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]));

                String[] pair2 = ranges[1].split("-");
                Range rangeElf2 = new Range(Integer.parseInt(pair2[0]), Integer.parseInt(pair2[1]));

                pairs.add(new Pair.PairBuilder().elf1(rangeElf1).elf2(rangeElf2).build());
            }
        }

        return pairs;
    }

}
