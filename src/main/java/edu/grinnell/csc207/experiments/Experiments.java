package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;

/**
 * Experiments with Associative Arrays.
 *
 * @author Ben Sheeley
 * @author Maral Bat-Erdene
 */
public class Experiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our expereiments.
   *
   * @param args
   *   Command-line parameters. (Ignored.)
   *
   * @throws Exception
   *   When something goes wrong. Usually an I/O issue or an unexpected
   *   Associative Array hiccup.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    AssociativeArray<String, String> strings2strings = new AssociativeArray<String, String>();

    // The empty array should not have any key. We'll try one.
    hasKey(pen, strings2strings, "k");

    // However, after setting that key, we should be able to get it.
    set(pen, strings2strings, "k", "key");
    hasKey(pen, strings2strings, "k");
    get(pen, strings2strings, "k");

    // What happens if we try a different key?
    hasKey(pen, strings2strings, "q");
    get(pen, strings2strings, "q");

    // What happens if we try the null key?
    set(pen, strings2strings, null, "nothing");
    hasKey(pen, strings2strings, null);
    get(pen, strings2strings, null);

    set(pen, strings2strings, "a", "key1");
    set(pen, strings2strings, "b", "key2");
    set(pen, strings2strings, "c", "key3");

    AssociativeArray<String, String> cloneArr = new AssociativeArray<String, String>();
    cloneArr = strings2strings.clone();
    pen.println(strings2strings.toString());
    pen.println(cloneArr.toString());

    // And we're done.
    pen.close();
  } // main(String[])
} // class AAExperiments
