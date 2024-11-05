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
  private boolean[] attackerLine;
  private int lowestRow;
  private Random random;

  //constructors
  public Attacker(Board board) {
    this.currentBoard = board;
    this.random = new Random();
    this.attackerLine = new boolean[this.currentBoard.getWidth()];
  }

  //methods
  public void placeAttackers() {
    int randomInt;
    int boardLength = currentBoard.getWidth();
    try {
      for (int i = 0; i < boardLength; i++) {
        randomInt = random.nextInt(2);
        this.attackerLine[i] = randomInt == 1;
      } // for

      // I think we should not access boardMatrix directly?
      for (int col = 0; col < boardLength; col++) {
        if (this.attackerLine[col]) {
          this.currentBoard.set(0, col, this.currentBoard.attackDef);
        } // if
      } // for

      // i think you should shift the values down by 1 row here and update the lowest Row
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
