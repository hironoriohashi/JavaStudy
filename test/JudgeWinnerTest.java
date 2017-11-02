import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

class JudgeWinnerTest {
  private JudgeWinner judgeWinner = new JudgeWinner();

  @Test
  public void Ｘが三目揃っていた場合にＸが勝利している文字列が返ってくること() {
    Map<Integer, String> boardSurface = new HashMap<>();
    boardSurface.put(1, "×");
    boardSurface.put(2, "〇");
    boardSurface.put(3, "×");
    boardSurface.put(4, "〇");
    boardSurface.put(5, "×");
    boardSurface.put(6, "〇");
    boardSurface.put(7, "×");
    boardSurface.put(8, "");
    boardSurface.put(9, "");

    assertThat(judgeWinner.judgeWinnerFunction(boardSurface), is("×の勝ち"));
  }

  @Test
  public void 〇が三目揃っていた場合に〇が勝利している文字列が返ってくること() {
    Map<Integer, String> boardSurface = new HashMap<>();
    boardSurface.put(1, "×");
    boardSurface.put(2, "〇");
    boardSurface.put(3, "×");
    boardSurface.put(4, "×");
    boardSurface.put(5, "〇");
    boardSurface.put(6, "");
    boardSurface.put(7, "");
    boardSurface.put(8, "〇");
    boardSurface.put(9, "");

    assertThat(judgeWinner.judgeWinnerFunction(boardSurface), is("〇の勝ち"));
  }

  @Test
  public void どちらも勝利しておらず盤面に空きが無かった場合に引き分けの文字列が返ってくること() {
    Map<Integer, String> boardSurface = new HashMap<>();
    boardSurface.put(1, "〇");
    boardSurface.put(2, "×");
    boardSurface.put(3, "×");
    boardSurface.put(4, "×");
    boardSurface.put(5, "〇");
    boardSurface.put(6, "〇");
    boardSurface.put(7, "×");
    boardSurface.put(8, "〇");
    boardSurface.put(9, "×");

    assertThat(judgeWinner.judgeWinnerFunction(boardSurface), is("引き分け"));
  }

  @Test
  public void どちらも勝利しておらず盤面に空きがあった場合に続行の文字列が返ってくること() {
    Map<Integer, String> boardSurface = new HashMap<>();
    boardSurface.put(1, "〇");
    boardSurface.put(2, "×");
    boardSurface.put(3, "×");
    boardSurface.put(4, "×");
    boardSurface.put(5, "〇");
    boardSurface.put(6, "〇");
    boardSurface.put(7, "×");
    boardSurface.put(8, "〇");
    boardSurface.put(9, "");

    assertThat(judgeWinner.judgeWinnerFunction(boardSurface), is("続行"));
  }
}
