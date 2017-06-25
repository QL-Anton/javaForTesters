package ru.stqa.pft.sandbox;

public class MyFirstProgramm {

   public static void main ( String[] args){



       Square s=new Square(2);

     System.out.println("Площадь квадрата со стороной " + s.l+ " = "+s.area());



     Rectangle r=new Rectangle(234,434);

     System.out.println("Площадь прямоугольника = " + r.area());



     Point p1=new Point(4,3,0,0);




     System.out.println("Расстояние между двумя точками = "+p1.dist());
}





}