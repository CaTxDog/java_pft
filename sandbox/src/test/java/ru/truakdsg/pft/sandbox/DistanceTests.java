package ru.truakdsg.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testArea () {
    Point p1 = new Point(1,2);
    Point p2 = new Point(3,4);
    Point p3 = new Point(0,0);
    assert p1.distance(p2) == 2.8284271247461903;
    Assert.assertEquals(p1.distance(p2), p2.distance(p1));
    Assert.assertNotEquals(p1.distance(p3), p2.distance(p3));
  }

  @Test
  public void testSquare () {
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,5);
    Point p3 = new Point(5,5);
    Point p4 = new Point(5,0);
    assert p1.distance(p2) == 5;
    Assert.assertEquals(p1.distance(p2), p1.distance(p4));
    Assert.assertNotEquals(p1.distance(p2), p1.distance(p3));
    Assert.assertEquals(p1.distance(p2)*p1.distance(p4), 25);
  }

  @Test
  public void testInt(){
    int a = 5;
    double  b = 5.0;
    Assert.assertEquals(a,b);
    Assert.assertEquals(5, 5.0);
    Assert.assertEquals(5.0, 5);
  }
}
