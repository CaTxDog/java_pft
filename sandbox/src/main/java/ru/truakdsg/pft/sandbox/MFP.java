package ru.truakdsg.pft.sandbox;

public class MFP {


  public static void main(String[] args) {
    Point p1 = new Point(1,2);
    Point p2 = new Point(3,4);
    System.out.println("Расстояние между точками P1("+p1.x+","+p1.y+") и P2("+p2.x+","+p2.y+") = " + p1.distance(p2));
  }
}