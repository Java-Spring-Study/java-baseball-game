package com.taegeun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    List<Integer> computerNumber = new ArrayList<>();

    public List<Integer> randomNumber() {
        int num;
        Random random = new Random();

        while (computerNumber.size() != 3) {
            num = random.nextInt(9) + 1;
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
        return computerNumber;
    }
}
