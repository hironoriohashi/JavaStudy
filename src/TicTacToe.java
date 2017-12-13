import java.util.Arrays;
import java.util.stream.Stream;

public class TicTacToe implements BoardGame {
  private TicTacToeBoard ticTacToeBoard;
  private int inputCount;

  /**
   * コンストラクタ.
   * 縦と横の大きさが3のボードを用意し,
   * 入力されたデータをカウントするフィールドを0にする
   */
  public TicTacToe() {
    ticTacToeBoard = new TicTacToeBoard(3, 3);
    inputCount = 0;
  }

  /**
   * 指定した行と列の交点に対する入力が適切かどうかを判断し、反映してその結果を返す
   * @param x 指定した行
   * @param y 指定した列
   * @return 入力を反映した結果.
   * ゲームの勝者とゲームの続行or終了の状態を返す
   */
  @Override
  public Result inputPlayerAttack(int x, int y) {

    inputCellData(x, y);

    boolean someoneWin;
    // TODO 盤面の状態から勝者を取得できるように修正
    int player = inputCount % 2 == 1 ? 1 : 2;
    someoneWin = hasMatchLine(player) || hasMatchColumn(player) || hasMatchDiagonal(player);

    return new Result(!someoneWin && inputCount < ticTacToeBoard.getLineSize() * ticTacToeBoard.getColumnSize()
        , someoneWin && inputCount % 2 == 1
        , someoneWin && inputCount % 2 == 0);
  }

  private boolean hasMatchDiagonal(int player) {
    int[][] diagonalCells = new int[2][3];
    // 斜線の値を取得する
    for (int i = 0; i < ticTacToeBoard.getLineSize(); i++) {
      diagonalCells[0][i] = ticTacToeBoard.getCellData(i, i);
      diagonalCells[1][i] = ticTacToeBoard.getCellData(i, ticTacToeBoard.getColumnSize() - (i + 1));
    }
    return hasComplete(diagonalCells, player);
  }

  private boolean hasMatchColumn(int player) {
    int[][] transposedBoard = new int[ticTacToeBoard.getColumnSize()][ticTacToeBoard.getLineSize()];
    // 三目並べのボードに転置処理を行う
    for (int i = 0; i < ticTacToeBoard.getLineSize(); i++) {
      for (int j = 0; j < ticTacToeBoard.getColumnSize(); j++) {
        transposedBoard[i][j] = ticTacToeBoard.getCellData(j, i);
      }
    }
    return hasComplete(transposedBoard, player);
  }

  private boolean hasMatchLine(int player) {
    return hasComplete(ticTacToeBoard.getBoard(), player);
  }

  private boolean hasComplete(int[][] board, int player) {
    return Stream.of(board)
        .anyMatch(line -> Arrays.stream(line).allMatch(cell -> cell == player));
  }

  /**
   * 指定された行と列の交点にデータを入力できるかどうかの判断を行う
   * @param x データを入力する行
   * @param y データを入力する列
   * @return データの入力ができるかどうか
   */
  private boolean canInputData(int x, int y) {
    if (inputCount >= ticTacToeBoard.getLineSize() * ticTacToeBoard.getColumnSize()) {
      return false;
    } else if (x < 1 || x > ticTacToeBoard.getLineSize() || y < 1 || y > ticTacToeBoard.getColumnSize()) {
      return false;
    } else if (ticTacToeBoard.getCellData(x - 1, y - 1) != 0) {
      return false;
    }
    return true;
  }

  /**
   * ボードの指定した行と列の交点に値を入力する
   * @param x 指定した行
   * @param y 指定した列
   */
  private void inputCellData(int x, int y) {
    ticTacToeBoard.setCellData(x - 1, y - 1, inputCount % 2 == 0 ? 1 : 2);
    inputCount++;
  }
}
