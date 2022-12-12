package org.example;

import lombok.Builder;

@Builder
public class Instruction {
    int startColumn;
    int endColumn;
    int quantityToMove;
}
