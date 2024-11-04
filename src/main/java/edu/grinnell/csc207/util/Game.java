package edu.grinnell.csc207.util;

import edu.grinnell.csc207.util.MatrixV0;
import edu.grinnell.csc207.util.Board;
import edu.grinnell.csc207.util.Player;
import java.io.PrintWriter;

import java.util.Scanner;

public class Game {
	public Board gameBoard;
	private int score;
	private boolean gameOver;

	public Game(int width, int height) {
		this.gameBoard = new Board(width, height);
		this.score = 0;
		this.gameOver = false;
	} // GameLogic(int, int)

	public void start(Scanner scanner) {
		PrintWriter pen = new PrintWriter(System.out, true);
		while (!gameOver) {
			Board.display(pen, "current gameboard state", this.gameBoard);
			System.out.print("Enter your move (L for left/R for right/A for attack): ");
			String input = scanner.nextLine().toUpperCase();
			switch (input) {
				case "L":
					this.gameBoard.player.moveLeft(gameBoard);
					break;
				case "R":
					this.gameBoard.player.moveRight(gameBoard);
					break;
				case "A":
					this.score += gameBoard.player.attack(gameBoard);
					break;
				default:
					System.out.println("Invalid input. Please enter L, R or A.");
			} // while
			gameOver = this.gameBoard.placeAttackers();
			if (gameOver) {
					System.out.println("Game Over! Final Score: " + score);
			} // if
		} // while
	} // start
} // class Game
