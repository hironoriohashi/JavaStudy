
public class TicTacToe implements BoardGame {
  private TicTacToeBoard board;
  private int inputCount;

  /**
   * コンストラクタ.
   * 縦と横の大きさが3のボードを用意し,
   * 入力されたデータをカウントするフィールドを0にする
   */
  public TicTacToe() {
    board = new TicTacToeBoard(3, 3);
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
    int beforePlayer = getLastAttackPlayer();
    if (board.hasMatchLine(beforePlayer) || board.hasMatchColumn(beforePlayer) || board.hasMatchDiagonal(beforePlayer)) {
      throw new IllegalStateException("ゲームは終了しました");
    }
    inputCell(x, y);

    boolean someoneWin;
    // TODO 盤面の状態から勝者を取得できるように修正
    int player = getLastAttackPlayer();
    someoneWin = board.hasMatchLine(player) || board.hasMatchColumn(player) || board.hasMatchDiagonal(player);

    return new Result(!someoneWin && inputCount < board.getLineSize() * board.getColumnSize()
        , someoneWin && inputCount % 2 == 1
        , someoneWin && inputCount % 2 == 0);
  }

  private int getLastAttackPlayer() {
    return inputCount % 2 == 1 ? 1 : 2;
  }

  /**
   * ボードの指定した行と列の交点に値を入力する
   * @param x 指定した行
   * @param y 指定した列
   */
  private void inputCell(int x, int y) {
    board.setCell(x - 1, y - 1, inputCount % 2 == 0 ? 1 : 2);
    inputCount++;
  }
}
