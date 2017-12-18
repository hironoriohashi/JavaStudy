
import java.util.Arrays;
import java.util.stream.Stream;

public class TicTacToeBoard {
  private int lineSize;
  private int columnSize;
  private int board[][];

  TicTacToeBoard(int lineSize, int columnSize) {
    this.lineSize = lineSize;
    this.columnSize = columnSize;
    board = new int[lineSize][columnSize];
  }

  public void setCell(int x, int y, int player) {
    if (x < 0 || x >= lineSize || y < 0 || y >= columnSize) {
      throw new IllegalArgumentException("x, yは0~2の範囲で指定してください."
          + " x = " + x + ", y = " + y + ", player = " + player);
    }
    if (board[x][y] != 0) {
      throw new IllegalArgumentException("指定した座標には既に入力があります"
          + " x = " + x + ", y = " + y + ", player = " + player);
    }
    board[x][y] = player;
  }

  public int getLineSize() {
    return lineSize;
  }

  public int getColumnSize() {
    return columnSize;
  }

  public boolean hasMatchDiagonal(int player) {
    int[][] diagonalCells = new int[2][3];
    // 斜線の値を取得する
    for (int i = 0; i < lineSize; i++) {
      diagonalCells[0][i] = board[i][i];
      diagonalCells[1][i] = board[i][columnSize - (i + 1)];
    }
    return hasComplete(diagonalCells, player);
  }

  public boolean hasMatchColumn(int player) {
    int[][] transposedBoard = new int[columnSize][lineSize];
    // 三目並べのボードに転置処理を行う
    for (int i = 0; i < lineSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        transposedBoard[i][j] = board[j][i];
      }
    }
    return hasComplete(transposedBoard, player);
  }

  public boolean hasMatchLine(int player) {
    return hasComplete(board, player);
  }

  private boolean hasComplete(int[][] board, int player) {
    return Stream.of(board)
        .anyMatch(line -> Arrays.stream(line).allMatch(cell -> cell == player));
  }
}
