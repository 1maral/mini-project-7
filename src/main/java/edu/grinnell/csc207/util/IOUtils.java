package edu.grinnell.csc207.util;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A variety of utilities for getting input.
 *
 * @author Samuel A. Rebelsky
 * @author Maral Bat-Erdene
 */
public class IOUtils {
  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Determine if an array contains a particular value.
   *
   * @param <T>
   *   The type of values in the array.
   * @param vals
   *   The array to search.
   * @param val
   *   The value to look for.
   *
   * @return true if the array contains an equal value and false otherwise.
   */
  @SuppressWarnings("unused")
  private static <T> boolean arrayContains(T[] vals, T val) {
    for (T tmp : vals) {
      if (tmp.equals(val)) {
        return true;
      } // if
    } // for
    return false;
  } // arrayContains(T[], T)


  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Repeatedly prompt for a command until one is returned.
   */
  public static String readCommand(PrintWriter pen, Scanner scanner, int width, int height) {
    while (width == -1 || height == -1) {
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
    return(width + "," + height + ",retry");
  } // readCommand(PrintWriter, Scanner, int, int)
} // class IOUtils
