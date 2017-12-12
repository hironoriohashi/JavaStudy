
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeTest {
  private BoardGame game;

  @BeforeEach
  public void setup() {
    game = new TicTacToe();
  }

  @Test
  public void 先手が5手目で行を揃えて勝利条件を満たした場合に先手の勝利でゲームを終了すること() {
    assertTrue(game.inputPlayerAttack(1, 1).isContinued());
    assertTrue(game.inputPlayerAttack(2, 1).isContinued());
    assertTrue(game.inputPlayerAttack(1, 2).isContinued());
    assertTrue(game.inputPlayerAttack(2, 2).isContinued());
    Result result = game.inputPlayerAttack(1, 3);
    assertFalse(result.isContinued());
    assertTrue(result.isFirstPlayerWin());
  }

  @Test
  public void 後手が6手目で行を揃えて勝利条件を満たした場合に後手の勝利でゲームを終了すること() {
    assertTrue(game.inputPlayerAttack(1, 1).isContinued());
    assertTrue(game.inputPlayerAttack(2, 1).isContinued());
    assertTrue(game.inputPlayerAttack(1, 2).isContinued());
    assertTrue(game.inputPlayerAttack(2, 2).isContinued());
    assertTrue(game.inputPlayerAttack(3, 1).isContinued());
    Result result = game.inputPlayerAttack(2, 3);
    assertFalse(result.isContinued());
    assertTrue(result.isSecondPlayerWin());
  }

  @Test
  public void 先手が5手目で列を揃えて勝利条件を満たした場合に先手の勝利でゲームを終了すること() {
    assertTrue(game.inputPlayerAttack(1, 1).isContinued());
    assertTrue(game.inputPlayerAttack(1, 2).isContinued());
    assertTrue(game.inputPlayerAttack(2, 1).isContinued());
    assertTrue(game.inputPlayerAttack(2, 2).isContinued());
    Result result = game.inputPlayerAttack(3, 1);
    assertFalse(result.isContinued());
    assertTrue(result.isFirstPlayerWin());
  }

  @Test
  public void 先手が5手目で右肩下がりの斜めを揃えて勝利条件を満たした場合に先手の勝利でゲームを終了すること() {
    assertTrue(game.inputPlayerAttack(1, 1).isContinued());
    assertTrue(game.inputPlayerAttack(1, 2).isContinued());
    assertTrue(game.inputPlayerAttack(2, 2).isContinued());
    assertTrue(game.inputPlayerAttack(2, 1).isContinued());
    Result result = game.inputPlayerAttack(3, 3);
    assertFalse(result.isContinued());
    assertTrue(result.isFirstPlayerWin());
  }

  /*
  @Test
  public void 先手が9手目で勝利条件を満たした場合に先手の勝利でゲームを終了すること() {
    assertTrue(game.inputPlayerAttack(1, 1).isContinued());
    assertTrue(game.inputPlayerAttack(1, 2).isContinued());
    assertTrue(game.inputPlayerAttack(1, 3).isContinued());
    assertTrue(game.inputPlayerAttack(2, 1).isContinued());
    assertTrue(game.inputPlayerAttack(2, 2).isContinued());
    assertTrue(game.inputPlayerAttack(2, 3).isContinued());
    assertTrue(game.inputPlayerAttack(3, 2).isContinued());
    assertTrue(game.inputPlayerAttack(3, 3).isContinued());
    Result result = game.inputPlayerAttack(3, 1);
    assertFalse(result.isContinued());
    assertTrue(result.isFirstPlayerWin());
  }

  @Test
  public void 先手が9手目で勝利条件を満たさなかった場合に引き分けでゲームを終了すること() {
    assertTrue(game.inputPlayerAttack(1, 1).isContinued());
    assertTrue(game.inputPlayerAttack(1, 2).isContinued());
    assertTrue(game.inputPlayerAttack(1, 3).isContinued());
    assertTrue(game.inputPlayerAttack(2, 2).isContinued());
    assertTrue(game.inputPlayerAttack(2, 1).isContinued());
    assertTrue(game.inputPlayerAttack(2, 3).isContinued());
    assertTrue(game.inputPlayerAttack(3, 2).isContinued());
    assertTrue(game.inputPlayerAttack(3, 1).isContinued());
    Result result = game.inputPlayerAttack(3, 3);
    assertFalse(result.isContinued());
    assertTrue(result.isDraw());
  }

  @Test
  public void 指定した行の値が1以上3以下ではなかった場合にIllegalArgumentExceptionが投げられること() {
    assertThrows(IllegalArgumentException.class, () -> {
      game.inputPlayerAttack(0, 1);
    });
  }

  @Test
  public void 指定した列の値が1以上3以下ではなかった場合にIllegalArgumentExceptionが投げられること() {
    assertThrows(IllegalArgumentException.class, () -> {
      game.inputPlayerAttack(1, 4);
    });
  }

  @Test
  public void ゲーム終了後に次の手を指定した場合にIllegalArgumentExceptionが投げられること() {
    game.inputPlayerAttack(1, 1);
    game.inputPlayerAttack(2, 1);
    game.inputPlayerAttack(1, 2);
    game.inputPlayerAttack(2, 2);
    game.inputPlayerAttack(1, 3);

    assertThrows(IllegalArgumentException.class, () -> {
      game.inputPlayerAttack(2, 3);
    });
  }

  @Test void 既に変更が加えられた座標を次の手に指定した場合にIllegalArgumentExceptionが投げられること() {
    game.inputPlayerAttack(1, 1);

    assertThrows(IllegalArgumentException.class, () -> {
      game.inputPlayerAttack(1, 1);
    });
  }
  */
}
