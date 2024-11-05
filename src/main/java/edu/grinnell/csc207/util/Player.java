package edu.grinnell.csc207.util;

/**
 * Actions of the Player.
 *
 * @author Benjamin Sheeley
 * @author Maral Bat-Erdene
 */
public class Player {
   // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * A possible number of step for a movement
   */
  private final int step = 1;

  /**
   * A constant score for killing an attacker
   */
  private final int attackScore = 10;

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  private int currentCol;
  private final int currentRow;
  private final Board gameBoard;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new player with a starting postions startCol and startRow
   *
   */
  public Player(int startCol, int startRow, Board startBoard) {
    this.currentCol = startCol;
    this.currentRow = startRow;
    this.gameBoard = startBoard;
    this.gameBoard.set(this.currentRow, this.currentCol, this.gameBoard.playDef);
  } // Player(int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Updates the player’s position on the board.
   *
   * @param oldCol the old column of the player
   * @param oldRow the old row of the player
   * @param newCol the new column of the player
   * @param newRow the new row of the player
   */
  public void placePlayer(int newCol) {
    // Clear old position of the player
    this.gameBoard.clear(this.currentRow, this.currentCol);
    // Place player at new position
    this.gameBoard.set(this.currentRow, newCol, this.gameBoard.playDef);
    // Update the currentCol to new column
    this.currentCol = newCol;
  }

  /**
   * Movements of the player
   */
  public void moveLeft(Board board) {
    if (this.currentCol > 0) {
      this.placePlayer(this.currentCol - step);
    } // if
  } // moveLeft(Board)

  public void moveRight(Board board) {
    if (this.currentCol < board.getWidth() - 1) {
      this.placePlayer(this.currentCol + step);
    } // if
  } // moveRight(Board)

  public int attack(Board board) {
    for (int row = this.currentRow; row >= 0; row--) {
      if (this.gameBoard.get(row, this.currentCol).equals(this.gameBoard.attackDef)) {
        this.gameBoard.clear(row, this.currentCol);
        return this.attackScore;
      } // if
    } // for
    // Attacker was not found in the current column, so didn't hit anything
    return 0;
  } // attack(Board)

  public int getCol() {
    return this.currentCol;
  } // getCol() 

  public int getRow() {
    return this.currentRow;
  } // getRow()
} // class Player
