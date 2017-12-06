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
    boolean someoneWin = isSomeoneWin();
    if (someoneWin || !canInputData(line, column)) {
      throw new IllegalArgumentException();
    }
    inputCellData(line, column);
    someoneWin = isSomeoneWin();
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
   * 盤面の状態が勝利条件を満たしているか判断する
   * @return true:勝利条件を満たしている false:勝利条件を満たしていない
   */
  private boolean isSomeoneWin() {
    if(lineScanning()) {

    }
    /*
    for (int i = 0; i < ticTacToeBoard.getLineSize(); i++) {
      if (ticTacToeBoard.getCellData(i, 0) != 0 && lineScanning(0)) {
        return true;
      }
    }
    */
    for (int i = 0; i < ticTacToeBoard.getColumnSize(); i++) {
      if (ticTacToeBoard.getCellData(0, i) != 0 && columnScanning(0, i, 1)) {
        return true;
      }
    }
    if (ticTacToeBoard.getCellData(0, 0) != 0 && lowerRightDiagonalScanning(0, 0, 1)) {
      return true;
    } else if (ticTacToeBoard.getCellData(2, 0) != 0 && upperRightDiagonalScanning(2, 0, 1)) {
      return true;
    }
    return false;
  }

  /**
   * Streamを使って、行に同じ値が3つ連続してあるかを調べる
   */
  private boolean lineScanning() {
    Stream<List<Integer>> stream = Stream.of(ticTacToeBoard.getBoard()).forEach(board -> Arrays.asList(board));
    return stream.filter(data -> !data.equals(0)).distinct().count() == 1;
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
