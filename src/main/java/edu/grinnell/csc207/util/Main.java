package edu.grinnell.csc207.util;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // +--------+------------------------------------------------------------
    // | Main |
    // +--------+
    int width = -1;
    int height = -1;
    int score;
    String[] input;
    boolean retry = true;
    
    Scanner scanner = new Scanner(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("  Welcome to Attackers! \n");
    pen.println("Create your custom game board and get ready for the challenge!");
    pen.println("For an optimal experience, choose a board size where both height and width are positive integers greater than 1.");
    pen.println("To increase the fun, try setting the height to be at least twice the width. For example, a width of 3 and a height of 5 works great!");
    pen.println("Let's start by entering your preferred board dimensions.");

    while(retry) {
      // Read input from the user and assign the values to width and height of the board
      input = IOUtils.readCommand(pen, scanner, width, height).split(",");
      width = Integer.valueOf(input[0]);
      height = Integer.valueOf(input[1]);
      
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
