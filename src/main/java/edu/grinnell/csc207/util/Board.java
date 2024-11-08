package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/**
 * The class that controls the board and its interactions with the player/attackers.
 */
public class Board {
<<<<<<< HEAD
=======
  // +--------+------------------------------------------------------------
  // | Constants |
  // +--------+
  public static final char def = ' ';
  public static final char playDef = 'O';
  public static final char attackDef = 'A';
>>>>>>> e3654f1b07367f27eabc2efffff4580dcf788c59
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * the default character of our matrix.
   */
  public final char def = ' ';
  /**
   * The character that represents the player.
   */
  public final char playDef = 'O';
  /**
   * The character that represents the attackers.
   */
  public final char attackDef = 'A';
  /**
   * the width of the matrix/board.
   */
  private final int width;
  /**
   * the height of the matrix/board.
   */
  private final int height;
  /**
   * the matrix that we use to create the board.
   */
  private static MatrixV0<Character> boardMatrix;
  /**
   * The player's actions and inputs.
   */
  public Player player;
  /**
   * The attacker's actions.
   */
  public Attacker attackers;
  /**
   * current level that the player is on, determines difficulty.
   */
  public int level;

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
    this.level = 0;
    this.attackers = new Attacker(this);
    Board.boardMatrix = new MatrixV0<>(width, height, this.def);
    this.player = new Player(width / 2, height - 1, this);
  } // Board(int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Places attackers on the board for the player to clear.
   *
   * @return true if the game ends, false if the game continues.
   */
  public boolean placeAttackers() {
    if (this.attackers.isGameOver()) {
      return true;
    } /* if block */ else {
      this.attackers.placeAttackers(this.level);
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
  } //clear(row, col)

  /**
   * Inserts a row into the matrix field of the board.
   *
   * @param row     row to insert into the matrix.
   * @param charArr array of characters to insert into the matrix.
   */
  public void insertRow(int row, Character[] charArr) {
    try {
      Board.boardMatrix.insertRow(row, charArr);
    } /* try block*/ catch (ArraySizeException e) {
      System.err.println("array size too big or small for matrix width");
    } //catch(ArraySizeException)
  } //insertRow(row, Character[])

  /**
   * Deletes a row from the board by accessing the matrix field.
   *
   * @param row row to delete from the matrix.
   */
  public void deleteRow(int row) {
    Board.boardMatrix.deleteRow(row);
  } //deleteRow(row)

  /**
   * Increases the game level, increasing the amount of attackers that can spawn
   * each time.
   */
  public void increaseLevel() {
    this.level++;
  } //increaseLevel()

  /**
   * Gets the value at the specified cell.
   *
   * @param row the row of the cell
   * @param col the column of the cell
   * @return the character in the cell
   */
  public Character get(int row, int col) {
    return Board.boardMatrix.get(row, col);
  } //get(row, col)

  /**
   * Sets the value at the specified cell.
   *
   * @param row the row of the cell
   * @param col the column of the cell
   * @param val the character to be set
   */
  public void set(int row, int col, Character val) {
    Board.boardMatrix.set(row, col, val);
  } //set(int, int, Character)

  /**
   * Gets the width of the board.
   * @return width in int form.
   */
  public int getWidth() {
    return this.width;
  } //getWidth()

  /**
   * Gets the height of the board.
   * @return height in int form.
   */
  public int getHeight() {
    return this.height;
  } // getHeight()

  /**
   * Create and display the current board with a matrix and a caption.
   * @param pen The tool used to print output.
   * @param caption A caption for the matrix
   * @param score the current score of the player.
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
