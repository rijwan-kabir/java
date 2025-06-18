import java.util.*;
public class Student{
    private String Name;
    private String Id;
    private double cgpa;

    public Student(String nm, String id, double cgpA){
        Name=nm;
        Id=id;
        cgpa=cgpA;
    }
    public void Display(){
        System.out.println("Student Name: "+Name);
        System.out.println("Student Id: "+Id);
        System.out.println("Cgpa is: "+cgpa);
    }
    public double Cgpa(){
        return cgpa;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name,Id and Cgpa: ");
        String Nm=sc.nextLine();
        String Id=sc.nextLine();
        double cg=sc.nextDouble();
        Student s=new Student(Nm, Id, cg);
        s.Display();
        System.out.println("Another cg: "+s.Cgpa());
        sc.close();
    }
}