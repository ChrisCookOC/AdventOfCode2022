package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("RedundantIfStatement")
@Getter
@Setter
@Builder
public class Pair {
    private Range elf1;
    private Range elf2;

    @Override
    public String toString() {
        return elf1.toString() + "," + elf2.toString();
    }

    public boolean doesFullyContainOther() {

        if (elf1.getStart() <= elf2.getStart() && elf1.getEnd() >= elf2.getEnd()) {
            return true;
        }

        if (elf1.getStart() >= elf2.getStart() && elf1.getEnd() <= elf2.getEnd()) {
            return true;
        }

        return false;
    }

    public boolean doesOverlap() {

        if (doesFullyContainOther()) {
            return true;
        }

        if (elf1.getStart() <= elf2.getStart() && elf1.getEnd() >= elf2.getStart() && elf1.getEnd() <= elf2.getEnd()) {
            return true;
        }

        if (elf1.getStart() >= elf2.getStart() && elf1.getStart() <= elf2.getEnd() && elf1.getEnd() >= elf2.getEnd()) {
            return true;
        }

        return false;

    }
}
