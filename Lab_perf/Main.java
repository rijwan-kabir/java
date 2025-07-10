import java.util.ArrayList;

class Course{
    private int code;
    private double credit;
    public Course(int code,double credit){
        this.code=code;
        this.credit=credit;
    }
    public void display(){
        System.out.println("code: "+code+" "+"Credit: "+credit);
    }
}

class Professor{
    private int id;
    private Course c;
    ArrayList<Course>cr=new ArrayList<Course>();

    public Professor(int id){
        this.id=id;
    }
    public void addc(Course c){
        this.c=c;
        cr.add(c);
    }
    public void display(){
        System.out.println("ID: "+id);
        for(int i=0;i<cr.size();i++){
            cr.get(i).display();
        }
    }
}

class Department{
    private int deptid;
    private Professor p;
    ArrayList<Professor>pr=new ArrayList<Professor>();

    public Department(int deptid,Professor p){
        this.deptid=deptid;
        this.p=p;
        pr.add(p);
    }
    public void display(){
        System.out.println("Department id: "+deptid);
        for(int i=0;i<pr.size();i++){
            pr.get(i).display();
        }
    }
}

public class Main{
  public static void main(String[] a){
    Course c1=new Course(1, 3);
    Course c2=new Course(2, 1.5);

    Professor p=new Professor(1);
    p.addc(c1);
    p.addc(c2);

    Department d=new Department(15, p);
    
    d.display();
  }
}