package baseball;

public class Application {

  public static void main(String[] args) {
    //TODO: 숫자 야구 게임 구현

    BaseballGame baseballgame = new BaseballGame();
    Input_Output input = new Input_Output();

    do {
      baseballgame.Game();
    } while (input.isContinue());
  }
}
