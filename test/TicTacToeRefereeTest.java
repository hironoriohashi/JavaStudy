import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class JudgeWinnerTest {
  BoardGame game;

  @Before
  public void setup() {
    game = new TicTacToe();
  }

  @Test
  public void 先手が5手目で勝利条件を満たした場合に先手の勝利でゲームを終了すること() {
    assertTrue(game.inputPlayerAttack(1, 1).isContinued());

    assertTrue(game.inputPlayerAttack(2, 1).isContinued());

    assertTrue(game.inputPlayerAttack(1, 2).isContinued());

    assertTrue(game.inputPlayerAttack(2, 2).isContinued());

    Result result = game.inputPlayerAttack(1, 3);
    assertFalse(result.isContinued());
    assertTrue(result.isFirstPlayerWin());
  }
}
