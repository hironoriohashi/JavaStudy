import java.util.Arrays;
import java.util.List;
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
   * @param line 指定した行
   * @param column 指定した列
   * @return 入力を反映した結果.
   * ゲームの勝者とゲームの続行or終了の状態を返す
   */
  @Override
  public Result inputPlayerAttack(int line, int column) {
    // TODO 勝敗を判断した結果を変数へ代入する
    boolean someoneWin = false;
    if (someoneWin || !canInputData(line, column)) {
      throw new IllegalArgumentException();
    }

    inputCellData(line, column);
    // TODO 盤面の状態から勝者を取得できるように修正
    int player = inputCount % 2 == 1 ? 1 : 2;
    someoneWin = Stream.of(ticTacToeBoard.getBoard())
        .anyMatch(oneLine -> Arrays.stream(oneLine).allMatch(cell -> cell == player));

    // TODO 盤面の列から勝敗を判断する処理を追加
    // TODO 盤面の斜線から勝敗を判断する処理を追加

    return new Result(!someoneWin && inputCount < ticTacToeBoard.getLineSize() * ticTacToeBoard.getColumnSize()
        , someoneWin && inputCount % 2 == 1
        , someoneWin && inputCount % 2 == 0);
  }
  /**
   * 指定された行と列の交点にデータを入力できるかどうかの判断を行う
   * @param line データを入力する行
   * @param column データを入力する列
   * @return データの入力ができるかどうか
   */
  private boolean canInputData(int line, int column) {
    if (inputCount >= ticTacToeBoard.getLineSize() * ticTacToeBoard.getColumnSize()) {
      return false;
    } else if (line < 1 || line > ticTacToeBoard.getLineSize() || column < 1 || column > ticTacToeBoard.getColumnSize()) {
      return false;
    } else if (ticTacToeBoard.getCellData(line - 1, column - 1) != 0) {
      return false;
    }
    return true;
  }

  /**
   * 行に同じ値が3つ連続してあるかを調べる
   * @param line 行
   * @param column 列
   * @param matchCount 連続していた個数
   * @return true:同じ値が3つ連続している false:同じ値が3つ連続していない
   */
  private boolean lineScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line, column + 1)) {
      matchCount++;
      return matchCount == 3 || lineScanning(line, column + 1, matchCount);
    }
    return false;
  }

  /**
   * 列に同じ値が3つ連続してあるかを調べる
   * @param line 行
   * @param column 列
   * @param matchCount 連続していた個数
   * @return true:同じ値が3つ連続している false:同じ値が3つ連続していない
   */
  private boolean columnScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line + 1, column)) {
      matchCount++;
      return matchCount == 3  || columnScanning(line + 1, column, matchCount);
    }
    return false;
  }

  /**
   * 右斜め下に同じ値が3つ連続してあるかを調べる
   * @param line 行
   * @param column 列
   * @param matchCount 連続していた個数
   * @return true:同じ値が3つ連続している false:同じ値が3つ連続していない
   */
  private boolean lowerRightDiagonalScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line + 1, column + 1)) {
      matchCount++;
      return matchCount == 3 || lowerRightDiagonalScanning(line + 1, column + 1, matchCount);
    }
    return false;
  }

  /**
   * 右斜め上に同じ値が3つ連続してあるかを調べる
   * @param line 行
   * @param column 列
   * @param matchCount 連続していた個数
   * @return true:同じ値が3つ連続している false:同じ値が3つ連続していない
   */
  private boolean upperRightDiagonalScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line - 1, column + 1)) {
      matchCount++;
      return matchCount == 3 || upperRightDiagonalScanning(line - 1, column + 1, matchCount);
    }
    return false;
  }

  /**
   * ボードの指定した行と列の交点に値を入力する
   * @param line 指定した行
   * @param column 指定した列
   */
  private void inputCellData(int line, int column) {
    ticTacToeBoard.setCellData(line - 1, column - 1, inputCount % 2 == 0 ? 1 : 2);
    inputCount++;
  }
}
