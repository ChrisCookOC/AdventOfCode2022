package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grid {

    Map<Coordinate, Tree> grid = new HashMap<>();
    int gridHeight;
    int gridWidth;

    boolean isEdgeTree(Coordinate coordinate) {
        if (coordinate.col == 1) {
            return true;
        }
        if (coordinate.row == 1) {
            return true;
        }
        if (coordinate.col == gridWidth) {
            return true;
        }
        if (coordinate.row == gridHeight) {
            return true;
        }

        return false;
    }

    protected boolean isTreeVisible(Coordinate coordinate) {
        if (isEdgeTree(coordinate)) {
            return true;
        }

        if (isVisibleFromLeft(coordinate) || isVisibleFromRight(coordinate)
                || isVisibleFromBelow(coordinate) || isVisibleFromTop(coordinate)) {
            return true;
        }

        return false;
    }

    public int howManyTreesAreVisible() {
        Set<Coordinate> coordinateList = grid.keySet();
        int howManyVisible = 0;

        for (Coordinate coordinate : coordinateList) {
            if (isTreeVisible(coordinate)) {
                ++howManyVisible;
            }
        }

        return howManyVisible;
    }

    protected boolean isVisibleFromLeft(Coordinate coordinate) {
        int column = coordinate.col;
        Tree thisTree = grid.get(coordinate);

        for (int i = column - 1; i > 0; i--) {
            Tree comparisonTree = grid.get(new Coordinate(coordinate.row, i));
            if (comparisonTree == null) {
                break;
            }
            if (comparisonTree.height >= thisTree.height) {
                return false;
            }
        }

        return true;
    }

    protected boolean isVisibleFromRight(Coordinate coordinate) {
        int column = coordinate.col;
        Tree thisTree = grid.get(coordinate);

        for (int i = column + 1; i < gridWidth + 1; i++) {
            Tree comparisonTree = grid.get(new Coordinate(coordinate.row, i));
            if (comparisonTree == null) {
                break;
            }
            if (comparisonTree.height >= thisTree.height) {
                return false;
            }
        }

        return true;
    }

    protected boolean isVisibleFromTop(Coordinate coordinate) {
        int row = coordinate.row;
        Tree thisTree = grid.get(coordinate);

        for (int i = row - 1; i > 0; i--) {
            Tree comparisonTree = grid.get(new Coordinate(i, coordinate.col));
            if (comparisonTree == null) {
                break;
            }
            if (comparisonTree.height >= thisTree.height) {
                return false;
            }
        }

        return true;
    }

    protected boolean isVisibleFromBelow(Coordinate coordinate) {
        int row = coordinate.row;
        Tree thisTree = grid.get(coordinate);

        for (int i = row + 1; i < gridHeight + 1; i++) {
            Tree comparisonTree = grid.get(new Coordinate(i, coordinate.col));
            if (comparisonTree == null) {
                break;
            }
            if (comparisonTree.height >= thisTree.height) {
                return false;
            }
        }

        return true;
    }

    public int calculateVisibilityAbove(Coordinate coordinate) {

        int count = 0;

        int row = coordinate.row;
        Tree thisTree = grid.get(coordinate);

        for (int i = row - 1; i > 0; i--) {
            Tree comparisonTree = grid.get(new Coordinate(i, coordinate.col));
            if (comparisonTree == null) {
                break;
            }
            count++;
            if (comparisonTree.height >= thisTree.height) {
// Can't see any further
                break;
            }
        }

        return count;
    }

    public int calculateVisibilityLeft(Coordinate coordinate) {

        int count = 0;

        int column = coordinate.col;
        Tree thisTree = grid.get(coordinate);

        for (int i = column - 1; i > 0; i--) {
            Tree comparisonTree = grid.get(new Coordinate(coordinate.row, i));
            if (comparisonTree == null) {
                break;
            }
            count++;
            if (comparisonTree.height >= thisTree.height) {
// Can't see any further
                break;
            }
        }

        return count;
    }

    public int calculateVisibilityBelow(Coordinate coordinate) {

        int count = 0;

        int row = coordinate.row;
        Tree thisTree = grid.get(coordinate);

        for (int i = row + 1; i < gridHeight + 1; i++) {
            Tree comparisonTree = grid.get(new Coordinate(i, coordinate.col));
            if (comparisonTree == null) {
                break;
            }
            count++;
            if (comparisonTree.height >= thisTree.height) {
// Can't see any further
                break;
            }
        }

        return count;
    }

    public int calculateVisibilityRight(Coordinate coordinate) {

        int count = 0;

        int column = coordinate.col;
        Tree thisTree = grid.get(coordinate);

        for (int i = column + 1; i < gridWidth + 1; i++) {
            Tree comparisonTree = grid.get(new Coordinate(coordinate.row, i));
            if (comparisonTree == null) {
                break;
            }
            count++;
            if (comparisonTree.height >= thisTree.height) {
// Can't see any further
                break;
            }
        }

        return count;
    }

    public int getScenicScore(Coordinate coordinate) {
        return calculateVisibilityAbove(coordinate) * calculateVisibilityBelow(coordinate)
                * calculateVisibilityLeft(coordinate) * calculateVisibilityRight(coordinate);
    }

    public int getHighestScenicScore() {
        Set<Coordinate> coordinateList = grid.keySet();
        int highestScore = 0;

        for (Coordinate coordinate : coordinateList) {
            int score = getScenicScore(coordinate);
            if (score > highestScore) {
                highestScore = score;
            }
        }

        return highestScore;
    }
}
