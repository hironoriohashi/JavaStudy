
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
    someoneWin = ticTacToeBoard.hasMatchLine(player) || ticTacToeBoard.hasMatchColumn(player) || ticTacToeBoard.hasMatchDiagonal(player);

    return new Result(!someoneWin && inputCount < ticTacToeBoard.getLineSize() * ticTacToeBoard.getColumnSize()
        , someoneWin && inputCount % 2 == 1
        , someoneWin && inputCount % 2 == 0);
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
