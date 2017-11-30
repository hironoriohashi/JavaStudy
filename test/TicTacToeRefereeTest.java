import static org.junit.jupiter.api.Assertions.*;

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
    game.attack(1, 1);
    assertTrue(game.getResult().isContinued());

    game.attack(2, 1);
    assertTrue(game.getResult().isContinued());

    game.attack(1, 2);
    assertTrue(game.getResult().isContinued());

    game.attack(2, 2);
    assertTrue(game.getResult().isContinued());

    game.attack(1, 3);
    assertTrue(game.getResult().isFirstPlayerWin());
  }
}
