package com.taegeun;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private List<Integer> playerNum = new ArrayList<>();
    private List<Integer> comNum = new ArrayList<>();
    public void setComNum(List<Integer> comNum) {
        this.comNum = comNum;
    }
    public void setPlayerNum(List<Integer> playerNum){
        this.playerNum = playerNum;
    }

    public int checkStrike() {
        int total=0;
        for (int i=0; i<playerNum.size(); i++){
            if (playerNum.get(i) == comNum.get(i)){
                total++;
            }
        }
        return total;
    }
    public int checkBall() {
        int total=0;
        for (int i=0; i<playerNum.size(); i++){
            if (playerNum.get(i) != comNum.get(i) && comNum.contains(playerNum.get(i))){
                total++;
            }
        }
        return total;
    }
    public boolean continueGame(){
        if (checkStrike()!=3){
            return true;
        }
        else{
            return false;
        }
    }
    public void printScore() {
        int ball = checkBall();
        int strike = checkStrike();
        if (ball !=0){
            System.out.print(ball + "볼 ");
        }
        if (strike !=0){
            System.out.print(strike + "스트라이크");
        }
        if (ball==0 && strike==0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
}

