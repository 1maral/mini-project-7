package edu.grinnell.csc207.util;

import java.io.PrintWriter;

public class Board {
  public final char def = ' ';
  public final char playDef = 'O';
  public final char attackDef = 'A';
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  private final int width;
  private final int height;
  public MatrixV0<Character> boardMatrix;
  public Player player;
  public Attacker attackers;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * Creates a Board with specified dimensions, player and attackers
   *
   * @param width  the width of the board
   * @param height the height of the board
   */
  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    this.boardMatrix = new MatrixV0<>(width, height, this.def);
    // Start the player in the bottom center
    this.player = new Player(width / 2, height - 1);
    this.attackers = new Attacker();
  } // Board(int, int)

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
  public void placePlayer(int oldCol, int oldRow, int newCol, int newRow) {
    // Clear old position of the player
    this.boardMatrix.set(oldRow, oldCol, this.def);
    // Place player at new position
    this.boardMatrix.set(newRow, newCol, this.playDef);
  }

  /**
   * Clears an attacker at the specified location.
   *
   * @param row the row of the attacker
   * @param col the column of the attacker
   */
  public void clearCell(int row, int col) {
    // Clear old position of the attacker
    grid.set(row, col, this.def);
  }

  /**
   * Gets the value at the specified cell.
   *
   * @param row the row of the cell
   * @param col the column of the cell
   * @return the character in the cell
   */
    // Method to get a cell value
  public Character getCell(int row, int col) {
    return grid.get(row, col);
  }

  /**
   * Gets the width of the board.
   */
  public int getWidth() {
      return this.width;
  }

  /**
   * Gets the height of the board.
   */
  public int getHeight() {
      return this.height;
  }
  
  /**
   * Create and display the current board with a matrix and a caption.
   *
   * @param pen
   *   The tool used to print output.
   * @param caption
   *   A caption for the matrix
   * @param matrix
   *   The matrix to print.
   */
  static void display(PrintWriter pen, String caption, Matrix matrix) {
    pen.println("=".repeat(80));
    pen.println();
    pen.println(caption);
    pen.println();
    Matrix.print(pen, matrix, true);
    pen.println();
  } // figure(PrintWriter, String, Matrix)
} // class Board
