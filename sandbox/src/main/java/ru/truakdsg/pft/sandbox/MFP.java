package ru.truakdsg.pft.sandbox;

public class MFP {

  public static double distance(Point p1, Point p2)
  {
    return Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
  }
  public static void main(String[] args) {
    Point p1 = new Point(1,2);
    Point p2 = new Point(3,4);
    System.out.println(distance(p1,p2));
  }
}