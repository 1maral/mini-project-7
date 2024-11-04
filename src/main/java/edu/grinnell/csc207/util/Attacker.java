package edu.grinnell.csc207.util;

/**
 * Actions of the Attackers.
 *
 * @author Benjamin Sheeley
 * @author Maral Bat-Erdene
 */

public class Attacker {
  //fields
  private Board currentBoard;
  private Character[] attackerLine;
  private int lowestRow;

  //constructors
  public Attacker(Board board) {
    currentBoard = board;
  }

  //methods
  public void placeAttackers() {
    try {
      attackerLine = new Character[currentBoard.getWidth()];
      for (int i = 0; i < currentBoard.getWidth() - 1; i++) {
        attackerLine[i] = 'A';
      }
      currentBoard.boardMatrix.insertRow(0, attackerLine);
    } catch (ArraySizeException e) {
      System.err.println("Array size does not match width");
    }
  }

  public boolean isGameOver() {
    if (lowestRow == currentBoard.getHeight() - 1) {
      return true;
    }
    else {
      return false;
    }
  }
} // class Attacker
