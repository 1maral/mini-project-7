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
    
    Scanner scanner = new Scanner(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);
    while (width == -1 || height == -1) {
      System.out.println("  Welcome to Attackers! \n");
      System.out.println("Create your custom game board and get ready for the challenge!");
      System.out.println("For an optimal experience, choose a board size where both height and width are positive integers greater than 1.");
      System.out.println("To increase the fun, try setting the height to be at least twice the width. For example, a width of 5 and a height of 10 works great!");
      System.out.println("Let's start by entering your preferred board dimensions.");
      try {
        pen.println("Enter board width:");
        width = scanner.nextInt();
        if (width <= 1) {
          throw new Exception();
        } // if
        pen.println("Enter board height:");
        height = scanner.nextInt();
        if (height < 2 * width) {
          throw new Exception();
        } // if
      } catch (Exception e) {
        pen.println("Invalid input. Please try again with positive integers.");
        scanner.nextLine();
        // Reset values to prompt user again
        width = -1;
        height = -1;
      } // try/catch
    } // while
    
    pen.println("Board width: " + width + ", Board height: " + height);
    Game game = new Game(width, height);
    score = game.start(scanner, pen);
    pen.println("Game Over! Final Score: " + score);
    scanner.close();
    pen.close();
  } // main
} // class Main
