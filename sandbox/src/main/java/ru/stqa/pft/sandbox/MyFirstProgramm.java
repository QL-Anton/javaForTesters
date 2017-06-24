package ru.stqa.pft.sandbox;

public class MyFirstProgramm {

   public static void main ( String[] args){
       hello("ble");
       double l=5;
     System.out.println("Площадь квадрата со стороной " +l+ " = "+area(l));
     double a=5;
     double b=34223523;
     System.out.println("Площадь прямоугольника = " + area(a,b));
}
public static void hello(String somebody){
  System.out.println("Hellow, "+ somebody + "!");

  }

  public static double area(double len){
  return len*len;
  }
  public static double area(double a, double b){
    return a*b;
  }
}