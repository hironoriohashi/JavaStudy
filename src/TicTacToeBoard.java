

public class TicTacToeBoard {
  private String board[][];
  private int turnCount;
  private final int lineSize;
  private final int columnSize;


  TicTacToeBoard() {
    lineSize = 3;
    columnSize = 3;
    turnCount = 1;
    board = new String[lineSize][columnSize];
  }

  public void setCellData(int line, int column, String data) {
    if (turnCount > 9) {
      throw new IllegalStateException();
    } else if (line < 1 || line > lineSize || column < 1 || column > columnSize) {
      throw new IllegalArgumentException();
    } else if (!data.equals("〇") && !data.equals("×")) {
      throw new IllegalArgumentException();
    } else if (board[line - 1][column - 1] != null && !board[line - 1][column - 1].isEmpty()) {
      throw new IllegalArgumentException();
    }
    board[line - 1][column - 1] = data;
    turnCount++;
  }

  public String getCellData(int line, int column) {
    return board[line - 1][column - 1];
  }

  public int getTurnCount() {
    return turnCount;
  }
}
