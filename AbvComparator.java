/**
 * AbvComparator.java

 * Copyright (C) Caliana Fortin 2018
 */

package edu.ics211.h02;

import java.util.Comparator;

/**
 * AbvComparator compares abvs.
 * 
 * @author Caliana Fortin
 *
 */
public class AbvComparator implements Comparator<Beer> {

  
  /* (non-Javadoc)
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  public int compare(Beer o1, Beer o2) {
    if (o1.abv > o2.abv) {
      return 1;
    } else if (o1.abv < o2.abv) {
      return -1;
    } else {
      return 0;
    }
  }


  /**
   * to Test.
   * 
   * @param args not used.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
