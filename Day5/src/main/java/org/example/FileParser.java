package org.example;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileParser {

    private final InputStream file;

    public FileParser(InputStream file) {
        this.file = file;
    }

    public Stacks getStack() throws IOException {

        Stacks stack = new Stacks();
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                lines.add(line);

            }
        }

        int colCount = getNumberOfStacks(lines);

        for (int i = 0; i < colCount; i++) {
            Stack listOfValuesInStack = new Stack();
            stack.stacks.add(listOfValuesInStack);
        }

        for (String line : lines) {
            if (line.contains("[")) {
                String[] characters = parseLine(line, colCount);

                for (int i = 0; i < characters.length; i++) {
                    if (characters[i] != null && !characters[i].isEmpty()) {
                        stack.stacks.get(i).items.add(characters[i]);
                    }
                }

            }

            if (line.contains("move")) {
                String[] characters = line.split(" ");

                int j = 0;
                Instruction instruction = Instruction.builder().build();

                for (String word : characters) {
                    if (NumberUtils.isParsable(word)) {
                        switch (++j) {
                            case 1 -> instruction.quantityToMove = Integer.parseInt(word);
                            case 2 -> instruction.startColumn = Integer.parseInt(word) - 1;
                            case 3 -> instruction.endColumn = Integer.parseInt(word) - 1;
                        }
                    }

                }

                stack.instructions.add(instruction);
            }
        }

        for (Stack stackOfLetters : stack.stacks) {
            Collections.reverse(stackOfLetters.items);
        }

        return stack;
    }

    int getNumberOfStacks(List<String> lines) {

        for (String line : lines) {
            if (line.contains("[")) {
                continue;
            }

            String[] columns = line.split(" ");
            String maxValue = columns[columns.length - 1];

            return Integer.parseInt(maxValue);
        }

        return 0;
    }

    String[] parseLine(String line, int columnCount) {

        String[] values = new String[columnCount];
        int i = 0;
        int wordCount = 0;

        while (i <= line.length() - 4) {
            String value = line.substring(i, i + 4);
            i += 4;

            value = value.replace("[", " ");
            value = value.replace("]", " ");
            value = value.strip();
            values[wordCount] = value;
            wordCount++;
        }

        if (wordCount != columnCount) {
            String value = line.substring(i);
            value = value.replace("[", " ");
            value = value.replace("]", " ");
            value = value.strip();

            values[wordCount] = value;
        }

        return values;
    }
}
