package org.example;

public class WinCalculator {

    public static int getResultScore(Hand player1, Hand player2) {
        if (player1 == player2){
            return 3;
        }

        if ((player1 == Hand.ROCK && player2 == Hand.PAPER)
            || (player1==Hand.PAPER && player2==Hand.SCISSORS)
            || player1 == Hand.SCISSORS && player2==Hand.ROCK) {
            return 6;
        }

        return 0;
    }

    public static int getScore(Round round){
        return getScore(round.getPlayer1(), round.getPlayer2());
    }

    public static int getScore(Hand player1, Hand player2){
        return getResultScore(player1, player2) + player2.getScoreIfYouHaveIt();
    }
}
