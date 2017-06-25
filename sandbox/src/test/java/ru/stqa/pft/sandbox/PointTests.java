package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Антон on 25.06.2017.
 */
public class PointTests {

  @Test
  public void testDist(){
    Point p1=new Point(4,3,0,0);
        Assert.assertEquals(p1.dist(),5.0);

  }
}
