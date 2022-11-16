package baseball;

public class BaseballGame {

  void Game() {
    RandomInt answer = new RandomInt();
    answer.generateRandomInt();
    InputAndOutput inout = new InputAndOutput();

    int user, strike, ball;

    do {
      user = inout.userNumber();

      strike = answer.countStrike(user);
      ball = answer.countSameNumber(user) - strike;

      inout.printResult(ball, strike);
    } while (strike != 3);
  }
}
