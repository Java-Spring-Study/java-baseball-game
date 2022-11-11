package baseball;

public class BaseballGame {

  void Game() {
    randomInt answer = new randomInt();
    answer.generateRandomInt();
    InOut inout = new InOut();

    int user, strike, ball;

    do {
      user = inout.userNum();

      strike = answer.countStrike(user);
      ball = answer.countSameNum(user) - strike;

      inout.printResult(ball, strike);
    } while (strike != 3);
  }
}
