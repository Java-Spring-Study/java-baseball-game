import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Baseball {

  private String computerNumber;
  final Scanner scanner = new Scanner(System.in);

  enum Type {
    QUIT(2), RESTART(1);

    private final int value;

    Type(int value) {
      this.value = value;
    }

    public int value() {
      return value;
    }
  }

  public void gameStart() {
    int opinionProgress;
    do {
      gameProcessing();
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      opinionProgress = getOpinion();
    } while (opinionProgress == Type.RESTART.value());
  }

  private int getOpinion() {
    String opinion = scanner.next();
    try {
      if (!checkCorrectOpinion(opinion)) {
        throw new IllegalStateException();
      }
    } catch (IllegalStateException e) {
      System.out.println("적절하지 않은 응답입니다!");
      System.exit(0);
    }

    return Integer.parseInt(opinion);
  }

  private boolean checkCorrectOpinion(String opinion) {
    if (opinion.length() != 1) {
      return false;
    }
    List<String> correctOpinions = Arrays.asList("1", "2");

    return correctOpinions.stream().anyMatch(Predicate.isEqual(opinion));
  }

  private void gameProcessing() {
    makeComputerNumber();
    int strike;
    do {
      System.out.print("숫자를 입력해주세요 : ");
      String userNumber = getUserNumber();
      printScore(userNumber);
      strike = getStrike(userNumber);
    } while (strike != 3);
    System.out.println("3개의 숫자를 모두 맞히셨습니다!");
  }

  private void makeComputerNumber() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Collections.shuffle(list);
    List<Integer> subList = list.subList(0, 3);
    String uniqueNumbers = intListToString(subList);
    computerNumber = uniqueNumbers;
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
    if (answer.length() != 3) {
      return false;
    }

    List<Character> answerChar = stringToCharList(answer);
    List<Character> allowChar = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

    boolean isNumeric = answerChar.stream()
        .allMatch(number -> allowChar.stream().anyMatch(Predicate.isEqual(number)));

    return isNumeric;
  }

  private void printScore(String userNumber) {
    int strike = getStrike(userNumber);
    int ball = getBall(userNumber);

    String score = "";
    score += ball == 0 ? "" : ball + "볼";
    score += score.length() != 0 ? " " : "";
    score += strike == 0 ? "" : strike + "스트라이크";
    score = score.length() == 0 ? "낫싱" : score;

    System.out.println(score);
  }

  private int getStrike(String userNumber) {
    int strike = 0;
    for (int i = 0; i < 3; i++) {
      if (userNumber.charAt(i) == computerNumber.charAt(i)) {
        strike++;
      }
    }
    return strike;
  }

  private int getBall(String userNumber) {
    List<Character> userChar = stringToCharList(userNumber);
    List<Character> computerChar = stringToCharList(computerNumber);

    List<Character> matchChar = userChar.stream()
        .filter(number -> computerChar.stream().anyMatch(Predicate.isEqual(number)))
        .collect(Collectors.toList());

    int strike = getStrike(userNumber);
    int ball = matchChar.size() - strike;
    ball = ball < 0 ? 0 : ball;

    return ball;
  }

  private String intListToString(List<Integer> data) {
    return data.stream()
        .map(n -> String.valueOf(n))
        .collect(Collectors.joining());
  }

  private List<Character> stringToCharList(String data) {
    return data.chars()
        .mapToObj(e -> (char) e)
        .collect(Collectors.toList());
  }

  public Baseball() {
  }
}
