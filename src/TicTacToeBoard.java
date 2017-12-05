public class TicTacToeBoard {
  private int lineSize;
  private int columnSize;
  private int board[][];

  TicTacToeBoard(int lineSize, int columnSize) {
    this.lineSize = lineSize;
    this.columnSize = columnSize;
    board = new int[lineSize][columnSize];
  }

  public void setCellData(int line, int column, int data) {
    board[line][column] = data;
  }

  public int getLineSize() {
    return lineSize;
  }

  public int getColumnSize() {
    return columnSize;
  }

  public int getCellData(int line, int column) {
    return board[line][column];
  }
}
