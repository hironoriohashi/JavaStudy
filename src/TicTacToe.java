
public class TicTacToe implements BoardGame {
  private TicTacToeBoard ticTacToeBoard;
  private int inputCount;

  TicTacToe() {
    ticTacToeBoard = new TicTacToeBoard(3, 3);
    inputCount = 0;
  }

  private boolean canInputData(int line, int column) {
    if (inputCount >= 9) {
      return false;
    } else if (line < 1 || line > ticTacToeBoard.getLineSize() || column < 1 || column > ticTacToeBoard.getColumnSize()) {
      return false;
    } else if (ticTacToeBoard.getCellData(line - 1, column - 1) != 0) {
      return false;
    }
    return true;
  }

  private void inputCellData(int line, int column) {
    ticTacToeBoard.setCellData(line - 1, column - 1, inputCount % 2 == 0 ? 1 : 2);
    inputCount++;
  }

  private boolean isSomeoneWin() {
    for (int i = 0; i < 3; i++) {
      if (ticTacToeBoard.getCellData(i, 0) != 0 && lineScanning(i, 0, 1)) {
        return true;
      }
    }
    for (int i = 0; i < 3; i++) {
      if (ticTacToeBoard.getCellData(0, i) != 0 && columnScanning(0, i, 1)) {
        return true;
      }
    }
    if (ticTacToeBoard.getCellData(0, 0) != 0 && lowerRightDiagonalScanning(0, 0, 1)) {
      return true;
    } else if (ticTacToeBoard.getCellData(2, 0) != 0 && upperRightDiagonalScanning(2, 0, 1)) {
      return true;
    }
    return false;
  }

  private boolean lineScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line, column + 1)) {
      matchCount++;
      return matchCount == 3 || lineScanning(line, column + 1, matchCount);
    }
    return false;
  }

  private boolean columnScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line + 1, column)) {
      matchCount++;
      return matchCount == 3  || columnScanning(line + 1, column, matchCount);
    }
    return false;
  }

  private boolean lowerRightDiagonalScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line + 1, column + 1)) {
      matchCount++;
      return matchCount == 3 || lowerRightDiagonalScanning(line + 1, column + 1, matchCount);
    }
    return false;
  }

  private boolean upperRightDiagonalScanning(int line, int column, int matchCount) {
    if (ticTacToeBoard.getCellData(line, column) == ticTacToeBoard.getCellData(line - 1, column + 1)) {
      matchCount++;
      return matchCount == 3 || upperRightDiagonalScanning(line - 1, column + 1, matchCount);
    }
    return false;
  }

  @Override
  public Result inputPlayerAttack(int line, int column) {
    boolean someoneWin = isSomeoneWin();
    if (someoneWin || !canInputData(line, column)) {
      throw new IllegalArgumentException();
    }
    inputCellData(line, column);
    someoneWin = isSomeoneWin();
    return new Result(!someoneWin && inputCount < 9, someoneWin && inputCount % 2 == 1, someoneWin && inputCount % 2 == 0);
  }
}
