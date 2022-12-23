package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CPUTest {

    @Test
    void execute_instructions() {
        List<Instruction> instructionList = new ArrayList<>();
        instructionList.add(new Instruction("noop", 1));
        instructionList.add(new Instruction("addx 3", 2));
        instructionList.add(new Instruction("addx -5", 3));

        CPU cpu = new CPU();

        cpu.runInstructions(instructionList);

        assertEquals(5, cpu.currentCycle);
        assertEquals(-1, cpu.currentXRegister);

        assertEquals(5, cpu.cycles.size());

        int cycleCount = 0;

        for (Cycle cycle : cpu.cycles) {
            assertEquals(++cycleCount, cycle.cycleNo);

            int expectedRegisterValue = switch (cycle.cycleNo) {
                case 1, 2 -> 1;
                case 3, 4 -> 4;
                case 5 -> -1;
                default -> 0;
            };

            assertEquals(expectedRegisterValue, cycle.xRegister);
        }
    }

}