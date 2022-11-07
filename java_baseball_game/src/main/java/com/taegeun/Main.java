package com.taegeun;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        do {
            gameManager.generateGame();
            gameManager.gameStart();
        } while (gameManager.isResumeGame());
    }
}
//computer 숫자를 알고 싶을 때...
//System.out.println(gameManager.getComNum());