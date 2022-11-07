import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Baseball {
  final Scanner scanner = new Scanner(System.in);
  private Score score = new Score();

  public void gameStart(){
    score = new Score();
  }

  public void gameProcessing() {
    do {
      System.out.print("숫자를 입력해주세요 : ");
      String userNumber = getUserNumber();
      score.printScore(userNumber);
    } while (score.strikeCount != Const.NUMBER_SIZE);
    System.out.println("3개의 숫자를 모두 맞히셨습니다!");
  }



  private String getUserNumber() {
    String answer = scanner.next();
    try {
      if (!checkCorrectAnswer(answer)) {
        throw new IllegalArgumentException();
      }
    } catch (IllegalArgumentException e) {
      System.out.println("이상한게 들어왔다 삐리리");
      System.exit(0);
    }

    return answer;
  }

  private boolean checkCorrectAnswer(String answer) {
    if (answer.length() != Const.NUMBER_SIZE) {
      return false;
    }

    List<Character> answerChar = Addition.stringToCharList(answer);
    List<Character> allowChar = Const.NUMBER_LIST.stream().map(a -> (char) (a + '0'))
        .collect(Collectors.toList());

    return answerChar.stream()
        .allMatch(number -> allowChar.stream().anyMatch(Predicate.isEqual(number)));
  }

  public int getOpinion() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String opinion = scanner.next();
    try {
      if (!isCorrectOpinion(opinion)) {
        throw new IllegalStateException();
      }
    } catch (IllegalStateException e) {
      System.out.println("적절하지 않은 응답입니다!");
      System.exit(0);
    }

    return Integer.parseInt(opinion);
  }

  private boolean isCorrectOpinion(String opinion) {
    if (opinion.length() != 1) {
      return false;
    }
    List<String> correctOpinions = Arrays.asList("1", "2");

    return correctOpinions.stream().anyMatch(Predicate.isEqual(opinion));
  }

  public Baseball() {
  }
}
