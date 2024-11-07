package edu.grinnell.csc207.util;


/**
 * Actions of the Attackers.
 *
 * @author Benjamin Sheeley
 * @author Maral Bat-Erdene
 */

import java.util.Random;

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
    Random attackerGenerator = new Random();
    try {
      for (int i = 0; i < boardLength; i++) {
        if (attackerGenerator.nextInt(2) == 0) {
          attackerLine[i] = ' ';
        } else {
          attackerLine[i] = currentBoard.attackDef;
        }
      }
      lowestRow = lowestRowCalc();
      this.currentBoard.deleteRow(lowestRow);
      this.currentBoard.insertRow(0, attackerLine);
      // maybe here we can shift the values down and update the lowrow?
    } catch (Exception e) {
      System.err.println("Array size does not match width");
    }
  }

  public int lowestRowCalc() {
    int boardHeight = this.currentBoard.getHeight();
    int boardLength = this.currentBoard.getWidth();
    for (int i = boardHeight - 1; i >= 0 ; i--) {
      for (int j = 0; j < boardLength; j++) {
        if (this.currentBoard.get(i, j) == 'A') {
          return i + 1;
        }
      }
    }
    return 0;
  }

  public boolean isGameOver() {
    if ((this.lowestRow + 1) == (this.currentBoard.getHeight() - 1)) {
      return true;
    }
    else {
      return false;
    }
  }
} // class Attacker
