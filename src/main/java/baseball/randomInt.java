package baseball;

import java.util.Random;

public class randomInt {
    int number;

    randomInt() {
        Random random = new Random();
        while(true) {
            number = random.nextInt(999);
            int com1, com2, com3;
            com1 = number % 10;
            com2 = (number / 10) % 10;
            com3 = number / 100;
            if (com1 != com2 && com2 != com3 && com3 != com1) break;
        }
    }

    public int countStrike(int user) {
        int strike = 0;
        int answer = number;

        while (answer > 0) {
            if (answer % 10 == user % 10) strike++;
            answer /= 10;
            user /= 10;
        }

        return strike;
    }
    public int countSameNum(int user) {
        int howMany = 0;
        int answer = number;

        while (answer > 0) {
            if (answer % 10 == user % 10) howMany++;
            if (answer % 10 == (user / 10) % 10) howMany++;
            if (answer % 10 == user / 100) howMany++;
            answer /= 10;
        }

        return howMany;
    }
}
