package baseball.baseball;

import baseball.game.BaseballGame;
import baseball.tool.*;


public class BaseballApplication {
  public static void main(String[] args) {
    BaseballGame game=new BaseballGame();
    try {
      while(game.tryGame() != Signal.END);
    } catch (IllegalArgumentException e) {
      System.err.println("input error");
    }
  }

}
