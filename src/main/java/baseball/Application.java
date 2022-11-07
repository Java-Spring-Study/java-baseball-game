package baseball;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        BaseballGame baseballgame = new BaseballGame();
        Input input = new Input();
        boolean loop = true;

        while(loop) {
            baseballgame.Game();
            loop = input.ifContinue();
        }


    }
}
