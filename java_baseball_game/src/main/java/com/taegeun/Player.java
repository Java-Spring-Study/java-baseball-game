package com.taegeun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    List<Integer> myNum = new ArrayList<>();
    public List<Integer> inputNum(){
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        num = sc.nextInt();

        myNum.add((num/100)%10);
        myNum.add((num/10)%10);
        myNum.add(num%10);

        if (myNum.get(0) == 0) {

            throw new IllegalArgumentException("3자리 수를 입력하세요!");
        }

        return myNum;
    }
}
