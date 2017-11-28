/**
 * 三目並べの状態を表すクラス
 */
public class TicTacToeBoard {
  private String board[][];
  private int turnCount;
  private final int lineSize;
  private final int columnSize;

  /**
   * ボードの縦と横のサイズを設定する
   */
  TicTacToeBoard() {
    lineSize = 3;
    columnSize = 3;
    turnCount = 1;
    board = new String[lineSize][columnSize];
  }

  /**
   * データをセルに格納する
   * 格納する場所やデータが適切かどうかを確認し、データを格納する
   * @param line 格納したい行
   * @param column 格納したい列の値
   * @param data 格納したいデータ
   * @throw IllegalStateException 行や列、データの値が正しくない場合に発生する
   */
  public void setCellData(int line, int column, String data)throws IllegalStateException {
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

  /**
   * セルのデータを取得する
   * @param line 取得したいデータの行
   * @param column 取得したいデータの列
   * @return 指定した行と列のデータ
   */
  public String getCellData(int line, int column) {
    return board[line - 1][column - 1];
  }

  /**
   * ゲームが何手進んだかを取得する
   * @return 現在のターン数
   */
  public int getTurnCount() {
    return turnCount;
  }
}
