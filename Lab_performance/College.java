import java.util.ArrayList;

class Course{
    private String courseCode;
    private String courseTitle;

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Title: " + courseTitle);
    }

}

public class College{
    private String collegeName;
    private String location;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public College(String collegeName, String location) {
        this.collegeName = collegeName;
        this.location = location;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void listCourses() {
        System.out.println("Courses offered by " + collegeName + ":");
        for (Course c : courses) {
            c.displayCourseInfo();
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] a){
        College college = new College("DIU", "Dhaka");

        Course c1 = new Course("CSE221", "Object Oriented Programming");
        Course c2 = new Course("CSE222", "Object Oriented Programming Lab");
        Course c3= new Course("MAT101", "Mathmetics");

        college.addCourse(c1);
        college.addCourse(c2);
        college.addCourse(c3);

        college.listCourses();
    }

}
