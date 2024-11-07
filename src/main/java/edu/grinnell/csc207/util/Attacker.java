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
  /**
   * Constructs the attacker class setting the lowest row.
   * @param board passed in so we can edit the board that contains our data.
   */
  public Attacker(Board board) {
    this.currentBoard = board;
    this.lowestRow = 0;
  }

  //methods

  /**
   * Places the next row of attackers based on level passed in by the board.
   * @param level the level that determines the amount of attackers spawned in.
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
      this.lowestRow = lowestRowCalc();
      this.currentBoard.deleteRow(this.lowestRow + 1);
      this.currentBoard.insertRow(0, attackerLine);
    } catch (Exception e) {
      System.err.println("Array size does not match width");
    } // try/catch
  } // placeAttackers()


  /**
   * Calculates the lowest row containing attackers.
   * @return the row number of the lowest row containing attackers.
   */
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

  /**
   * Determines if the game is over based on if the lowest row contains a player and attackers.
   * @return true if the game is ended, false if the game continues.
   */
  public boolean isGameOver() {
    return (this.lowestRow + 1) == (this.currentBoard.getHeight() - 1);
  } // isGameOver()
} // class Attacker
