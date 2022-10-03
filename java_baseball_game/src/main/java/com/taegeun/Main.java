package com.taegeun;

public class Main {
    public static void main(String[] args){
        while (true){
            GameManager gameManager = new GameManager();

            gameManager.generateGame();
            System.out.println(gameManager.getComNum());
            gameManager.gameStart();

            if (!gameManager.resumeGame()){
                break;
            }

        }







    }
}