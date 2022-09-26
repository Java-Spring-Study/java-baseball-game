package baseball.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballTool {

  private final Random random = new Random();
  private final Scanner sc = new Scanner(System.in);
  private List<Integer> solution = new ArrayList<Integer>(List.of(0, 0, 0));
  private List<Integer> inputNums = new ArrayList<Integer>(List.of(0, 0, 0));
  private int strike = 0;
  private int ball = 0;

  public void reset() {
    strike = 0;
    ball = 0;
  }

  public void makeRamdomNumbers() {
    for (int i = 0; i < 3; i++) {
      solution.set(i, random.nextInt(9) + 1);
      for (int j = 0; j < i; j++) {
        if (solution.get(j) == solution.get(i)) {
          i--;
          break;
        }
      }
    }
  }

  public void setInputNumber() throws IllegalArgumentException {
    String inputString;
    System.out.print("숫자를 입력해주세요 : ");
    inputString = sc.next();

    int num;
    if (inputString != null && inputString.matches("[1-9]+")) {
      num = Integer.parseInt(inputString);
      if (num < 1000 && num > 99) {
        setInputNums(num);  //input된 number를 배열로 저장
      } else {
        throw new IllegalArgumentException();
      }
    } else {
      throw new IllegalArgumentException();
    }
  }

  private void setInputNums(int num) {
    for (int i = 2; i >= 0; i--) {
      inputNums.set(i, num % 10);
      num /= 10;
    }
  }

  public boolean checkStrike() {
    return strike == 3;
  }

  public void calcResult() {
    reset();
    for (int i = 0; i < inputNums.size(); i++) {
      if (inputNums.get(i) == solution.get(i)) {
        strike++;
      } else {
        checkBall(i);
      }
    }
  }

  private void checkBall(int index) {
    for (int k : solution) {
      if (inputNums.get(index) == k) {
        ball++;
        break;
      }
    }
  }

  public void printResult() {
    String resultStr = "";
    if (ball > 0) {
      resultStr += ball + "볼 ";
    }
    if (strike > 0) {
      resultStr += strike + "스트라이크";
    }
    if (ball == 0 && strike == 0) {
      resultStr = "낫싱";
    }
    System.out.println(resultStr);
  }

  public int getSignalCode() throws IllegalArgumentException {
    System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String signalCode = sc.next();

    if (signalCode != null && signalCode.matches("[1-2]")) {
      return Integer.parseInt(signalCode);
    } else {
      throw new IllegalArgumentException();
    }
  }
}
