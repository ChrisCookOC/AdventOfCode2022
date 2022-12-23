package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CRTTest {

    CRT crt;

    @BeforeEach
    void beforeEach() {
        crt = new CRT();
    }

    @Test
    void should_get_pixel_type() {
        assertEquals(CRTValue.DOT, crt.getPixelType(1, 12));
        assertEquals(CRTValue.DOT, crt.getPixelType(1, 3));
        assertEquals(CRTValue.HASH, crt.getPixelType(1, 0));
        assertEquals(CRTValue.HASH, crt.getPixelType(1, 1));
        assertEquals(CRTValue.HASH, crt.getPixelType(1, 2));
    }

    @Test
    void should_draw_pixel() {
        Cycle cycle = new Cycle(33, 35);
        crt.drawCycle(cycle);

        // CycleNo - 1 = CRT value
        assertEquals(CRTValue.DOT, crt.crt[0][32]);

        cycle = new Cycle(36, 35);
        crt.drawCycle(cycle);

        // CycleNo - 1 = CRT value
        assertEquals(CRTValue.HASH, crt.crt[0][36]);

        cycle = new Cycle(40, 1);
        crt.drawCycle(cycle);

        // CycleNo - 1 = CRT value
        assertEquals(CRTValue.HASH, crt.crt[1][0]);

        cycle = new Cycle(41, 1);
        crt.drawCycle(cycle);

        // CycleNo - 1 = CRT value
        assertEquals(CRTValue.HASH, crt.crt[1][1]);
    }

    @Test
    void should_display_crt() {
        for (CRTValue[] crtValues : crt.crt) {
            Arrays.fill(crtValues, CRTValue.DOT);
        }

        assertEquals("""
                ........................................
                ........................................
                ........................................
                ........................................
                ........................................
                ........................................
                """, crt.display());

    }

}