package ru.stqa.pft.sandbox;

public class MyFirstProgramm {

   public static void main ( String[] args){
       hello("ble");


       Square s=new Square(435);

     System.out.println("Площадь квадрата со стороной " + s.l+ " = "+s.area());



     Rectangle r=new Rectangle(234,434);

     System.out.println("Площадь прямоугольника = " + r.area());
}
public static void hello(String somebody){
  System.out.println("Hellow, "+ somebody + "!");

  }



}