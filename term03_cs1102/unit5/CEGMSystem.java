//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

class CEGMSystem {
    public static void main (String[] args) {
        //
        // Administrator interface goes here


    }
}

class Student {
    private int studentId;
    private String studentName;
    private String[] enrolledCourses;

    // Getters
    public int getStudentId () {
        return this.studentId;
    }

    public String getStudentName () {
        return this.studentName;
    }

    public String[] getEnrolledCourses () {
        return this.enrolledCourses;
    }

    // Setters
    public void setStudentId (int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    // public void setEnrolledCourses (String[] enrolledCourses) {
    //     this.enrolledCourses = enrolledCourses;
    // }
}

class Course {
    private String courseCode;
    private String courseName;
    private int courseMaxCapacity;

}

class CourseManagement {
    private static String[] listOfCourses;
    private static Map<String, Double> overallGrades = new HashMap<>();

    public static void addNewCourse() {

    }

    public static void enrollStudent() {

    }

    public static void assignGrade () {

    }
}

