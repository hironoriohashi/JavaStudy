import java.util.Map;

public class TicTacToeReferee {
  /**
   * 三目並べの勝敗判定を行う関数
   * @param boardSurface 三目並べの盤面 Mapt型で渡される想定
   * 戻り値は、続行、×の勝利、〇の勝利、引き分け、の4つを想定している
   */
  String judgeWinner(Map<Integer,String> boardSurface) {
    String result;
    result = verticalLineBingo(boardSurface);
    if (!result.isEmpty()) {return result;}
    result = horizontalLineBing(boardSurface);
    if (!result.isEmpty()) {return result;}

    return "続行";
  }

  String verticalLineBingo(Map<Integer,String> boardSurface) {
    if (!boardSurface.get(1).isEmpty()
        && !boardSurface.get(4).isEmpty()
        && !boardSurface.get(7).isEmpty()
        && boardSurface.get(1).equals(boardSurface.get(4))
        && boardSurface.get(1).equals(boardSurface.get(7))) {
      return boardSurface.get(1) + "の勝ち";
    } else if (!boardSurface.get(2).isEmpty()
        && !boardSurface.get(5).isEmpty()
        && !boardSurface.get(8).isEmpty()
        && boardSurface.get(2).equals(boardSurface.get(5))
        && boardSurface.get(2).equals(boardSurface.get(8))) {
      return boardSurface.get(2) + "の勝ち";
    } else if (!boardSurface.get(3).isEmpty()
        && !boardSurface.get(6).isEmpty()
        && !boardSurface.get(9).isEmpty()
        && boardSurface.get(3).equals(boardSurface.get(6))
        && boardSurface.get(3).equals(boardSurface.get(9))) {
      return boardSurface.get(3) + "の勝ち";
    }

    return "";
  }

  String horizontalLineBing(Map<Integer,String> boardSurface) {

    if (!boardSurface.get(1).isEmpty()
        && !boardSurface.get(2).isEmpty()
        && !boardSurface.get(3).isEmpty()
        && boardSurface.get(1).equals(boardSurface.get(2))
        && boardSurface.get(1).equals(boardSurface.get(3))) {
      return boardSurface.get(1) + "の勝ち";
    } else if (!boardSurface.get(4).isEmpty()
        && !boardSurface.get(5).isEmpty()
        && !boardSurface.get(6).isEmpty()
        && boardSurface.get(4).equals(boardSurface.get(5))
        && boardSurface.get(4).equals(boardSurface.get(6))) {
      return boardSurface.get(4) + "の勝ち";
    } else if (!boardSurface.get(7).isEmpty()
        && !boardSurface.get(8).isEmpty()
        && !boardSurface.get(9).isEmpty()
        && boardSurface.get(7).equals(boardSurface.get(8))
        && boardSurface.get(7).equals(boardSurface.get(9))) {
      return boardSurface.get(7) + "の勝ち";
    }

    return "";
  }

  String shadedLineBing(Map<Integer,String> boardSurface) {
    if (!boardSurface.get(1).isEmpty()
        && !boardSurface.get(5).isEmpty()
        && !boardSurface.get(9).isEmpty()
        && boardSurface.get(1).equals(boardSurface.get(5))
        && boardSurface.get(1).equals(boardSurface.get(9))) {
      return boardSurface.get(1) + "の勝ち";
    }
    if (!boardSurface.get(3).isEmpty()
        && !boardSurface.get(5).isEmpty()
        && !boardSurface.get(7).isEmpty()
        && boardSurface.get(3).equals(boardSurface.get(5))
        && boardSurface.get(3).equals(boardSurface.get(7))) {
      return boardSurface.get(3) + "の勝ち";
    }

    return "";
  }

  boolean isWorngChar(Map<Integer,String> boardSurface) {
    return false;
  }
}
