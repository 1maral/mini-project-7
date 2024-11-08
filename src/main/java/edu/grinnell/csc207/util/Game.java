package edu.grinnell.csc207.util;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Game class manages the game logic for each "Attackers" game.
 * It controls the game board, player's score, level progression, and the game state.
 *
 * @author Benjamin Sheeley
 * @author Maral Bat-Erdene
 */
public class Game {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+
	/** The game board where the game takes place. */
	public Board gameBoard;

	/** The player's current score. */
	private int score;

	/** Score buffer to keep track of points for leveling up. */
	private int scoreBuffer;

	/** A flag indicating whether the game is over and the game state*/
	private boolean gameOver;

	/** The current level of the game. */
	public int level;

	// +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+
	/**
	 * Initializes a new game with the specified board dimensions.
	 * Sets the current score to 0, and the flag to false.
	 *
	 * @param width  the width of the game board
	 * @param height the height of the game board
	 */
	public Game(int width, int height) {
		this.gameBoard = new Board(width, height);
		this.score = 0;
		this.gameOver = false;
	} // GameLogic(int, int)

	// +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+
	/**
	 * Starts the game loop, which continues until the game is over.
	 * The game loop repeatedly updates the board with new attackers,
	 * displays the current score, processes user input for the player, and
	 * adjusts the level based on the score buffer.
	 *
	 * @param scanner a Scanner object for user input
	 * @param pen     a PrintWriter object for outputting the game board and messages
	 * @return the final score when the game ends
	 */
	public int start(Scanner scanner, PrintWriter pen) {
		scanner.nextLine();
		gameOver = this.gameBoard.placeAttackers();
		while (!gameOver) {
			Board.display(pen, "Current Score: ", score);

			// Prompt for player move
			System.out.print("Enter your move (L for left/ R for right/ A for attack): ");
			String input = scanner.nextLine().toUpperCase();			
			// Only update the game state if input was valid

			// Process the player's input
			switch (input) {
				case "L":
					this.gameBoard.player.moveLeft(gameBoard);
					break;
				case "R":
					this.gameBoard.player.moveRight(gameBoard);
					break;
				case "A":
					this.score += this.gameBoard.player.attack(gameBoard);
					this.scoreBuffer += 10;
					break;
				default:
					System.out.println("Invalid input. Please enter L, R or A.");
					input = null;
			} // switch\

      if (input != null) {
        gameOver = this.gameBoard.placeAttackers();
      } // if

			// Check for level increase
			if (this.scoreBuffer >= 50) {
				this.scoreBuffer = 0;
				this.gameBoard.increaseLevel();
			} // if
		} // while
		return score;
	} // start
} // class Game
