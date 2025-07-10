//Department
import java.util.ArrayList;

class Course{
    private int code;
    private double credit;
    public Course(int code,double credit){
        this.code=code;
        this.credit=credit;
    }
    public void display(){
        System.out.println("Course Code: "+code+" Credit: "+credit);
    }
}
class Professor{
    private int id;
    ArrayList<Course>courses;
    ArrayList<Department>dept=new ArrayList<>();
    public Professor(int id){
        this.id=id;
        courses=new ArrayList<>();

    }
    public void addCourse(Course c){
        courses.add(c);
    }
    public void adddept(Department d){
         dept.add(d);
    }
    public void display(){
        System.out.println("Professor ID: "+id);
        for(Course c:courses){
            c.display();
        }
        System.out.println("Professor assign dept:");
        for(Department d:dept){
            System.out.println("Department assigned by: "+d.getId());
        }
    }
}
class Department{
    private int id;
    ArrayList<Professor>prof=new ArrayList<Professor>();
    public Department(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void addProf(Professor p){
        prof.add(p);
        p.adddept(this);
    }
    
    public void display(){
        System.out.println("Department ID: "+id);
        for(Professor p:prof){
            p.display();
            System.out.println();
        }
        System.out.println("===============================\n");
    }
}
public class Main{
    public static void main(String[] args) {
    Department cse=new Department(1);
    Department swe=new Department(2);

    Professor sah=new Professor(1);
    Professor bcd=new Professor(2);
    Professor tar=new Professor(3);

    Course oop=new Course(221, 3);
    Course oopl=new Course(222,1.5);
    Course pps=new Course(101, 3);
    Course em=new Course(201, 3);

    cse.addProf(sah);
    cse.addProf(tar);
    swe.addProf(bcd);
    swe.addProf(sah);

    sah.addCourse(oop);
    sah.addCourse(oopl);
    tar.addCourse(pps);
    tar.addCourse(pps);
    bcd.addCourse(em);

    cse.display();
    swe.display();
    }
}