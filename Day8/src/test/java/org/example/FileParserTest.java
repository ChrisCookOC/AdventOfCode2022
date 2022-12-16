package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserTest {

    @Test
    void should_build_grid() {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input-test.txt")) {
            FileParser fileParser = new FileParser(fileInputStream);

            Grid grid = fileParser.buildGrid();

            assertEquals(5, grid.gridHeight);
            assertEquals(5, grid.gridWidth);

            assertEquals(3, grid.grid.get(new Coordinate(1, 1)).height);
            assertEquals(0, grid.grid.get(new Coordinate(1, 2)).height);
            assertEquals(3, grid.grid.get(new Coordinate(1, 3)).height);
            assertEquals(7, grid.grid.get(new Coordinate(1, 4)).height);
            assertEquals(3, grid.grid.get(new Coordinate(1, 5)).height);

            assertEquals(2, grid.grid.get(new Coordinate(2, 1)).height);
            assertEquals(5, grid.grid.get(new Coordinate(2, 2)).height);
            assertEquals(5, grid.grid.get(new Coordinate(2, 3)).height);
            assertEquals(1, grid.grid.get(new Coordinate(2, 4)).height);
            assertEquals(2, grid.grid.get(new Coordinate(2, 5)).height);

            assertEquals(6, grid.grid.get(new Coordinate(3, 1)).height);
            assertEquals(5, grid.grid.get(new Coordinate(3, 2)).height);
            assertEquals(3, grid.grid.get(new Coordinate(3, 3)).height);
            assertEquals(3, grid.grid.get(new Coordinate(3, 4)).height);
            assertEquals(2, grid.grid.get(new Coordinate(3, 5)).height);

            assertEquals(3, grid.grid.get(new Coordinate(4, 1)).height);
            assertEquals(3, grid.grid.get(new Coordinate(4, 2)).height);
            assertEquals(5, grid.grid.get(new Coordinate(4, 3)).height);
            assertEquals(4, grid.grid.get(new Coordinate(4, 4)).height);
            assertEquals(9, grid.grid.get(new Coordinate(4, 5)).height);

            assertEquals(3, grid.grid.get(new Coordinate(5, 1)).height);
            assertEquals(5, grid.grid.get(new Coordinate(5, 2)).height);
            assertEquals(3, grid.grid.get(new Coordinate(5, 3)).height);
            assertEquals(9, grid.grid.get(new Coordinate(5, 4)).height);
            assertEquals(0, grid.grid.get(new Coordinate(5, 5)).height);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}