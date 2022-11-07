enum Opinion {
  RESTART(1), QUIT(2);

  private final int opinion;

  Opinion(int value) {
    this.opinion = value;
  }

  public int value() {
    return opinion;
  }
}
