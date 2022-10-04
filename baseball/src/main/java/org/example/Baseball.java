package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baseball {
    private static String computerNum;
    private static Scanner scanner = new Scanner(System.in);
    public static void gameInit(){
        computerNum = getComputerNum();
    }

    public static void gameStart(){
        int restart = 1;
        while(restart == 1){
            gameProcessing();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try{
                restart = scanner.nextInt();
            }catch (Exception e){
                System.out.println("정수 입력 부탁!");
            }

        }
        scanner.close();
    }

    private static void gameProcessing(){
        int strike = 0;
        int ball = 0;
        while(strike != 3){
            System.out.print("숫자를 입력해주세요 : ");
            String answer = getUserNum();
            strike = getStrike(answer);
            ball = getBall(answer);
            if(ball != 0 && strike != 0){
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if(ball != 0) {
                System.out.println(ball + "볼");
            } else if(strike != 0){
                System.out.println(strike + "스트라이크");
            }else {
                System.out.println("낫싱");
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private static String getComputerNum(){
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(arr);
        String result = Integer.toString(arr.get(0));
        result += Integer.toString(arr.get(1));
        result += Integer.toString(arr.get(2));
        return result;
    }

    private static String getUserNum(){
        String response = scanner.next();
        try{
            if(isNumeric(response)){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("정수 입력 부탁!");
        }
        return response;
    }

    private static boolean isNumeric(String data) {
        try{
            Integer.parseInt(data);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }

    private static int getStrike(String data){
        int strike = 0;
        for(int i=0; i<3; i++){
            if(data.charAt(i) == computerNum.charAt(i))
                strike++;
        }
        return strike;
    }

    private static int getBall(String data){
        int ball = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                ball += checkBall(data, i, j);
            }
        }
        return ball;
    }

    private static int checkBall(String data, int i, int j){
        if(i != j && data.charAt(i) == computerNum.charAt(j)) return 1;
        return 0;
    }

}
