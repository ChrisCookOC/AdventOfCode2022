package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CPU {

    int currentCycle = 0;
    int currentXRegister = 1;

    Set<Cycle> cycles = new TreeSet<>();

    CRT crt = new CRT();

    void runInstructions(List<Instruction> instructionList) {

        for (Instruction instruction : instructionList) {
            if (Objects.equals(instruction.instruction, "noop")) {
                addNewCycle(0);
            } else {
                String[] parts = instruction.instruction.split(" ");
                addNewCycle(0);
                addNewCycle(Integer.parseInt(parts[1]));
            }
        }
    }

    private void addNewCycle(int incrementRegisterBy) {
        currentXRegister += incrementRegisterBy;
        Cycle newCycle = new Cycle(++currentCycle, currentXRegister);
        cycles.add(newCycle);

        crt.drawCycle(newCycle);
    }

}
