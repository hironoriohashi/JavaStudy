import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import java.util.HashMap;
import java.util.Map;

class JudgeWinnerTest {

  @Test
  public void 先手が5手目で勝利条件を満たした場合に先手の勝利でゲームを終了すること() {
    TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();

    ticTacToeReferee.setCellData(1, 1);
    TicTacToeResult result = ticTacToeReferee.getResult();
    assertTrue(result.isContinued());

    ticTacToeReferee.setCellData(2, 1);
    result = ticTacToeReferee.getResult();
    assertTrue(result.isContinued());

    ticTacToeReferee.setCellData(1, 2);
    result = ticTacToeReferee.getResult();
    assertTrue(result.isContinued());

    ticTacToeReferee.setCellData(2, 2);
    result = ticTacToeReferee.getResult();
    assertTrue(result.isContinued());

    ticTacToeReferee.setCellData(1, 3);
    result = ticTacToeReferee.getResult();
    assertTrue(result.isPlayer1Win());
  }

}
