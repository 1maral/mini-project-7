package edu.grinnell.csc207.util;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Main class initializes and manages the game's setup and replay loop.
 * It prompts the user to specify board dimensions, starts the game, and
 * asks if the player wants to play again after each round.
 *
 * @author Benjamin Sheeley
 * @author Maral Bat-Erdene
 */
public class Main {

  /**
   * Main method that initializes the game, takes user input for board dimensions,
   * starts the game, and allows for replaying the game after it ends.
   * 
   * @param args command-line arguments (not used)
   */
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    // +--------+------------------------------------------------------------
    // | Main |
    // +--------+
    /** Game board width, set by user input */
    int width = -1;
    /** Game board height, set by user input */
    int height = -1;
    /** Game board score, calculated by attacks */
    int score;
    /** Stores parsed user inputs */
    String[] input;
    /** Controls replay loop. True to replay, false to exit */
    boolean retry = true;
    
    Scanner scanner = new Scanner(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);

    // Display welcome message and instructions for board dimensions
    pen.println("   Welcome to Attackers! \n");
    pen.println("Create your custom game board and get ready for the challenge!");
    pen.println("Please choose a board size where both height and width are positive integers greater than 1.");
    pen.println("For optimal experience, you should set the height to be at least twice the width. For example, a width of 3 and a height of 5 works great!");
    pen.println("Let's start by entering your preferred board dimensions.");

    // Game setup and replay loop
    while(retry) {
      // Read input from the user and assign the values to width and height of the board
      input = IOUtils.readCommand(pen, scanner, width, height).split(",");
      width = Integer.parseInt(input[0]);
      height = Integer.parseInt(input[1]);
      
      // Create and start the game with specified board dimensions
      pen.println("Board width: " + width + ", Board height: " + height);
      Game game = new Game(width, height);
      score = game.start(scanner, pen);
      pen.println("Game Over! Final Score: " + score);

      // Ask if the player wants to play again
      pen.println("Do you want to replay? (Y/N)\n");
      input[2] = scanner.nextLine().toUpperCase();
      if (input[2].equals("Y")) {
        retry = true;
        width = -1;
        height = -1;
      } else {
        retry = false;
      } // if/else
    } // while
    scanner.close();
    pen.close();
  } // main
} // class Main
