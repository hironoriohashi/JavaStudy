public class Result {
  private boolean continued;
  private boolean firstPlayerWin;
  private boolean secondPlayerWin;

  Result(boolean continued, boolean firstPlayerWin, boolean secondPlayerWin) {
    this.continued = continued;
    this.firstPlayerWin = firstPlayerWin;
    this.secondPlayerWin = secondPlayerWin;
  }

  public boolean isContinued() {
    return continued;
  }

  public boolean isFirstPlayerWin() {
    return firstPlayerWin;
  }

  public boolean isSecondPlayerWin() {
    return secondPlayerWin;
  }

  public boolean isDraw() {
    return !(continued || firstPlayerWin || secondPlayerWin);
  }
}
