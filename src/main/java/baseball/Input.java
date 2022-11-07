package baseball;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    public int userNum() {
        System.out.print("숫자를 입력해주세요: ");
        int user = scanner.nextInt();
        return user;
    }
    public boolean ifContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int ifContinue = scanner.nextInt();
        if (ifContinue == 1) return true;
        else return false;
    }
}
