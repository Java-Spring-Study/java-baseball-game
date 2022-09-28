package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntSupplier;
import org.example.BaseballGame.BaseballGameResult;
import org.jetbrains.annotations.NotNull;

public class Main {

  static boolean confirmEnd(@NotNull final IntSupplier getInput) {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    int input = getInput.getAsInt();
    if (input != 1 && input != 2) {
      throw new IllegalArgumentException("answer out of range");
    }

    return input == 2;
  }

  static void printGameResult(BaseballGameResult result) {
    if (result.ball == 0 && result.strike == 0) {
      System.out.println("낫싱");
    } else {
      if (result.ball != 0) {
        System.out.printf("%d볼 ", result.ball);
      }
      if (result.strike != 0) {
        System.out.printf("%d스트라이크", result.strike);
      }
      System.out.println();
    }
  }

  static void play(@NotNull final BaseballGame game, @NotNull final IntSupplier getInput) {
    System.out.print("숫자를 입력해주세요 : ");
    int input = getInput.getAsInt();

    List<Integer> inputList = new LinkedList<>();
    do {
      inputList.add(input % 10);
    } while ((input /= 10) != 0);

    BaseballGameResult result = game.query(inputList);
    printGameResult(result);
  }

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    do {
      BaseballGame game = BaseballGame.generate();
      do {
        play(game, scanner::nextInt);
      } while (!game.isEnd());
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    } while (!confirmEnd(scanner::nextInt));
  }
}