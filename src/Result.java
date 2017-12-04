public class Result {
  private boolean Continued;
  private boolean FirstPlayerWin;
  private boolean SecondPlayerWin;

  Result(boolean Continued, boolean FirstPlayerWin, boolean SecondPlayerWin) {
    this.Continued = Continued;
    this.FirstPlayerWin = FirstPlayerWin;
    this.SecondPlayerWin = SecondPlayerWin;
  }

  public boolean isContinued() {
    return Continued;
  }

  public boolean isFirstPlayerWin() {
    return FirstPlayerWin;
  }

  public boolean isSecondPlayerWin() {
    return SecondPlayerWin;
  }

  public boolean isDraw() {
    return !(Continued || FirstPlayerWin || SecondPlayerWin);
  }
}
