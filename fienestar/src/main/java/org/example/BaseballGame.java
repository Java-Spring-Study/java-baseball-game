package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class BaseballGame {

  public static class BaseballGameResult {

    public int ball;
    public int strike;
  }

  @NotNull
  final List<Integer> answer;
  boolean isEnd = false;

  public List<Integer> getAnswer() {
    return new ArrayList<>(answer);
  }

  void validate(@NotNull List<Integer> answer) {
    if (answer.size() != 3) {
      throw new IllegalArgumentException("length of answer must be 3");
    }

    final boolean[] used = new boolean[9];
    for (Integer value : answer) {
      if (value < 1 || value > 9) {
        throw new IllegalArgumentException("answer element out of range");
      }

      if (used[value - 1]) {
        throw new IllegalArgumentException("duplicate value");
      }

      used[value - 1] = true;
    }
  }

  BaseballGame(@NotNull List<Integer> answer) {
    validate(answer);
    this.answer = answer;
  }

  public boolean isEnd() {
    return this.isEnd;
  }

  BaseballGameResult query(@NotNull List<Integer> user_answer) {
    validate(answer);
    final int[] index = new int[9];
    int i = 0;
    for (int value : this.answer) {
      index[value - 1] = ++i;
    }

    final BaseballGameResult result = new BaseballGameResult();
    i = 1;
    for (int value : user_answer) {
      if (index[value - 1] == i) {
        ++result.strike;
      } else if (index[value - 1] != 0) {
        ++result.ball;
      }

      ++i;
    }

    this.isEnd = result.strike == 3;

    return result;
  }

  static BaseballGame generate() {
    final List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Collections.shuffle(answer);
    return new BaseballGame(answer.subList(0, 3));
  }
}
