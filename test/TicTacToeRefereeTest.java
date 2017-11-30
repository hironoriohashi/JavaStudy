import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class JudgeWinnerTest {

  @Test
  public void 先手が5手目で勝利条件を満たした場合に先手の勝利でゲームを終了すること() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.attack(1, 1);
    assertTrue(ticTacToe.isContinued());

    ticTacToe.attack(2, 1);
    assertTrue(ticTacToe.isContinued());

    ticTacToe.attack(1, 2);
    assertTrue(ticTacToe.isContinued());

    ticTacToe.attack(2, 2);
    assertTrue(ticTacToe.isContinued());

    ticTacToe.attack(1, 3);
    assertTrue(ticTacToe.isPreempionPlayerWin());
  }
}
