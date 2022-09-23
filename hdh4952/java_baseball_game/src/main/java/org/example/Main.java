package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int[] answer = new int[]{0, 0, 0};
    private static boolean[] isExist = new boolean[10];

    public static void main(String[] args) {

        while(true) {
            setting_answer();
            baseball_game();
            System.out.print("게임을 완전히 종료하려면 0, 다시 시작하려면 1을 눌러주세요.");
            Scanner sc = new Scanner(System.in);
            try {
                int nxt = Integer.parseInt(sc.nextLine());
                if(nxt == 0) System.exit(0);
                else if(nxt == 1) continue;
            } catch (IllegalArgumentException e) {
                System.exit(0);
            }



        }
    }

    public static void baseball_game() {
        boolean isPlay = true;
        Scanner sc = new Scanner(System.in);
        int number;
        while(isPlay) {
            int strike = 0, ball = 0;
            System.out.print("숫자를 입력해주세요 : ");
            try {
                number = Integer.parseInt(sc.nextLine());
                for(int i=2 ; i>=0 ; i--) {
                    int now = number % 10;
                    number /= 10;
                    if(isExist[now]) {
                        if(answer[i] == now) strike++;
                        else ball++;
                    }
                }

                if(strike > 0 || ball > 0) {
                    if(ball > 0) {
                        System.out.print(ball);
                        System.out.print("볼 ");
                    }
                    if(strike > 0) {
                        System.out.print(strike);
                        System.out.println("스트라이크");
                    }
                    if(strike == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        isPlay = false;
                    }
                } else System.out.println("낫싱");
            } catch (IllegalArgumentException e) {
                System.exit(0);
            }
        }
    }

    public static void setting_answer() {
        for(int i=1 ; i<10 ; i++) isExist[i] = false;

        Random random = new Random();
        answer[0] = random.nextInt(8) + 1;
        while (answer[1] == 0) {
            int r = random.nextInt(8) + 1;
            if(answer[0] != r) answer[1] = r;
        }

        while (answer[2] == 0) {
            int r = random.nextInt(8) + 1;
            if(answer[0] != r && answer[1] != r) answer[2] = r;
        }

        isExist[answer[0]] = isExist[answer[1]] = isExist[answer[2]] = true;
    }
}