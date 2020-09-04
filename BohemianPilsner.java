package edu.ics211.h02.bwooton.src.edu.ics211.h02;

/**
 * Represents a Bohemian Pilsner, which is a type of Pilsner.
 * @author Billy Troy Wooton
 *
 */
public class BohemianPilsner extends Pilsner {
  
  /**
   * Creates a new Bohemian Pilsner.
   * @param name the name of the Bohemian Pilsner.
   * @param ibu the IBU of the Bohemian Pilsner.
   * @param abv the ABV of the Bohemian Pilsner.
   */
  public BohemianPilsner(String name, Integer ibu, Double abv) {
    super(name, BeerType.BOHEMIAN_PILSNER, ibu, abv);
    if (ibu < 35 || ibu > 45) {
      throw new java.lang.IllegalArgumentException("Invalid IBU for BohemianPilsner.");
    }
    if (abv < 4.2 || abv > 5.4) {
      throw new java.lang.IllegalArgumentException("Invalid ABV for BohemianPilsner.");    
    }  
  }
  
  /**
   * Creates a new Bohemian Pilsner.
   * @param name the name of the Bohemian Pilsner.
   */
  public BohemianPilsner(String name) {
    super(name, BeerType.BOHEMIAN_PILSNER);
    Integer ibu = 35 + (int)(Math.random() * 10);
    Double abv = 4.2 + (Math.random() * (5.4 - 4.2));
    this.ibu = ibu;
    this.abv = abv;
  }
}
