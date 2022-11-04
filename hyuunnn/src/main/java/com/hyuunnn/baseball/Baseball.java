package com.hyuunnn.baseball;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Random;


public class Baseball {

  final private int GAME_RESTART = 1;
  final private int GAME_END = 2;
  final private int BALL_LENGTH = 3;
  final private Scanner scanner = new Scanner(System.in);

  private String randomize() {
    Random r = new Random();
    Set<Integer> numberList = new LinkedHashSet<>();

    while (numberList.size() < BALL_LENGTH) {
      numberList.add(r.nextInt(9) + 1);
    }

    return numberList.toString().replaceAll("[^0-9]", "");
  }

  private boolean checkStrike(char randomNumberAt, char inputNumberAt) {
    return randomNumberAt == inputNumberAt;
  }

  private boolean checkBall(String inputNumber, char randomNumberAt) {
    return inputNumber.contains(String.valueOf(randomNumberAt));
  }

  private boolean checkThreeStrike(int strike) {
    return strike == BALL_LENGTH;
  }

  private void printBaseballResult(int strike, int ball) {
    if (strike == 0 && ball == 0) {
      System.out.println("낫싱");
    } else if (strike == 0 && ball > 0) {
      System.out.printf("%d볼\n", ball);
    } else if (strike > 0 && ball == 0) {
      System.out.printf("%d스트라이크\n", strike);
    } else {
      System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }
  }

  private boolean checkBaseball(String inputNumber, String randomNumber) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < randomNumber.length(); i++) {
      char randomNumberAt = randomNumber.charAt(i);
      char inputNumberAt = inputNumber.charAt(i);

      if (checkStrike(randomNumberAt, inputNumberAt)) {
        strike++;
      } else if (checkBall(inputNumber, randomNumberAt)) {
        ball++;
      }
    }

    printBaseballResult(strike, ball);
    return checkThreeStrike(strike);
  }

  private String inputStringNumber() {
    System.out.print("숫자를 입력해주세요 : ");
    return scanner.nextLine();
  }

  private void validateLength(String inputNumber) {
    if (inputNumber.length() != BALL_LENGTH) {
      throw new IllegalStateException("입력 값의 길이가 3이 아닙니다.");
    }
  }

  private void validateNumberRange(String inputNumber) {
    if (!inputNumber.matches("^[0-9]*$")) {
      throw new IllegalStateException("입력 값이 숫자가 아닙니다.");
    }
  }

  private void validateInputNumber(String inputNumber) {
    validateLength(inputNumber);
    validateNumberRange(inputNumber);
  }

  private void checkRestart() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int number = Integer.parseInt(scanner.nextLine());

    if (number == GAME_RESTART) {
      run();
    } else if (number == GAME_END) {
      scanner.close();
      System.exit(0);
    } else {
      throw new IllegalStateException("입력 값이 1 또는 2가 아닙니다.");
    }
  }

  private void start(String randomNumber) {
    while (true) {
      String inputNumber = inputStringNumber();
      validateInputNumber(inputNumber);

      if (checkBaseball(inputNumber, randomNumber)) {
        break;
      }
    }
    checkRestart();
  }

  public void run() {
    start(randomize());
  }
}
