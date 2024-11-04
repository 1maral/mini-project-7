package edu.grinnell.csc207.util;

/**
 * Actions of the Attackers.
 *
 * @author Benjamin Sheeley
 * @author Maral Bat-Erdene
 */

import edu.grinnell.csc207.util.MatrixV0;

public class Attacker {
  //fields
  private Board currentBoard;
  private boolean[] attackerLine;
  private int lowestRow;

  //constructors
  public Attacker(Board board) {
    currentBoard = board;
  }

  //methods
  public void placeAttacker() {
    
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
