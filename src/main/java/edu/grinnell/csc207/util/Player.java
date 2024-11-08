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
   * Step size for a movement.
   */
  private final int step = 1;

  /**
   * Score awarded for successfully killing the attacker.
   */
  private final int attackScore = 10;

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /** Current column of the player. */
  private int currentCol;

  /** Fixed row of the player (player stays in this row). */
  private final int currentRow;

  /** The constant game board on which the player moves. */
  private final Board gameBoard;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Initializes the player at a specified starting position on the game board.
   *
   * @param startCol Initial column position of the player.
   * @param startRow Initial row position of the player (constant).
   * @param startBoard The game board on which the player operates.
   */
  public Player(int startCol, int startRow, Board startBoard) {
    this.currentCol = startCol;
    this.currentRow = startRow;
    this.gameBoard = startBoard;
    this.gameBoard.set(this.currentRow, this.currentCol, Board.PLAYDEF);
  } // Player(int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Places the player at a new column position, updating the board state.
   *
   * @param newCol The new column where the player will be placed.
   */
  public void placePlayer(int newCol) {
    // Clear old position of the player
    this.gameBoard.clear(this.currentRow, this.currentCol);
    // Place player at new position
    this.gameBoard.set(this.currentRow, newCol, Board.PLAYDEF);
    // Update the currentCol to new column
    this.currentCol = newCol;
  } // placePlayer(int)

  /**
   * Moves the player one step to the left, if within board bounds.
   *
   * @param board The game board on which the player moves.
   */
  public void moveLeft(Board board) {
    if (this.currentCol > 0) {
      this.placePlayer(this.currentCol - step);
    } // if
  } // moveLeft(Board)

  /**
   * Moves the player one step to the right, if within board bounds.
   *
   * @param board The game board on which the player moves.
   */
  public void moveRight(Board board) {
    if (this.currentCol < board.getWidth() - 1) {
      this.placePlayer(this.currentCol + step);
    } // if
  } // moveRight(Board)

  /**
   * Performs an attack action, attempting to clear the attacker above the player
   * in the same column. Awards score if an object is successfully hit.
   *
   * @param board The game board on which the attack is performed.
   * @return The score awarded for the attack, or 0 if no target was hit.
   */
  public int attack(Board board) {
    for (int row = this.currentRow; row >= 0; row--) {
      if (this.gameBoard.get(row, this.currentCol).equals(Board.ATTACKDEF)) {
        this.gameBoard.clear(row, this.currentCol);
        return this.attackScore;
      } // if
    } // for
    // Attacker was not found in the current column
    return 0;
  } // attack(Board)
} // class Player
