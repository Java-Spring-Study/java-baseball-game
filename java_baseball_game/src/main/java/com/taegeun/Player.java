package com.taegeun;

import java.util.Scanner;

public class Player {
    int myNum;
    public int inputNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        myNum = sc.nextInt();

        if (Integer.toString(myNum).length() != 3){
            throw new IllegalArgumentException("3자리수가 아닙니다.");
        }

        return myNum;
    }
}
