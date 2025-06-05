import java.util.*;
public class Circle{
    private double radius;
    public Circle(double r){
        radius=r;
    }
    public void Display(){
      System.out.println("Radius is: "+ radius);
    }
    public double Area(){
        return Math.PI*radius*radius;
    }
    public double Circumference(){
        return 2*Math.PI*radius;
    }
    public static void main(String[] a){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the Radius: ");
       double r = sc.nextDouble();
       Circle c= new Circle(r);
       c.Display();
       double A= c.Area();
       double C=c.Circumference();
       System.out.println("Area is: "+ A);
       System.out.println("Circumference is: "+C);

    }
}