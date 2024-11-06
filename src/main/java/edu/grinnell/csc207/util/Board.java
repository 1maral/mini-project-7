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
  private static MatrixV0<Character> boardMatrix;
  public Player player;
  public Attacker attackers;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * Creates a Board with specified dimensions, player and attackers.
   * Start the player in the bottom center
   *
   * @param width  the width of the board
   * @param height the height of the board
   */
  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    this.attackers = new Attacker(this);
    Board.boardMatrix = new MatrixV0<>(width, height, this.def);
    this.player = new Player(width / 2, height - 1, this);
  } // Board(int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  public boolean placeAttackers() {
    if (this.attackers.isGameOver()) {
      return true;
    } else {
      this.attackers.placeAttackers();
      return false;
    } // if/else
  } // placeAttackers()

  /**
   * Clears the object at the specified location.
   *
   * @param row the row of the attacker
   * @param col the column of the attacker
   */
  public void clear(int row, int col) {
    Board.boardMatrix.set(row, col, this.def);
  }

  public void insertRow(int row, Character[] charArr) {
    try {
      Board.boardMatrix.insertRow(row, charArr);
    } catch (ArraySizeException e) {
      System.err.println("array size too big or small for matrix width");
    }
  }

  public void deleteRow(int row) {
    Board.boardMatrix.deleteRow(row);
  }

  /**
   * Gets the value at the specified cell.
   *
   * @param row the row of the cell
   * @param col the column of the cell
   * @return the character in the cell
   */
  public Character get(int row, int col) {
    return Board.boardMatrix.get(row, col);
  }

  /**
   * Sets the value at the specified cell.
   *
   * @param row the row of the cell
   * @param col the column of the cell
   * @param val the character to be set
   */
  public void set(int row, int col, Character val) {
    Board.boardMatrix.set(row, col, val);
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

  public void resetBoard() {
    for (int row = 0; row < this.width; row++) {
      for (int col = 0; col < this.height; col++) {
        Board.boardMatrix.set(row, col, this.def);
      } // for columns
    } // for rows
  } // resetBoard()
  
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
  static void display(PrintWriter pen, String caption, int score) {
    pen.println("=".repeat(80));
    pen.println();
    pen.println(caption + score);
    pen.println();
    Matrix.print(pen, Board.boardMatrix, true);
    pen.println();
  } // figure(PrintWriter, String, Matrix)
} // class Board
