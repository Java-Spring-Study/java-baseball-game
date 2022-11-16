package baseball;

public enum ContinueOrNot {
  CONTINUE(1), END(2);

  private final int value;

  ContinueOrNot(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
