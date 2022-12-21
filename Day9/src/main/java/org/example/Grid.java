package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class Grid {

    public static final int HEADER = 0;
    List<Coordinate> grid = new ArrayList<>();

    Map<Integer, Coordinate> stringCoords = new HashMap<>();

    public int stringEndIndex;

    public Grid(boolean inLongerStringMode) {
        Coordinate origin = new Coordinate(0, 0, true);
        grid.add(origin);

        if (inLongerStringMode) {
            for (int i = 0; i < 10; i++) {
                stringCoords.put(i, origin);
            }
            stringEndIndex = 9;

        } else {
            stringCoords.put(0, origin);
            stringCoords.put(1, origin);
            stringEndIndex = 1;
        }

    }

    void moveHead(String direction) {

        Coordinate currentHead = stringCoords.get(HEADER);

        Coordinate newPosition = switch (direction) {
            case "R" -> new Coordinate(currentHead.row, currentHead.col + 1, false);
            case "L" -> new Coordinate(currentHead.row, currentHead.col - 1, false);
            case "U" -> new Coordinate(currentHead.row + 1, currentHead.col, false);
            case "D" -> new Coordinate(currentHead.row - 1, currentHead.col, false);
            default -> throw new RuntimeException("Not valid direction");
        };

        addCoordinateToGrid(newPosition);
        stringCoords.replace(HEADER, newPosition);

    }

    private void addCoordinateToGrid(Coordinate newPosition) {
        if (!grid.contains(newPosition)) {
            grid.add(newPosition);
        }
    }


    public void performInstruction(Instruction instruction) {
        for (int i = 0; i < instruction.amount; i++) {
            moveHead(instruction.direction);

            for (int j = 0; j < stringEndIndex; j++) {
                if (calculateDistanceBetweenTwoCoords(j, j + 1) > 1) {
                    moveTailToFollowProceeding(j, j + 1);
                }
            }

        }
    }

    public int calculateDistanceBetweenTwoCoords(int indexOfCoord1, int indexOfCoord2) {

        Coordinate coord1 = stringCoords.get(indexOfCoord1);
        Coordinate coord2 = stringCoords.get(indexOfCoord2);

        int diffCol = abs(coord1.col - coord2.col);
        int diffRow = abs(coord1.row - coord2.row);


        if (diffCol == 0 && diffRow == 0) {
            return 0;
        } else if (diffCol == 0) {
            return Math.abs(coord1.row - coord2.row);
        } else if (diffRow == 0) {
            return Math.abs(coord1.col - coord2.col);
        } else if (diffRow == 1 && diffCol == 1) {
            return 1;
        } else {
            return Math.max(diffRow, diffCol);
        }
    }

    public void moveTailToFollowProceeding(int indexToFollow, int indexToMove) {
        Coordinate newCoordForTail;
        Coordinate coordinateToFollow = stringCoords.get(indexToFollow);
        Coordinate coordinateToMove = stringCoords.get(indexToMove);

        int newCol = coordinateToMove.col;
        int newRow = coordinateToMove.row;

        boolean needsToMoveHorizontally;
        boolean needsToMoveVertically;

        needsToMoveHorizontally = coordinateToFollow.col != coordinateToMove.col;
        needsToMoveVertically = coordinateToFollow.row != coordinateToMove.row;

        if (needsToMoveHorizontally) {
            if (coordinateToFollow.col > coordinateToMove.col) {
                newCol = coordinateToMove.col + 1;
            } else {
                newCol = coordinateToMove.col - 1;
            }
        }
        if (needsToMoveVertically) {
            if (coordinateToFollow.row > coordinateToMove.row) {
                newRow = coordinateToMove.row + 1;
            } else {
                newRow = coordinateToMove.row - 1;
            }
        }

        newCoordForTail = new Coordinate(newRow, newCol, indexToMove == stringEndIndex);

        addCoordinateToGrid(newCoordForTail);
        stringCoords.replace(indexToMove, newCoordForTail);

    }

    public int countVisited() {
        return (int) grid.stream().filter(coordinate -> coordinate.tailVisited).count();
    }
}
