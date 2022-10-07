package com.hyuunnn.baseball;

import java.util.*;

public class Baseball {

  final private int GAME_RESTART = 1;
  final private int GAME_END = 2;
  final private int BALL_LENGTH = 3;

  private String randomize() {
    final Random r = new Random();
    final Set<Integer> numberList = new LinkedHashSet<>();

    while (numberList.size() < BALL_LENGTH) {
      numberList.add(r.nextInt(9) + 1);
    }

    return numberList.toString().replaceAll("[^0-9]", "");
  }

  private boolean checkStrike(final char randomNumberAt, final char inputNumberAt) {
    return randomNumberAt == inputNumberAt;
  }

  private boolean checkBall(final String inputNumber, final char randomNumberAt) {
    return inputNumber.contains(String.valueOf(randomNumberAt));
  }

  private boolean checkThreeStrike(final int strike) {
    return strike == BALL_LENGTH;
  }

  private void printBaseballResult(final int strike, final int ball) {
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

  private boolean checkBaseball(final String inputNumber, final String randomNumber) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < randomNumber.length(); i++) {
      final char randomNumberAt = randomNumber.charAt(i);
      final char inputNumberAt = inputNumber.charAt(i);

      if (checkStrike(randomNumberAt, inputNumberAt)) {
        strike++;
      } else if (checkBall(inputNumber, randomNumberAt)) {
        ball++;
      }
    }

    printBaseballResult(strike, ball);
    return checkThreeStrike(strike);
  }

  private String inputStringNumber(final Scanner scanner) {
    System.out.print("숫자를 입력해주세요 : ");
    return scanner.nextLine();
  }

  private void validateLength(final String inputNumber) {
    if (inputNumber.length() != BALL_LENGTH) {
      throw new IllegalStateException("입력 값의 길이가 3이 아닙니다.");
    }
  }

  private void validateNumberRange(final String inputNumber) {
    if (!inputNumber.matches("^[0-9]*$")) {
      throw new IllegalStateException("입력 값이 숫자가 아닙니다.");
    }
  }

  private void validateInputNumber(final String inputNumber) {
    validateLength(inputNumber);
    validateNumberRange(inputNumber);
  }

  private void checkRestart(final Scanner scanner) {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    final int number = scanner.nextInt();

    if (number == GAME_RESTART) {
      run();
    } else if (number == GAME_END) {
      System.exit(0);
    } else {
      throw new IllegalStateException("입력 값이 1 또는 2가 아닙니다.");
    }
  }

  private void start(final String randomNumber) {
    final Scanner scanner = new Scanner(System.in);
    while (true) {
      final String inputNumber = inputStringNumber(scanner);
      validateInputNumber(inputNumber);

      if (checkBaseball(inputNumber, randomNumber)) {
        break;
      }
    }
    checkRestart(scanner);
    scanner.close();
  }

  public void run() {
    start(randomize());
  }
}
