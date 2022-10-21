package baseball.tool;

public enum Signal{
  NEWGAME(1),
  END(2);
  private final int signal;

  Signal(int signal) {
    this.signal= signal;
  }

  public int getSignal() {
    return this.signal;
  }
}
