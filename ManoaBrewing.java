package edu.ics211.h02;

/**
 * Represents the ManoaBrewing Brewery.
 * @author Billy Troy Wooton
 *
 */
public class ManoaBrewing implements IBrewery {
  
  private static ManoaBrewing instance;
  
  /**
   * Creates the singleton instance of ManoaBrewing if needed.
   * Is private to enforce the singleton pattern.
   */
  private ManoaBrewing() {}
  
  /**
   * Returns the singleton instance of ManoaBrewing.
   * @return the singleton ManoaBrewing instance.
   */
  public static ManoaBrewing getInstance() {
    if (instance == null) {
      instance = new ManoaBrewing();
    }
    return instance;
  }

  /* (non-Javadoc)
   * @see edu.ics211.h02.IBrewery#brewBeer(java.lang.String, edu.ics211.h02.BeerType)
   */
  @Override
  public Beer brewBeer(String name, BeerType type) {
    switch (type) {
      case PILSNER:
        return new Pilsner(name);
      case BOHEMIAN_PILSNER:
        return new BohemianPilsner(name);
      case INDIA_PALE_ALE:
        return new IndiaPaleAle(name);
      default:
        return new IndiaPaleAle(name);
    }
  }


  /* (non-Javadoc)
   * @see edu.ics211.h02.IBrewery#brewPilsner(java.lang.String, java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewPilsner(String name, Integer ibu, Double abv) {
    try {
      Beer result = new Pilsner(name, ibu, abv);
      return result;
    } catch (java.lang.IllegalArgumentException iae) {
      throw iae;
    }
  }


  /* (non-Javadoc)
   * @see edu.ics211.h02.IBrewery#brewBohemianPilsner(java.lang.String,
   * java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewBohemianPilsner(String name, Integer ibu, Double abv) {
    try {
      Beer result = new BohemianPilsner(name, ibu, abv);
      return result;
    } catch (java.lang.IllegalArgumentException iae) {
      throw iae;
    }
  }


  /* (non-Javadoc)
   * @see edu.ics211.h02.IBrewery#brewIndiaPaleAle(java.lang.String,
   * java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewIndiaPaleAle(String name, Integer ibu, Double abv) {
    try {
      Beer result = new IndiaPaleAle(name, ibu, abv);
      return result;
    } catch (java.lang.IllegalArgumentException iae) {
      throw iae;
    }
  }

}
