package edu.ics211.h02.bwooton.src.edu.ics211.h02;

/**
 * Represents an India Pale Ale (IPA) which is a kind of Beer.
 * @author Billy Troy Wooton
 *
 */
public class IndiaPaleAle extends Beer {
  /**
   * Creates a new IndiaPaleAle.
   * @param name the name of the IndiaPaleAle.
   * @param ibu the IBU value of the IndiaPaleAle.
   * @param abv the ABV value of the IndiaPaleAle.
   */
  public IndiaPaleAle(String name, Integer ibu, Double abv) {
    super(name, BeerType.INDIA_PALE_ALE, ibu, abv);
    if (ibu < 40 || ibu > 100) {
      throw new java.lang.IllegalArgumentException("Invalid IBU value for IndiaPaleAle.");
    }
    if (abv < 5.0 || abv > 10.0) {
      throw new java.lang.IllegalArgumentException("Invalid ABV value for IndiaPaleAle.");
    }
  }
  
  /**
   * Creates a new IndiaPaleAle.
   * @param name the name of the IndiaPaleAle.
   */
  public IndiaPaleAle(String name) {
    super(name, BeerType.INDIA_PALE_ALE);
    Integer ibu = 40 + (int)(Math.random() * 60);
    Double abv = 5.0 + (Math.random() * 5.0);
    this.ibu = ibu;
    this.abv = abv;
  }
  
}
