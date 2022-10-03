package com.taegeun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    List<Integer> comNum = new ArrayList<>();
    public List<Integer> randNum() {
        int num;
        Random random = new Random();

        while (true) {
            if (comNum.size() == 3) break;
            num = random.nextInt(9)+1;
            if (!comNum.contains(num)){
                comNum.add(num);
            }
        }
        return comNum;
    }
}
