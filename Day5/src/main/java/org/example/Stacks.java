package org.example;

import java.util.ArrayList;
import java.util.List;

public class Stacks {

    List<Stack> stacks = new ArrayList<>();

    List<Instruction> instructions = new ArrayList<>();

    public void performInstruction_Crane9000(Instruction instruction) {

        List<String> sourceColumn = stacks.get(instruction.startColumn).items;
        List<String> destColumn = stacks.get(instruction.endColumn).items;

        for (int i = 0; i < instruction.quantityToMove; i++) {

            int index = sourceColumn.size() - 1;
            String valueToMove = sourceColumn.get(index);
            destColumn.add(valueToMove);
            sourceColumn.remove(index);
        }

    }

    public void performInstruction_Crane9001(Instruction instruction) {

        List<String> sourceColumn = stacks.get(instruction.startColumn).items;
        List<String> destColumn = stacks.get(instruction.endColumn).items;

        for (int i = instruction.quantityToMove; i > 0; i--) {

            int index = sourceColumn.size() - i;
            String valueToMove = sourceColumn.get(index);
            destColumn.add(valueToMove);
            sourceColumn.remove(index);
        }

    }

    public String getValuesFromTopOfStacks() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Stack stack : stacks) {
            stringBuilder.append(stack.items.get(stack.items.size() - 1));
        }

        return stringBuilder.toString();
    }
}
