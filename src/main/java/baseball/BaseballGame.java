package baseball;

public class BaseballGame {
    void Game() {
        randomInt answer = new randomInt();
        Input input = new Input();

        int user, strike, ball;

        while(true) {
            user = input.userNum();
            strike = answer.countStrike(user);
            ball = answer.countSameNum(user) - strike;

            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            }
            else {
                if (ball != 0) {
                    System.out.print(ball + "볼" );
                }
                if (strike != 0) {
                    System.out.print(strike + "스트라이크");
                }
                System.out.print("\n");
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
