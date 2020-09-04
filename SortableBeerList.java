/**
 * SortableBeerList.java
 * Copyright (C) Caliana Fortin 2018
 */

package edu.ics211.h05;

import edu.ics211.h02.Beer;
import edu.ics211.h05.SortableList.IList211;
import java.util.Comparator;

/**
 * SortableBeerList.
 * 
 * @author Caliana Fortin
 *
 */
public class SortableBeerList implements IList211<Beer> {

  private SortableList<Beer> list;
  Comparator<Beer> compare;


  /**
   * Creates a new SortableBeerList.
   * 
   * @param compare compares the beers
   */
  public SortableBeerList(Comparator<Beer> compare) {
    list = new SortableList<Beer>();
  }


  @Override
  public Beer get(int index) {
    return this.list.get(index);

  }


  @Override
  public Beer set(int index, Beer element) {
    return this.list.set(index, element);
    // I know it has to sort after adding the element here
    // keep getting a null pointer exception when trying to sort 

  }


  @Override
  public int indexOf(Object obj) {
    return this.list.indexOf(obj);
  }


  @Override
  public int size() {
    return this.list.size();
  }


  @Override
  public boolean add(Beer e) {
    return this.list.add(e);
    // I know it has to sort after adding the element here
  }


  @Override
  public void add(int index, Beer element) {
    this.list.add(index, element);
    // I know it has to sort after adding the element here

  }


  @Override
  public Beer remove(int index) {
    return this.list.remove(index);
  }

}
