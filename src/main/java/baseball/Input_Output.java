package baseball;

import java.util.Scanner;

import static baseball.ContinueOrNot.CONTINUE;

public class Input_Output {

  Scanner scanner = new Scanner(System.in);

  public int userNum() {
    System.out.print("숫자를 입력해주세요: ");
    int user;
    try {
      user = scanner.nextInt();
    } catch (Exception e) {
      throw new IllegalArgumentException("answer must be INTEGERS");
    }

    if (user < 100) {
      throw new IllegalArgumentException("answer must be THREE integers");
    }

    return user;
  }

  public boolean isContinue() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int isContinue = scanner.nextInt();
    return isContinue == CONTINUE.getValue();
  }

  public void printResult(int ball, int strike) {
    if (ball == 0 && strike == 0) {
      System.out.println("낫싱");
    } else {
      if (ball != 0) {
        System.out.print(ball + "볼");
      }
      if (strike != 0) {
        System.out.print(strike + "스트라이크");
      }
      System.out.print("\n");
    }
  }
}
