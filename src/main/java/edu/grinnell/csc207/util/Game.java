package edu.grinnell.csc207.util;

import java.io.PrintWriter;
import java.util.Scanner;

public class Game {
	public Board gameBoard;
	private int score;
	private int scoreBuffer;
	private boolean gameOver;
	public int level;

	public Game(int width, int height) {
		this.gameBoard = new Board(width, height);
		this.score = 0;
		this.gameOver = false;
	} // GameLogic(int, int)

	public int start(Scanner scanner, PrintWriter pen) {
		scanner.nextLine();
		while (!gameOver) {	
			gameOver = this.gameBoard.placeAttackers();
			Board.display(pen, "Current Score: ", score);
			System.out.print("Enter your move (L for left/ R for right/ A for attack): ");
			String input = scanner.nextLine().toUpperCase();
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
			} // switch
			if (this.scoreBuffer >= 50) {
				this.scoreBuffer = 0;
				this.gameBoard.increaseLevel();
			}
		} // while
		return score;
	} // start
} // class Game
