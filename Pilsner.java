
package edu.ics211.h02.bwooton.src.edu.ics211.h02;

/**
 * Represents a Pilsner which is a type of Beer.
 * @author Billy Troy Wooton
 *
 */
public class Pilsner extends Beer {
  
  /**
   * Creates a new Pilsner beer.
   * @param name the name of the Pilsner.
   * @param ibu the ibu value of the Pilsner.
   * @param abv the abv value of the Pilsner.
   */
  public Pilsner(String name, Integer ibu, Double abv) {
    super(name, BeerType.PILSNER, ibu, abv);
    if (ibu < 25 || ibu > 45) {
      throw new java.lang.IllegalArgumentException("Invalid IBU value for Pilsner.");
    }
    if (abv < 4.2 || abv > 6.0) {
      throw new java.lang.IllegalArgumentException("Invalid ABV value for Pilsner.");
    }
  }
  
  /**
   * Creates a new Pilsner beer.
   * @param name the name of the Pilsner.
   */
  public Pilsner(String name) {
    super(name, BeerType.PILSNER);
    Integer ibu = (int)Math.floor((Math.random() * 20)) + 25;
    Double abv = Math.random() * 1.8 + 4.2;
    this.ibu = ibu;
    this.abv = abv;
  }
  
  /**
   * Creates a new Pilsner beer.
   * @param name the name of the Pilsner beer.
   * @param type the type of the Pilsner beer.
   * @param ibu the IBU value of the Pilsner beer.
   * @param abv the ABV value of the Pilsner beer.
   */
  protected Pilsner(String name, BeerType type, Integer ibu, Double abv) {
    super(name, type, ibu, abv);
  }
  
  protected Pilsner(String name, BeerType type) {
    super(name, type);
  }

}
