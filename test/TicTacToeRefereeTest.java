import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import java.util.HashMap;
import java.util.Map;

class JudgeWinnerTest {
  private TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();

  @Test
  public void 斜めで三目揃っていた場合に勝負がつくこと() {
    TicTacToeBoard boardSurface = new TicTacToeBoard();
    boardSurface.setCellData(1, 1, "〇");
    boardSurface.setCellData(1, 2, "〇");
    boardSurface.setCellData(1, 3, "×");
    //boardSurface.setCellData(2, 1, "");
    boardSurface.setCellData(2, 2, "×");
    //boardSurface.setCellData(2, 3, "");
    boardSurface.setCellData(3, 1, "×");
    //boardSurface.setCellData(3, 2, "");
    //boardSurface.setCellData(3, 3, "");

    TicTacToeResult result = ticTacToeReferee.judgeWinner(boardSurface);
    assertTrue(result.isCrossWin());
  }

  @Test
  public void 横で三目揃っていた場合に勝負がつくこと() {
    TicTacToeBoard boardSurface = new TicTacToeBoard();
    boardSurface.setCellData(1, 1, "×");
    boardSurface.setCellData(1, 2, "〇");
    boardSurface.setCellData(1, 3, "×");
    boardSurface.setCellData(2, 1, "×");
    boardSurface.setCellData(2, 2, "〇");
    //boardSurface.setCellData(2, 3, "");
    //boardSurface.setCellData(3, 1, "");
    boardSurface.setCellData(3, 2, "〇");
    //boardSurface.setCellData(3, 3, "");

    TicTacToeResult result = ticTacToeReferee.judgeWinner(boardSurface);
    assertTrue(result.isCircleWin());
  }

  @Test
  public void 縦で三目揃っていた場合に勝負がつくこと() {
    TicTacToeBoard boardSurface = new TicTacToeBoard();
    boardSurface.setCellData(1, 1, "〇");
    boardSurface.setCellData(1, 2, "〇");
    boardSurface.setCellData(1, 3, "〇");
    boardSurface.setCellData(2, 1, "×");
    boardSurface.setCellData(2, 2, "×");
    //boardSurface.setCellData(2, 3, "");
    //boardSurface.setCellData(3, 1, "");
    //boardSurface.setCellData(3, 2, "");
    //boardSurface.setCellData(3, 3, "");

    TicTacToeResult result = ticTacToeReferee.judgeWinner(boardSurface);
    assertTrue(result.isCircleWin());
  }

  @Test
  public void どちらも勝利しておらず盤面に空きが無かった場合に引き分けが分かること() {
    TicTacToeBoard boardSurface = new TicTacToeBoard();
    boardSurface.setCellData(1, 1, "〇");
    boardSurface.setCellData(1, 2, "×");
    boardSurface.setCellData(1, 3, "×");
    boardSurface.setCellData(2, 1, "×");
    boardSurface.setCellData(2, 2, "〇");
    boardSurface.setCellData(2, 3, "〇");
    boardSurface.setCellData(3, 1, "×");
    boardSurface.setCellData(3, 2, "〇");
    boardSurface.setCellData(3, 3, "×");

    TicTacToeResult result = ticTacToeReferee.judgeWinner(boardSurface);
    assertTrue(result.isDraw());
  }

  @Test
  public void どちらも勝利しておらず盤面に空きがあった場合に続行が分かること() {
    TicTacToeBoard boardSurface = new TicTacToeBoard();
    boardSurface.setCellData(1, 1, "〇");
    boardSurface.setCellData(1, 2, "×");
    boardSurface.setCellData(1, 3, "×");
    boardSurface.setCellData(2, 1, "×");
    boardSurface.setCellData(2, 2, "〇");
    boardSurface.setCellData(2, 3, "〇");
    boardSurface.setCellData(3, 1, "×");
    boardSurface.setCellData(3, 2, "〇");
    //boardSurface.setCellData(3, 3, "");

    TicTacToeResult result = ticTacToeReferee.judgeWinner(boardSurface);
    assertTrue(result.isContinued());
  }
}
