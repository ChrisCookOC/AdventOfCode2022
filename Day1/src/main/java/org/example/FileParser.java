package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {

    private final InputStream file;


    public FileParser(InputStream file) {
        this.file = file;
    }

    public Map<Integer, List<Integer>> getCalorieLists() throws IOException {

        Map<Integer, List<Integer>> results = new HashMap<>();
        List<Integer> individualElf = new ArrayList<>();
        int elfCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.isEmpty()) {
                    if (individualElf.size() != 0) {
                        results.put(++elfCount, individualElf);
                    }

                    individualElf = new ArrayList<>();
                    continue;
                }

                individualElf.add(Integer.parseInt(line));
            }

            if (individualElf.size() != 0) {
                results.put(++elfCount, individualElf);
            }
        }


        return results;
    }
}
