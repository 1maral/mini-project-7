package edu.grinnell.csc207;

import edu.grinnell.csc207.util.AssociativeArray;
import edu.grinnell.csc207.util.NullKeyException;
import edu.grinnell.csc207.util.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * A place for you to put your own tests (beyond the shared repo).
 *
 * @author Maral Bat-Erdene
 */
public class TestsFromStudent {
  /**
   * Checking the basic functionality of set, get, and remove methods using string key.
   * 
   * @throws NullKeyException
   */
  @Test
  public void baterdeneMaralTest1() throws NullKeyException {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // Add an element to the array
    arr.set("Array", "used to store multiple values in a single variable.");
    // Make sure that it's there.
    try {
      assertEquals("used to store multiple values in a single variable.", arr.get("Array"));
    } catch (KeyNotFoundException e) {
      fail("Could not set Array to the definition");
    }
    // Remove it.
    arr.remove("Array");
    // Make sure it's no longer there.
    try {
      // The following line should throw an exception
      arr.get("Array");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // baterdeneMaralTest1

  /**
   * If a user tries to set a key twice, then update the key to the last value.
   *
   * @throws KeyNotFoundException
   */
  @Test
  public void baterdeneMaralTest2() throws NullKeyException {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // Add an element to the array
    arr.set("Array", "not useful.");
    // Make sure that it's there.
    try {
      assertEquals("not useful.", arr.get("Array"));
    } catch (KeyNotFoundException e) {
      fail("Could not set Array to the wrong definition");
    }
    // Add the same key again to the array
    arr.set("Array", "used to store multiple values in a single variable.");
    // Make sure that the value has updated.
    try {
      assertEquals("used to store multiple values in a single variable.", arr.get("Array"));
    } catch (KeyNotFoundException e) {
      fail("Could not update Array to the right definition");
    }
  } // baterdeneMaralTest2()

  /**
   * Trying to remove from an empty array should result in nothing.
   * 
   * @throws NullKeyException
   */
  @Test
  public void baterdeneMaralEdge1() throws NullKeyException {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
      // Attempt to remove from an empty array
      arr.remove("Array");
      // Check that size remains 0
      assertEquals(0, arr.size(), "The empty array is not size of 0");
    } catch (Exception e) {
      fail("Could not remove from an empty array");
    }
  } // baterdeneMaralEdge1

} // class TestsFromStudent
