package edu.grinnell.csc207.util;

import edu.grinnell.csc207.util.MatrixV0;
import edu.grinnell.csc207.util.Board;
import edu.grinnell.csc207.util.Player;

import java.util.Scanner;

public class Game {
	public Board board;
	private int score;
	private boolean gameOver;

	public Game(int width, int height) {
		this.board = new Board(width, height);
		this.score = 0;
		this.gameOver = false;
	} // GameLogic(int, int)

	public void start(Scanner scanner) {
		while (!gameOver) {
			board.display();
			System.out.print("Enter your move (L for left/R for right/A for attack): ");
			String input = scanner.nextLine().toUpperCase();
			switch (input) {
				case "L":
					this.player.moveLeft(board);
					break;
				case "R":
					this.player.moveRight(board);
					break;
				case "A":
					this.score += this.player.attack(board);
					break;
				default:
					System.out.println("Invalid input. Please enter L, R or A.");
			} // while
			gameOver = this.board.placeAttackers(this.board.getWidth());
			if (gameOver) {
					System.out.println("Game Over! Final Score: " + score);
			} // if
		} // while
	} // start
} // class Game
