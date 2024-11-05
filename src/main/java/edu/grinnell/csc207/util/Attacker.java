package edu.grinnell.csc207.util;

import java.util.Random;

/**
 * Actions of the Attackers.
 *
 * @author Benjamin Sheeley
 * @author Maral Bat-Erdene
 */

public class Attacker {
  //fields
  private final Board currentBoard;
  private int lowestRow;

  //constructors
  public Attacker(Board board) {
    this.currentBoard = board;
    this.lowestRow = 0;
  }

  //methods
  public void placeAttackers() {
    int boardLength = this.currentBoard.getWidth();
    Character[] attackerLine = new Character[boardLength];
    try {
      for (int i = 0; i < boardLength; i++) {
        attackerLine[i] = this.currentBoard.attackDef;
      } // for

      // maybe access boardMatrix from the currentboard?
      for (int col = 0; col < boardLength; col++) {
        this.currentBoard.set(0, col, attackerLine[col]);
      } // for

      // maybe here we can shift the values down and update the lowrow?
    } catch (Exception e) {
      System.err.println("Array size does not match width");
    }
  }

  public boolean isGameOver() {
    if (this.lowestRow == this.currentBoard.getHeight() - 1) {
      return true;
    }
    else {
      return false;
    }
  }
} // class Attacker
