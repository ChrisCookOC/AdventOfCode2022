package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileParser {

    private final InputStream file;

    public FileParser(InputStream file) {
        this.file = file;
    }

    public Grid buildGrid() throws IOException {

        Grid grid = new Grid();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            int rowCount = 0;
            int colCount = 0;
            while ((line = reader.readLine()) != null) {
                ++rowCount;

                for (int i = 0; i < line.length(); i++) {
                    int height = Integer.parseInt(line.substring(i, i + 1));
                    Coordinate coordinate = new Coordinate(rowCount, i + 1);
                    grid.grid.put(coordinate, new Tree(height));
                }

                colCount = line.length();
            }
            grid.gridHeight = rowCount;
            grid.gridWidth = colCount;
        }
        return grid;
    }

}
