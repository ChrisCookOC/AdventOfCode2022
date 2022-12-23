package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Cycle implements Comparable {

    int cycleNo;
    int xRegister;

    @Override
    public int compareTo(Object o) {
        return cycleNo;
    }

    public int calculateSignalStrength() {
        return (cycleNo + 1) * xRegister;
    }
}
