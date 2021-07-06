package ru.truakdsg.pft.sandbox;

public class Point {
  double x;
  double y;

  public Point(double x1, double y1) {

    this.x = x1;
    this.y = y1;
  }
  //Обращаемся к отрибутам выше
  public double distance(Point p2)
  {
    return Math.sqrt(Math.pow((p2.x-this.x),2)+Math.pow((p2.y-this.y),2));
  }
}
