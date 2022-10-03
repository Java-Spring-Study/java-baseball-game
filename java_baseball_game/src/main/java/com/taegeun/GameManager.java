package com.taegeun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private List<Integer> playerNum = new ArrayList<>();
    private List<Integer> comNum = new ArrayList<>();
    public void generateGame(){
        Computer com = new Computer();
        // 컴퓨터 숫자 생성.
        comNum = com.randNum();
    }
    public void gameStart(){
        GameEngine gameEngine = new GameEngine();
        gameEngine.setComNum(comNum);

        while(true){
            //플레이어 숫자 입력
            Player player = new Player();
            try{
                playerNum = player.inputNum();
            }catch (Exception e){
                System.out.println("잘못된 입력입니다.");
                System.exit(0);
            }

            gameEngine.setPlayerNum(playerNum);
            gameEngine.printScore();
            if (!gameEngine.continueGame()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
    public boolean resumeGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                return true;
           default:
                return false;
        }

    }
    public List<Integer> getPlayerNum(){
        return playerNum;
    }
    public List<Integer> getComNum(){
        return comNum;
    }
}
