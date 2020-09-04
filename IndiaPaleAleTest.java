package edu.ics211.h02.bwooton.src.edu.ics211.h02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test class for testing the IndiaPaleAle class.
 * @author Billy Troy Wooton
 *
 */
public class IndiaPaleAleTest {

  /**
   * Test method for {@link edu.ics211.h02.IndiaPaleAle#IndiaPaleAle(java.lang.String)}.
   */
  @Test
  public void testIndiaPaleAleString() {
    IndiaPaleAle ipa = new IndiaPaleAle("My Favorite IPA");
    assertNotNull("Should have created an IndiaPaleAle", ipa);
    assertEquals("Should have the right name", "My Favorite IPA", ipa.getName());
    assertEquals("Should have the right type", BeerType.INDIA_PALE_ALE, ipa.getType());
    assertTrue("Should have valid ibu", ipa.getIbu() > 39 && ipa.getIbu() < 100);
    assertTrue("Should have valid abv", ipa.getAbv() >= 5.0 && ipa.getAbv() <= 10.0);
  }
  
  /**
   * Test method for {@link edu.ics211.h02.IndiaPaleAle#IndiaPaleAle(java.lang.String,
   * java.lang.Integer, java.lang.Double)}.
   */
  @Test
  public void testIndiaPaleAleStringIntegerDouble() {
    IndiaPaleAle ipa = new IndiaPaleAle("My Sunday IPA", 75, 6.5);
    assertNotNull("Should have created an IndiaPaleAle", ipa);
    assertEquals("Should have the right name", "My Sunday IPA", ipa.getName());
    assertTrue("Should have the right ibu", 75 == ipa.getIbu());
    assertEquals("Should have the right abv", 6.5, ipa.getAbv(), 0.0001);
    assertEquals("Should have the right type", BeerType.INDIA_PALE_ALE, ipa.getType());
    try {
      ipa = new IndiaPaleAle("Bad, Bad, Bad", 35, 5.0);
      fail("Should not create an IPA with that IBU");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      ipa = new IndiaPaleAle("Bad, Bad, Bad", 75, 4.9);
      fail("Should not create an IPA with that ABV");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
  }
  
  /**
   * Test method for {@link edu.ics211.h02.Beer#setName(java.lang.String)}.
   */
  @Test
  public void testSetName() {
    IndiaPaleAle ipa = new IndiaPaleAle("My Poorly Named IPA", 66, 5.0);
    assertEquals("Should have the right name", "My Poorly Named IPA", ipa.getName());
    ipa.setName("Best IPA in the biz");
    assertEquals("Should have the right name", "Best IPA in the biz", ipa.getName());
  }

}
