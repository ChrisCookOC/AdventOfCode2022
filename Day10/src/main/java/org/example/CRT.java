package org.example;

import java.util.Arrays;

public class CRT {

    CRTValue[][] crt = new CRTValue[6][40];

    public CRT() {
        for (CRTValue[] crtValues : crt) {
            Arrays.fill(crtValues, CRTValue.DOT);
        }

        crt[0][0] = CRTValue.HASH;
    }


    public CRTValue getPixelType(int currentCycle, int currentXRegister) {
        int vertical = currentCycle % 40;
        if (vertical >= currentXRegister - 1 && vertical <= currentXRegister + 1) {
            return CRTValue.HASH;
        }

        return CRTValue.DOT;
    }

    public void drawCycle(Cycle cycle) {
        int row = (int) (Math.floor(cycle.cycleNo / 40.0));
        int col = Math.max((cycle.cycleNo % 40), 0);

        //if (col == 0 && row !=0)
        // { col = 39;
        //     row = row -1;};

        //0,0 => cycle 1
        //1,0 => cycle 2
        //39,0 => cycle 40

        CRTValue square = getPixelType(cycle.cycleNo, cycle.xRegister);

        if (row == 6) {
            return;
        }
        crt[row][col] = square;

    }

    public String display() {
        StringBuilder display = new StringBuilder();

        for (CRTValue[] crtValues : crt) {
            for (CRTValue crtValue : crtValues) {
                display.append(crtValue.getValue());
            }
            display.append("\n");
        }

        return display.toString();
    }
}
