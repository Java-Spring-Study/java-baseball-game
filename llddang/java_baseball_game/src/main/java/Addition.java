import java.util.List;
import java.util.stream.Collectors;

public class Addition {
  public static String intListToString(List<Integer> data) {
    return data.stream()
        .map(n -> String.valueOf(n))
        .collect(Collectors.joining());
  }

  public static List<Character> stringToCharList(String data) {
    return data.chars()
        .mapToObj(e -> (char) e)
        .collect(Collectors.toList());
  }
}
