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
      try {
        pen.println("Enter board width:");
        width = scanner.nextInt();
        pen.println("Enter board height:");
        height = scanner.nextInt();
      } catch (Exception e) {
        pen.println("Invalid input. Please try again with integers.");
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
