package baseball;

public class BaseballGame {

  void Game() {
    RandomInt answer = new RandomInt();
    answer.generateRandomInt();
    Input_Output inout = new Input_Output();

    int user, strike, ball;

    do {
      user = inout.userNum();

      strike = answer.countStrike(user);
      ball = answer.countSameNumber(user) - strike;

      inout.printResult(ball, strike);
    } while (strike != 3);
  }
}
