package baseball.game;

import baseball.tool.*;

public class BaseballGame {

  BaseballTool tool = new BaseballTool();

  public Signal tryGame() throws IllegalArgumentException {
    tool.reset();
    tool.makeRamdomNumbers();  //랜덤한 숫자를 생성한다.

    while (!tool.isStrike()) {  //확인한다.
      tool.setInputNumber();  //input을 받는다.
      tool.calcResult();    //게임 결과를 계산한다.
      tool.printResult();    //게임 결과를 출력한다.
    }
    return tool.getSignalCode();
  }

}
