package edu.grinnell.csc207.util;

import edu.grinnell.csc207.util.Board;
import edu.grinnell.csc207.util.Player;
import edu.grinnell.csc207.util.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board width:");
        int width = scanner.nextInt();
        System.out.println("Enter board height:");
        int height = scanner.nextInt();
        Game game = new Game(width, height);
        
        game.start(scanner);
        scanner.close();
    }
} // class Main
