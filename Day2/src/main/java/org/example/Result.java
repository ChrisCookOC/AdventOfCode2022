package org.example;

import lombok.Getter;

@Getter
public enum Result {
    LOSE("X", 0),
    DRAW("Y", 3),
    WIN("Z", 6);

    private final String code;
    private final int score;

    Result(String code, int score) {
        this.code = code;

        this.score = score;
    }

}
