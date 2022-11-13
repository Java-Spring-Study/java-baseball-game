package com.taegeun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    List<Integer> playerNumber = new ArrayList<>();

    public List<Integer> inputNumber() {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        num = sc.nextInt();

        playerNumber.add((num / 100) % 10);
        playerNumber.add((num / 10) % 10);
        playerNumber.add(num % 10);

        if (playerNumber.get(0) == 0) {
            throw new IllegalArgumentException("3자리 수를 입력하세요!");
        }
        return playerNumber;
    }
}
