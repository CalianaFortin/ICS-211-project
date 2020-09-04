/**
 * SortableList.java

 * Copyright (C) Caliana Fortin 2018
 */

package edu.ics211.h05;

import edu.ics211.h04.SortableList.IList211;
import edu.ics211.h04.SortableList.ISortableList;
import java.util.Comparator;

/**
 * SortableList sorts the items in a given List.
 * 
 * @author Caliana Fortin
 * @param <E>
 *
 */
public class SortableList<E> implements ISortableList<E>, IList211<E> {
  /**
   * DLinkedNode a private inner class to stores the items in the list.
   * 
   * @author Caliana Fortin
   * @param <E> the type.
   */
  private static class DLinkedNode<E> { // passes in the e from sortable List
    E item;
    DLinkedNode<E> next;
    DLinkedNode<E> prev;


    public DLinkedNode(E item, DLinkedNode<E> next, DLinkedNode<E> prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;

    }

  }

  private DLinkedNode<E> head;

  private int swap = 0;

  private int comparisons = 0;

  private static long startTime;

  private int size = 0;

  private double estimatedTime;

  private long endTime;

  private DLinkedNode<E> tail;

  /**
   * Interface for a List211.
   *
   * @author Cam Moore
   * @param <E> the generic type of the Lists.
   */
  public interface IList211<E> {
    /**
     * Gets the item at the given index.
     * 
     * @param index the index.
     * @return the item at the given index.
     */
    E get(int index);


    /**
     * Sets the item at the given index.
     * 
     * @param index the index.
     * @param element the new element to set.
     * @return the old element at index.
     */
    E set(int index, E element);


    /**
     * Returns the index of the given obj or -1.
     * 
     * @param obj the object to find.
     * @return the index of the given obj or -1.
     */
    int indexOf(Object obj);


    /**
     * Returns the size of this list.
     * 
     * @return the size of this list.
     */
    int size();


    /**
     * Adds e to the end of the list.
     * 
     * @param e the item to add.
     * @return true if successful, false otherwise.
     */
    boolean add(E e);


    /**
     * Adds element to the list at the given index.
     * 
     * @param index the index.
     * @param element the element to add.
     */
    void add(int index, E element);


    /**
     * Removes the element at the given index.
     * 
     * @param index the index.
     * @return The element removed from the list.
     */
    E remove(int index);
  }

  /**
   * Interface for a SortableList.
   *
   * @author Cam Moore
   * @param <E> generic type.
   */
  public interface ISortableList<E> {

    /**
     * Sorts the list using the insertion sort.
     * 
     * @param compare a Comparator that determines order.
     */
    void insertionSort(Comparator<E> compare);


    /**
     * Sorts the list using the bubble sort.
     * 
     * @param compare a Comparator that determines order.
     */
    void bubbleSort(Comparator<E> compare);


    /**
     * Sorts the list using the selection sort.
     * 
     * @param compare a Comparator that determines order.
     */
    void selectionSort(Comparator<E> compare);


    /**
     * Returns the number of swaps for the last sort.
     * 
     * @return the number of swaps for the last sort.
     */
    int getNumberOfSwaps();


    /**
     * Returns the number of comparisons for the last sort.
     * 
     * @return the number of comparisons for the last sort.
     */
    int getNumberOfComparisons();


    /**
     * Returns the time it took to sort the list.
     * 
     * @return the time it took to sort the list.
     */
    double getSortTime();
  }


  /**
   * Creates a new SortableList.
   */
  public SortableList() {
    //SortableList sll = new SortableList();
    this.head = null;
    this.tail = null;
    this.size = 0;
    /*
     * if (head == null) { 
     * head = new DLinkedNode<E> (head.item, null, null); 
     * tail = head; } 
     * else { DLinkedNode<E> node
     * = new DLinkedNode<E>(tail.next.item, null, tail); 
     * this.tail.next = node; this.tail = node; 
     * }
     */
  }
  
  /**
   * Used to test methods in SortableList.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    
  }


  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    DLinkedNode<E> temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp.item;
  }


  @Override
  public E set(int index, E element) {
    // TODO Auto-generated method stub
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    DLinkedNode<E> temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    E retval = temp.item;
    temp.item = element;

    return retval;
  }


  @Override
  public int indexOf(Object obj) {
    // TODO Auto-generated method stub
    DLinkedNode<E> temp = head;
    for (int i = 0; i < size; i++) {
      if (temp.item.equals(obj)) {
        return i;
      }
      temp = temp.next;
    }
    return -1;
  }


  @Override
  public int size() {

    return size;
  }


  @Override
  public boolean add(E e) {
    DLinkedNode<E> n = new DLinkedNode<E>(e, null, head);
    if (size() == 0) {
      head = n;
      tail = n;
    } else { 
      tail.next = n;
      n.prev = tail;
      tail = n;
    }
    size++;
    return true;
    
    /*if (head == null) {
      head = new DLinkedNode<E>(e, null, head);
      size++;
      return true;
    } else {
      DLinkedNode<E> temp = head;
      for (int i = 0; i < size - 1; i++) {
        temp = temp.next;
      }
      temp.next = new DLinkedNode<E>(e, temp.next, temp.prev);
      size++;
      return true;
    }*/
  }


  @Override
  public void add(int index, E element) {
    // TODO Auto-generated method stub
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    if (index == 0) {
      DLinkedNode<E> node = new DLinkedNode<E>(element, head, null);
      head = node;
      size++;
    } else {
      DLinkedNode<E> temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      DLinkedNode<E> node = new DLinkedNode<E>(element, temp.next, temp);
      temp.next = node;
      if (temp.next.next != null) {
        temp.next.next.prev = temp.next;
      }
      size++;
    }
    if (element == null) {
      throw new NullPointerException();
    }
    // size++;
  }


  @Override
  public E remove(int index) {
    // TODO Auto-generated method stub
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    if (index == 0) {
      E oldvalue = head.item;
      head = head.next;
      size--;
      return oldvalue;
    } else {
      DLinkedNode<E> temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      E removed = temp.next.item;
      temp.next = temp.next.next;
      size--;
      return removed;
    }
  }


  @Override
  public void insertionSort(Comparator<E> compare) {

    startTime = System.nanoTime();
    // found at https://www.geeksforgeeks.org/insertion-sort/
    // found at http://courses.ics.hawaii.edu/ReviewICS211/morea/060.simple-sorting/reading-insertion-sort-soln.html
    // https://stackoverflow.com/questions/46923848/how-to-use-insertion-sort-on-doubly-linked-list-c
    int comparisonsInsertionSort = 0;
    int swapInsertionSort = 0;
    DLinkedNode<E> current;
    DLinkedNode<E> marker;
    for (marker = head.next; marker != null; marker = marker.next) {
      E temp = marker.item;
      current = marker;
      comparisonsInsertionSort++;
      while (current.prev != null && compare.compare(current.prev.item, temp) > 0) {
        current.item = current.prev.item;
        current = current.prev;
        swapInsertionSort++;
      }
      current.item = temp;
    }
 
    /* my solution, not efficient
     * for (int i = 1; i < size(); i++) {
      comparisonsInsertionSort++;
      E tempVal = get(i);
      int j = i;
      while (j > 0 && compare.compare(get(j - 1), tempVal) > 0) {

        set(j, get(j - 1));
        swapInsertionSort++;
        comparisonsInsertionSort++;
        j--;
      }
      set(j, tempVal);
    }*/
    comparisons = comparisonsInsertionSort;
    swap = swapInsertionSort;
    endTime = System.nanoTime();
    getSortTime();

  }


  @Override
  public void bubbleSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    int comparisonsBubbleSort = 0;
    int swapBubbleSort = 0;
    boolean done = false;
    while (!done) {
      DLinkedNode<E> current;
      done = true;
      comparisonsBubbleSort ++;
      for (current = head; current.next != null; current = current.next) {
        //comparisonsBubbleSort++;
        if (compare.compare(current.item, current.next.item) > 0) {
          swap(current.next, current);
          swapBubbleSort++;
          comparisonsBubbleSort++;
          done = false;
        }
        //comparisonsBubbleSort ++;
      }
    }
    /*
     * for (int i = 0; i < size() - 1; i++) { 
     * for (int j = 0; j < size() - i - 1; j++) { 
     * int result = compare.compare(get(j), get(j + 1)); 
     * comparisonsBubbleSort ++; 
     * if (result > 0) { E temp = get(j); 
     * set(j, get(j + 1)); 
     * set(j + 1, temp); 
     * swapBubbleSort++; } } }
     */
    swap = swapBubbleSort;
    comparisons = comparisonsBubbleSort;
    endTime = System.nanoTime();
    getSortTime();
  }


  private void swap(DLinkedNode<E> node1, DLinkedNode<E> node2) {
    // TODO Auto-generated method stub
    E temp = node1.item;
    node1.item = node2.item;
    node2.item = temp;

  }


  @Override
  public void selectionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    // https://www.geeksforgeeks.org/selection-sort/
    // https://www.daniweb.com/programming/software-development/threads/419177/selection-sort-linked-list
    int comparisonsSelectionSort = 0;
    int swapSelectionSort = 0;
    DLinkedNode<E> h = head;
    DLinkedNode<E> i = head;
    DLinkedNode<E> j = head;
    for (i = h; i != null && i.next != null; i = i.next) {
      DLinkedNode<E> min;
      min = i; //min is the node at i
      comparisonsSelectionSort++;
      for (j = i.next; j != null; j = j.next) {
        comparisonsSelectionSort++;
        if (compare.compare(j.item, min.item) < 0) { //j item to the right
          min = j; //min is i.next item to the left 
        }
        if (min != i) { 
          swapSelectionSort++;
          swap(min, i);
        }
      }
    }
    head = h;
    comparisons = comparisonsSelectionSort;
    swap = swapSelectionSort;
    endTime = System.nanoTime();
    getSortTime();
  }


  @Override
  public int getNumberOfSwaps() {
    return swap;
  }


  @Override
  public int getNumberOfComparisons() {
    return comparisons;
  }


  @Override
  public double getSortTime() {
    // TODO Auto-generated method stub
    estimatedTime = (endTime - startTime);
    return estimatedTime;
  }

}