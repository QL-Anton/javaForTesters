package ru.stqa.pft.sandbox;

/**
 * Created by Антон on 24.06.2017.
 */
public class Point {
  public double a;
  public double b;
  public double c;
  public double d;

  public Point(double a, double b,double c, double d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  public double dist() {

  return Math.sqrt((this.a*this.a-this.c*this.c)+(this.b*this.b-this.d*this.d));


}
}
