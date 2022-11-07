import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Score {
  public static int strikeCount;
  public static int ballCount;
  public static String computerNumber;

  public Score(){
    makeComputerNumber();
  }

  private void makeComputerNumber() {
    List<Integer> list = Const.NUMBER_LIST;
    Collections.shuffle(list);
    List<Integer> subList = list.subList(0, Const.NUMBER_SIZE);
    computerNumber = Addition.intListToString(subList);
  }

  public void printScore(String userNumber) {
    getStrike(userNumber);
    getBall(userNumber);

    String score = "";
    score += ballCount == 0 ? "" : ballCount + "볼";
    score += score.length() != 0 ? " " : "";
    score += strikeCount == 0 ? "" : strikeCount + "스트라이크";
    score = score.length() == 0 ? "낫싱" : score;

    System.out.println(score);
  }

  public void getStrike(String userNumber) {
    strikeCount = 0;
    for (int i = 0; i < 3; i++) {
      if (userNumber.charAt(i) == computerNumber.charAt(i)) {
        strikeCount++;
      }
    }
  }

  public void getBall(String userNumber) {
    List<Character> userChar = Addition.stringToCharList(userNumber);
    List<Character> computerChar = Addition.stringToCharList(computerNumber);

    List<Character> matchChar = userChar.stream()
        .filter(number -> computerChar.stream().anyMatch(Predicate.isEqual(number)))
        .collect(Collectors.toList());

    ballCount = matchChar.size() - strikeCount;
    ballCount = Math.max(ballCount, 0);
  }
}
