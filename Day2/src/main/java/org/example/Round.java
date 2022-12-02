package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Round {

    public Hand player1;
    public Hand player2;
    public Result result;

    public Round(Hand player1, Result result) {
        this.player1 = player1;
        this.result = result;
    }
}
