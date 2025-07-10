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
    private ArrayList<Course> courses = new ArrayList<>();

    public College(String collegeName, String location) {
        this.collegeName = collegeName;
        this.location = location;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void listCourses() {
        System.out.println("Courses offered by " + collegeName + ":");
        for (Course c : courses) {
            c.displayCourseInfo();
            System.out.println("--------------------");
        }
    }

    public static void main(String[] a){
        College college = new College("Greenfield College", "Dhaka");

        Course course1 = new Course("CSE101", "Introduction to Programming");
        Course course2 = new Course("CSE102", "Data Structures");

        college.addCourse(course1);
        college.addCourse(course2);

        college.listCourses();
    }

}