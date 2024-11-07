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
  /**
   * 
   * @param level
   */
  public void placeAttackers(int level) {
    int boardLength = this.currentBoard.getWidth();
    int totalAttackers = 0;
    Character[] attackerLine = new Character[boardLength];
    Random attackerGenerator = new Random();
    try {
      for (int i = 0; i < boardLength; i++) {
        if (totalAttackers == level + 1) {
          for (int j = i; j < boardLength; j++) {
            attackerLine[j] = this.currentBoard.def;
          }
          break;
        }
        if (attackerGenerator.nextInt(2) == 0) {
          attackerLine[i] = this.currentBoard.def;
        } else {
          attackerLine[i] = this.currentBoard.attackDef;
          totalAttackers++;
        } // if/else
      } // for
      this.lowestRow = lowestRowCalc() + 1;
      this.currentBoard.deleteRow(this.lowestRow);
      this.currentBoard.insertRow(0, attackerLine);
    } catch (Exception e) {
      System.err.println("Array size does not match width");
    } // try/catch
  } // placeAttackers()

  public int lowestRowCalc() {
    int boardHeight = this.currentBoard.getHeight();
    int boardLength = this.currentBoard.getWidth();
    for (int i = boardHeight - 1; i >= 0 ; i--) {
      for (int j = 0; j < boardLength; j++) {
        if (this.currentBoard.get(i, j).equals(this.currentBoard.attackDef)) {
          return i;
        } // if
      } // for row
    } // for column
    return 0;
  } // lowestRowCalc()

  public boolean isGameOver() {
    return (this.lowestRow + 1) == (this.currentBoard.getHeight() - 1);
  } // isGameOver()
} // class Attacker
