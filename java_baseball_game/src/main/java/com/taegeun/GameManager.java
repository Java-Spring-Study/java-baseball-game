package com.taegeun;

import java.lang.Enum;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private List<Integer> playerNumber = new ArrayList<>();
    private List<Integer> computerNumber = new ArrayList<>();


    public void generateGame() {
        Computer com = new Computer();
        // 컴퓨터 숫자 생성.
        computerNumber = com.randomNumber();
    }

    public void gameStart() {
        GameEngine gameEngine = new GameEngine();
        gameEngine.setComputerNumber(computerNumber);

        while (true) {
            //플레이어 숫자 입력
            Player player = new Player();
            try {
                playerNumber = player.inputNumber();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                System.exit(0);
            }

            gameEngine.setPlayerNumber(playerNumber);
            gameEngine.printScore();
            if (!gameEngine.continueGame()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public boolean isResumeGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int signal = sc.nextInt();

        return signal == GameSignal.RESTART.getSignal();
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
