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
  private static final int step = 1;

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  private int currentCol;
  private int currentRow;
  private int attackScore;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new player with a starting postions startCol and startRow
   *
   */
  public Player(int startCol, int startRow) {
    this.currentCol = startCol;
    this.currentRow = startRow;
  } // Player(int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Movements of the player
   */
  public void moveLeft(Board board) {
    if (this.currentCol > 0) {
      board.updatePosition(this.currentCol, this.currentRow, this.currentCol - step, this.currentRow);
      this.currentCol -= step;
    } // if
  } // moveLeft(Board)

  public void moveRight(Board board) {
    if (this.currentCol < board.getWidth() - 1) {
      board.updatePosition(this.currentCol, this.currentRow, this.currentCol + step, this.currentRow);
      this.currentCol = this.currentCol + step;
    } // if
  } // moveRight(Board)

  public int attack(Board board) {
    for (int row = this.currentRow; row >= 0; row--) {
      if (board.getCell(row, this.currentCol).equals('A')) {
        board.clearCell(row, this.currentCol);
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
