package org.example;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@AllArgsConstructor
@EqualsAndHashCode(cacheStrategy = EqualsAndHashCode.CacheStrategy.LAZY)
public class Coordinate {

    int row;
    int col;

    boolean tailVisited;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && col == that.col && tailVisited == that.tailVisited;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, tailVisited);
    }
}
