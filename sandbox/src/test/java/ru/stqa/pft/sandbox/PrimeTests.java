package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Антон on 05.08.2017.
 */
public class PrimeTests {

  @Test

  public void testPrime(){
    Assert.assertTrue(Prime.isPrime(Integer.MAX_VALUE));

  }

  @Test
  public void testNonPrime(){
    Assert.assertFalse(Prime.isPrime(18));
  }
}
