package com.taegeun;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private List<Integer> playerNumber = new ArrayList<>();
    private List<Integer> computerNumber = new ArrayList<>();

    public void setComputerNumber(List<Integer> n) {
        this.computerNumber = n;
    }

    public void setPlayerNumber(List<Integer> n) {
        this.playerNumber = n;
    }

    public int checkStrike() {
        int total = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (playerNumber.get(i) == computerNumber.get(i)) {
                total++;
            }
        }
        return total;
    }

    public int checkBall() {
        int total = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (playerNumber.get(i) != computerNumber.get(i) && computerNumber.contains(playerNumber.get(i))) {
                total++;
            }
        }
        return total;
    }

    public boolean continueGame() {
        return checkStrike() != 3;
    }

    public void printScore() {
        int ball = checkBall();
        int strike = checkStrike();
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}

