public class TicTacToeResult {
  private boolean circleWin;
  private boolean crossWin;
  private boolean continued;

  public void setCircleWin(boolean circleWin) {
    this.circleWin = circleWin;
  }

  public void setCrossWin(boolean crossWin) {
    this.crossWin = crossWin;
  }

  public void setContinued(boolean continued) {
    this.continued = continued;
  }

  public boolean isCircleWin() {
    return circleWin;
  }

  public boolean isCrossWin() {
    return crossWin;
  }

  public boolean isContinued() {
    return continued;
  }

  public boolean isDraw() {
    return !(circleWin || crossWin || continued );
  }
}
