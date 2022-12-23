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

    public List<Instruction> getInstructions() throws IOException {

        List<Instruction> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            int lineNo = 0;
            while ((line = reader.readLine()) != null) {

                instructions.add(new Instruction(line, ++lineNo));

            }
        }

        return instructions;
    }

}
