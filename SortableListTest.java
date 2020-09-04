package edu.ics211.h04;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

/**
 * SortableListTest to test the SortableList class.
 * 
 * @author Caliana Fortin
 *
 */
// https://github.com/cjalvarado/Course2Solutions/blob/master/Course2/src/textgen/MyLinkedListTester.java
public class SortableListTest {
  SortableList<Integer> al;
  SortableList<Integer> emptyList;
  SortableList<Integer> longList;
  SortableList<Integer> list;
  SortableList<Integer> selectionSortList;
  SortableList<Integer> insertionSortList;
  private final int longListLength = 10;
  Comparator<Integer> compare = new IntComparator();

  /**
   * IntComparator compares ints.
   * 
   * @author Caliana Fortin
   *
   */
  private class IntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer v1, Integer v2) {
      return v1 < v2 ? -1 : v1 > v2 ? +1 : 0;
    }
  }


  /**
   * Sets up allt he variables that are going to be used.
   * 
   * @throws Exception if not filled.
   */
  @Before
  public void setUp() throws Exception {
    emptyList = new SortableList<Integer>();
    al = new SortableList<Integer>();
    al.add(2);
    al.add(1);
    longList = new SortableList<Integer>();
    for (int i = 0; i < longListLength; i++) {
      longList.add(i);
    }
    list = new SortableList<Integer>(); // create a new sortableList object called list
    list.add(1);
    list.add(6);
    list.add(8);
    selectionSortList = new SortableList<Integer>();
    selectionSortList.add(2);
    selectionSortList.add(1);

    insertionSortList = new SortableList<Integer>();
    insertionSortList.add(3);
    insertionSortList.add(7);
    insertionSortList.add(0);
    // compare = new Comparator(); don't know how to make a comparator to use
  }


  /**
   * Test method for sortableList.
   */
  @Test
  public void testSortableList() {
    new SortableList<Integer>();
  }

  /*
   * 
   * @Test public void testMain() { fail("Not yet implemented"); }
   */


  /**
   * Test method for insertionSort.
   */
  @Test
  public void testInsertionSort() {
    insertionSortList.insertionSort(compare); // can't get this to work but this should sort the
    // sorList using insertion sort
    // assertEquals(3, selectionSortList.size());
    assertEquals(0, (int) insertionSortList.get(0)); // makes sure the items at index 0 is 0
    assertEquals(3, (int) insertionSortList.get(1)); // makes sure the items at index 1 is 3
    assertEquals(7, (int) insertionSortList.get(2));
  }


  /**
   * Test method for bubbleSort.
   */
  @Test
  public void testBubbleSort() {
    insertionSortList.bubbleSort(compare); // can't get this to work but
    // this should sort the sorList using bubble sort
    // assertEquals(2, selectionSortList.size());
    assertEquals(0, (int) insertionSortList.get(0)); // makes sure the items at index 0 is 1
    assertEquals(3, (int) insertionSortList.get(1)); // makes sure the items at index 1 is 2
    assertEquals(7, (int) insertionSortList.get(2));
  }


  /**
   * Test method for selectionSort.
   */
  @Test
  public void testSelectionSort() {
    selectionSortList.selectionSort(compare);// can't get this to work but
    // this should sort the sorList using selection sort
    assertEquals(2, selectionSortList.size());
    assertEquals(1, (int) selectionSortList.get(0)); // makes sure the items at index 0 is 1
    assertEquals(2, (int) selectionSortList.get(1)); // makes sure the items at index 1 is 2
  }


  /**
   * Test method for the number of swaps.
   */
  @Test
  public void testGetNumberOfSwaps() {
    // number of swaps for al should be 1
    assertEquals(1, selectionSortList.getNumberOfSwaps());
    assertEquals(1, insertionSortList.getNumberOfSwaps());
  }


  /**
   * Test method for getNumberOfComparisions.
   */
  @Test
  public void testGetNumberOfComparisons() {
    // number of comparisions should be 2
    assertEquals(selectionSortList.size(), selectionSortList.getNumberOfComparisons());
    // number of comparisions is equal to the size()
  }


  /**
   * Test method for getsortTime.
   */
  @Test
  public void testGetSortTime() {
    // the sort time should equal the length
    al.getSortTime();
    // int expectedOutput = al.size();
    // assertEquals(expectedOutput, al.getSortTime());
    // make sure the sortTime is the expected time
  }


  /**
   * Test method for get.
   */
  @Test
  public void testGet() {
    try {
      emptyList.get(0); // get an item that doesn't exist
      fail("Check out of bound");

    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }
    // int expectedOutput = 2;
    assertEquals(Integer.valueOf(2), al.get(0));
    assertEquals(Integer.valueOf(1), al.get(1));
    try {
      al.get(-1); // get an item that is less than size
      fail("Check out of bound");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }
    try {
      al.get(2); // get an item that is larger than size
      fail("Check out of bound");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }
    try {
      longList.get(longListLength); // get an item that is at size
      fail("Check out of bound");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");

    }
  }


  /**
   * Test method for set.
   */
  @Test
  public void testSet() {
    assertEquals(2, al.size());// al size should be at 2
    try {
      al.set(-1, 3); // tries to set an item at index -1
      fail("Set Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }
    try {
      al.set(3, 3);
      fail("Set Check out of bounds"); // tries to set an iem at a larger index
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }

    al.set(0, 3); // sets valid item at valid index
    assertEquals("set: check al contents ", Integer.valueOf(3), al.get(0));
    assertEquals("set: check al contents ", Integer.valueOf(1), al.get(1));
    assertEquals("set: check size", 2, al.size());
    al.set(0, 2); // restore
  }


  /**
   * Test method for indexOf.
   */
  @Test
  public void testIndexOf() {
    assertEquals(2, al.size());

    assertEquals(-1, list.indexOf(7)); // no 7 should return -1

    assertEquals("set: check al contents ", Integer.valueOf(1), list.get(0));
    // Object obj = 1;
    int index = 0;
    assertEquals(index, list.indexOf(Integer.valueOf(1))); // should return 0 can't get this to work

  }


  /**
   * Test method for size.
   */
  @Test
  public void testSize() {
    assertEquals(2, al.size()); // make sure the size of al is 2
    assertEquals(10, longList.size()); // make sure the size of longList is 10
    assertEquals(0, emptyList.size()); // make Sure the size of emptyList is 0
  }


  /**
   * Test method for addE.
   */
  @Test
  public void testAddE() {
    al.add(3); // add the element
    assertEquals("AddEnd: check al contents ", Integer.valueOf(2), al.get(0));
    // at 0 stayed the same
    assertEquals("AddEnd: check al contents ", Integer.valueOf(1), al.get(1)); // make sure the
    // value at 1 stayed the same
    assertEquals("AddEnd: check al contents ", Integer.valueOf(3), al.get(2)); // make sure
    // the value added is at index 2 is 2
    al.remove(2); // remove 3
  }


  /**
   * Test method for addIntE.
   */
  @Test
  public void testAddIntE() {
    al.add(1, 5);
    assertEquals("AddAtIndex: check al contents ", Integer.valueOf(2), al.get(0));
    assertEquals("AddAtIndex: check al contents ", Integer.valueOf(5), al.get(1));// makes sure
    // the value is added correctly
    assertEquals("AddAtIndex: check al contents ", Integer.valueOf(1), al.get(2));
    al.remove(1);// remove 5
    al.add(0, 1);
    assertEquals("AddAtIndex: check al contents ", Integer.valueOf(1), al.get(0));// makes sure the
    // value is added correctly
    assertEquals("AddAtIndex: check al contents ", Integer.valueOf(2), al.get(1));
    assertEquals("AddAtIndex: check al contents ", Integer.valueOf(1), al.get(2));
    al.remove(0);// remove 1
    // add to invalid location
    try {
      al.add(-1, 7);
      fail("AddAtIndex Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }
    try {
      al.add(3, 8);
      fail("AddAtIndex Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }
    try {
      al.add(1, null);
      fail("AddAtIndex null insertion");
    } catch (NullPointerException e) {
      System.out.println("Index out of bounds.");
    }
  }


  /**
   * Test method for remove.
   */
  @Test
  public void testRemove() {
    assertEquals(3, list.size());
    assertEquals("AddAtIndex: check al contents ", Integer.valueOf(1), list.get(0));
    assertEquals("remove: check al contents ", Integer.valueOf(8), list.remove(2));
    list.add(8); // restores 8 that was removed
    try {
      list.remove(3);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bounds.");
    }

  }

}