package org.example;

import lombok.Getter;

@Getter
public enum Hand {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    private final String theirCode;
    private final String yourCode;
    private final int scoreIfYouHaveIt;

    Hand(String theirCode, String yourCode, int scoreIfYouHaveIt) {
        this.scoreIfYouHaveIt = scoreIfYouHaveIt;
        this.theirCode = theirCode;
        this.yourCode = yourCode;
    }

}
