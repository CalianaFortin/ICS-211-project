/**
 * IbuComparator.java

 * Copyright (C) Caliana Fortin 2018
 */

package edu.ics211.h02;

import java.util.Comparator;

/**
 * IbuComparator.
 * 
 * @author Caliana Fortin
 *
 */
public class IbuComparator implements Comparator<Beer> {
  /* (non-Javadoc)
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  public int compare(Beer o1, Beer o2) {
    // TODO Auto-generated method stub
    return o1.ibu - o1.ibu;
  }


  /**
   * To test the comparator.
   * 
   * @param args takes in no arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
