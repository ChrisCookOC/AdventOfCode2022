package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Instruction {
    String direction;
    int amount;

    public Instruction(String direction, String amount) {
        this.direction = direction;
        this.amount = Integer.parseInt(amount);
    }
}
