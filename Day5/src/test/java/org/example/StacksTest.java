package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StacksTest {

    @Test
    void move_one_from_2_to_1() {

        Stacks stacks = new Stacks();
        Stack stack;

        stack = new Stack();
        stack.items.add("Z");
        stack.items.add("N");
        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("M");
        stack.items.add("C");
        stack.items.add("D");
        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("P");
        stacks.stacks.add(stack);

        Instruction instruction = Instruction.builder().quantityToMove(1).startColumn(1).endColumn(0).build();

        stacks.performInstruction_Crane9000(instruction);

        stack = stacks.stacks.get(0);
        assertEquals(3, stack.items.size());
        assertEquals("Z", stack.items.get(0));
        assertEquals("N", stack.items.get(1));
        assertEquals("D", stack.items.get(2));

        stack = stacks.stacks.get(1);
        assertEquals(2, stack.items.size());
        assertEquals("M", stack.items.get(0));
        assertEquals("C", stack.items.get(1));

        stack = stacks.stacks.get(2);
        assertEquals(1, stack.items.size());
        assertEquals("P", stack.items.get(0));


    }

    @Test
    void move_three_from_1_to_3_crane9000() {

        Stacks stacks = new Stacks();
        Stack stack;

        stack = new Stack();
        stack.items.add("Z");
        stack.items.add("N");
        stack.items.add("D");

        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("M");
        stack.items.add("C");
        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("P");
        stacks.stacks.add(stack);

        Instruction instruction = Instruction.builder().quantityToMove(3).startColumn(0).endColumn(2).build();

        stacks.performInstruction_Crane9000(instruction);

        stack = stacks.stacks.get(0);
        assertEquals(0, stack.items.size());

        stack = stacks.stacks.get(1);
        assertEquals(2, stack.items.size());
        assertEquals("M", stack.items.get(0));
        assertEquals("C", stack.items.get(1));

        stack = stacks.stacks.get(2);
        assertEquals(4, stack.items.size());
        assertEquals("P", stack.items.get(0));
        assertEquals("D", stack.items.get(1));
        assertEquals("N", stack.items.get(2));
        assertEquals("Z", stack.items.get(3));

    }


    @Test
    void move_three_from_1_to_3_crane_9001() {

        Stacks stacks = new Stacks();
        Stack stack;

        stack = new Stack();
        stack.items.add("Z");
        stack.items.add("N");
        stack.items.add("D");

        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("M");
        stack.items.add("C");
        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("P");
        stacks.stacks.add(stack);

        Instruction instruction = Instruction.builder().quantityToMove(3).startColumn(0).endColumn(2).build();

        stacks.performInstruction_Crane9001(instruction);

        stack = stacks.stacks.get(0);
        assertEquals(0, stack.items.size());

        stack = stacks.stacks.get(1);
        assertEquals(2, stack.items.size());
        assertEquals("M", stack.items.get(0));
        assertEquals("C", stack.items.get(1));

        stack = stacks.stacks.get(2);
        assertEquals(4, stack.items.size());
        assertEquals("P", stack.items.get(0));
        assertEquals("Z", stack.items.get(1));
        assertEquals("N", stack.items.get(2));
        assertEquals("D", stack.items.get(3));

    }

    @Test
    void should_get_column_tops() {

        Stacks stacks = new Stacks();
        Stack stack;

        stack = new Stack();
        stack.items.add("C");
        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("M");
        stacks.stacks.add(stack);

        stack = new Stack();
        stack.items.add("P");
        stack.items.add("D");
        stack.items.add("N");
        stack.items.add("Z");

        stacks.stacks.add(stack);

        assertEquals("CMZ", stacks.getValuesFromTopOfStacks());

    }


}