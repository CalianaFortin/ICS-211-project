package edu.ics211.h02;

/**
 * Represents a generic Beer.
 * @author Billy Troy Wooton
 *
 */
public abstract class Beer implements Comparable<Beer> {
  
  private String name;
  private BeerType type;
  protected Integer ibu;
  protected Double abv;
  
  /**
   * Creates a new Beer.
   * @param name the name of the new Beer.
   * @param type the type of the new Beer.
   */
  public Beer(String name, BeerType type) {
    this.name = name;
    this.type = type;
  }
  
  /**
   * Creates a new Beer.
   * @param name the name of the new Beer.
   * @param type the type of the new Beer.
   * @param ibu The IBU of the new Beer.
   * @param abv The ABV of the new Beer.
   */
  public Beer(String name, BeerType type, Integer ibu, Double abv) {
    this.name = name;
    this.type = type;
    this.ibu = ibu;
    this.abv = abv;
  }
  
  /**
   * Gets the name of the Beer.
   * @return the String representing the name of the Beer.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the Beer.
   * @param name the new name of the Beer.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the type of the Beer.
   * @return the type of the Beer.
   */
  public BeerType getType() {
    return type;
  }

  /**
   * Gets the IBU (bitterness rating) of the Beer.
   * @return the IBU value of the Beer.
   */
  public Integer getIbu() {
    return ibu;
  }
  
  /**
   * Gets the ABV (alcohol-by-volume) of the Beer.
   * @return the ABV value of the Beer.
   */
  public Double getAbv() {
    return abv;
  }

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Beer o) {
    return this.name.compareTo(o.name);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Beer [name=" + name + "]";
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((abv == null) ? 0 : abv.hashCode());
    result = prime * result + ((ibu == null) ? 0 : ibu.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Beer other = (Beer) obj;
    if (abv == null) {
      if (other.abv != null) {
        return false;
      }
    } else if (!abv.equals(other.abv)) {
      return false;
    }
    if (ibu == null) {
      if (other.ibu != null) {
        return false;
      }
    } else if (!ibu.equals(other.ibu)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (type != other.type) {
      return false;
    }
    return true;
  }
  

}
