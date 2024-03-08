/* 
 * NAME: Course Enrollment and Grade Management System
 * 
 * DESCRIPTION: 
 * The system contains functionality to enroll students in courses, assign grades to students, and calculate overall course grades for each student.
 * 
 * AUTHOR: Justin Sovine
 * DATE: March 7, 2024
 */

// For lists and ArrayLists
import java.util.List;
import java.util.ArrayList;

// For <Student, Double grade> maps
import java.util.Map;     // https://www.geeksforgeeks.org/map-interface-java-examples/
import java.util.HashMap; // https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/

// For input
import java.util.Scanner;

// CEGMSystem: Main class containing the entry point for the Course Enrollment and Grade Management System.
// Responsible for handling the administrator interface, user inputs, and interacting with the CourseManagement class.
class CEGMSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Display the administrator interface menu
            displayMenu();

            // Get user input for menu choice
            int choice = getChoice();

            // Perform the chosen operation
            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrades();
                    break;
                case 4:
                    calculateOverallGrades();
                    break;
                case 5:
                    listCourses();
                    break;
                case 6:
                    listStudents();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!\n");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    // Display the administrator interface menu
    private static void displayMenu() {
        System.out.println("\nAdministrator Interface:");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll students");
        System.out.println("3. Assign grades");
        System.out.println("4. Calculate overall course grades");
        System.out.println("5. List courses");
        System.out.println("6. List students");
        System.out.println("7. Exit");
        }

    // Get user's menu choice as an integer
    private static int getChoice() {
        System.out.print("Enter your choice (1-7): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice (1-7): ");
            scanner.next(); // Consume the invalid input
        }
        int result = getInputAsInteger();
        return result;
    }

    // Add a new course to the system
    private static void addNewCourse() {
        System.out.print("\nEnter course code: ");
        String courseCode = getInputAsString();
        
        System.out.print("Enter course name: ");
        String courseName = getInputAsString();

        System.out.print("Enter maximum capacity: ");
        int maxCapacity = getInputAsInteger();

        CourseManagement.addNewCourse(courseCode, courseName, maxCapacity);
        System.out.println("Course added successfully!");
    }

    // Enroll a student in a course
    private static void enrollStudent() {
        System.out.print("\nEnter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        // Find student and course objects based on user input
        Student student = findStudentById(studentId);

        // Check if the student ID is not found
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found. Creating a new student.");

            System.out.print("Enter student name: ");
            String studentName = getInputAsString();

            // Generate a new student ID
            studentId = CourseManagement.generateStudentId();

            // Create a new Student object with the generated ID
            student = new Student(studentName, studentId);
            CourseManagement.getStudents().add(student);
        }

        System.out.print("Enter course code: ");
        String courseCode = getInputAsString();

        Course course = findCourseByCode(courseCode);

        if (course != null) {
            CourseManagement.enrollStudent(student, course);
            System.out.println("Student enrolled successfully!");
        } else {
            System.out.println("Invalid course code. Enrollment failed.");
        }
    }

    // Assign grades to a student in a course
    private static void assignGrades() {
        // Assume you have students and courses already created
        System.out.print("\nEnter student ID: ");
        int studentId = getInputAsInteger();

        System.out.print("Enter course code: ");
        String courseCode = getInputAsString();

        System.out.print("Enter grade: ");
        double grade = getInputAsDouble();

        // Find student and course objects based on user input
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            CourseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully!");
        } else {
            System.out.println("Invalid student ID or course code. Grade assignment failed.");
        }
    }

    // Calculate the overall course grades for a student
    private static void calculateOverallGrades() {
        System.out.print("\nEnter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        // Find student object based on user input
        Student student = findStudentById(studentId);

        if (student != null) {
            double overallGrade = CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall course grade for the student: " + overallGrade);
        } else {
            System.out.println("Invalid student ID. Overall grade calculation failed.");
        }
    }

    // Find a student by their ID
    private static Student findStudentById(int studentId) {
        for (Student student : CourseManagement.getStudents()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
        return null;
    }

    // Find a course by its code
    private static Course findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            // The equals method in Java is a method that belongs to the Object class,
            // and it is used to compare the contents of two objects for equality
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        System.out.println("Course with code " + courseCode + " not found.");
        return null;
    }

    // Get user input as an integer, handling exceptions
    private static int getInputAsInteger() {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.next()); // Takes a String as an argument and parses it into an int. Throws a NumberFormatException if the input String is not a valid integer.
                scanner.nextLine(); // Consume the newline character
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    // Get user input as a double, handling exceptions
    private static double getInputAsDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(scanner.next()); // Takes a String as an argument and parses it into an int. Throws a NumberFormatException if the input String is not a valid double.
                scanner.nextLine(); // Consume the newline character
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                System.out.print("Enter again: ");
            }
        }
    }

    // Get user input as a string
    private static String getInputAsString() {
        String result = scanner.nextLine();
        return result.trim(); // Trim to remove leading/trailing whitespaces
    }

    // List all courses
    private static void listCourses() {
        List<Course> courses = CourseManagement.getCourses();
        if (!courses.isEmpty()) {
            System.out.println("\nList of Courses:");
            for (Course course : courses) {
                System.out.println(course.getCourseCode() + " - " + course.getCourseName());
            }
        } else {
            System.out.println("No courses available.");
        }
    }

    // List all students
    private static void listStudents() {
        List<Student> students = CourseManagement.getStudents();
        if (!students.isEmpty()) {
            System.out.println("\nList of Students:");
            for (Student student : students) {
                System.out.println(student.getStudentId() + " - " + student.getStudentName());
            }
        } else {
            System.out.println("No students available.");
        }
    }

}

// Student: Represents a student in the system with a unique ID, name, and a list of enrolled courses.
class Student {
    private int studentId;
    private String studentName;
    private List<Course> enrolledCourses;

    // Constructor to initialize a student with a name and ID
    public Student(String name, int id) {
        this.studentName = name;
        this.studentId = id;
        this.enrolledCourses = new ArrayList<>();
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Enroll the student in a course
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Assign a grade for a course
    public void assignGrade(Course course, double grade) {
        course.setGrade(this, grade);
    }
}

// Course: Represents a course with a unique code, name, maximum capacity, and a map to store student grades.
class Course {
    private String courseCode;
    private String courseName;
    private int courseMaxCapacity;
    private static int totalEnrolled; // Static variable to keep track of total enrolled students
    private Map<Student, Double> grades = new HashMap<>(); // Map to store student grades

    // Constructor to initialize a course with code, name, and maximum capacity
    public Course(String code, String name, int maxCapacity) {
        this.courseCode = code;
        this.courseName = name;
        this.courseMaxCapacity = maxCapacity;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseMaxCapacity() {
        return courseMaxCapacity;
    }

     // Static method to retrieve total enrolled students
    public static int getTotalEnrolled() {
        return totalEnrolled;
    }

    // Static method to increment total enrolled students
    public static void incrementTotalEnrolled() {
        totalEnrolled++;
    }

    // Static method to decrement total enrolled students
    public static void decrementTotalEnrolled() {
        totalEnrolled--;
    }

    // Set the grade for a student in the course
    public void setGrade(Student student, double grade) {
        grades.put(student, grade);
    }

    // Get the grade for a student in the course
    public double getGrade(Student student) {
        Double grade = grades.getOrDefault(student, -1.0); // Default value -1 if grade is not found
        return grade != null ? grade : -1.0;
    }

}

// CourseManagement: Manages the system's courses, students, and overall grades.
// Provides methods for adding courses, enrolling students, assigning grades, and calculating overall grades.
class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static Map<Student, Double> overallGrades = new HashMap<>();
    private static int studentIdCounter = 0;

    // Add a new course to the system
    public static void addNewCourse(String courseCode, String name, int maxCapacity) {
        Course newCourse = new Course(courseCode, name, maxCapacity);
        courses.add(newCourse);
    }

    // Enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        // Check to see if max capacity has been reached
        if (course.getCourseMaxCapacity() > Course.getTotalEnrolled()) {
            // Enroll student in course
            student.enrollCourse(course);
            // Increment total enrolled in course
            Course.incrementTotalEnrolled();
            // Success
            System.out.println("New student added successfully!");
        } else {
            // Failure. Course full
            System.out.println("Course is full. Cannot enroll student.");
        }
    }

    // Assign a grade to a student in a course
    public static void assignGrade(Student student, Course course, double grade) {
        course.setGrade(student, grade);
    }

    // Method to calculate overall course grade for a student
    public static double calculateOverallGrade(Student student) {
        double totalWeightedGrade = 0.0;
        int totalCredits = 0;

        for (Course enrolledCourse : student.getEnrolledCourses()) {
            int credits = 3; // Assuming each course has 3 credits, replace this with the actual credit value for each course
            double courseGrade = enrolledCourse.getGrade(student);

            double weightedGrade = credits * courseGrade;

            totalWeightedGrade += weightedGrade;
            totalCredits += credits;
        }

        if (totalCredits > 0) {
            return totalWeightedGrade / totalCredits;
        } else {
            System.out.println("No courses enrolled. Overall grade calculation not possible.");
            return 0.0;
        }
    }

    // Get the list of courses
    public static List<Course> getCourses() {
        return courses;
    }

    // Get the list of students
    public static List<Student> getStudents() {
        return students;
    }

    // Generate a new student ID
    public static int generateStudentId() {
        // Increment a static counter for demonstration purposes
        return ++studentIdCounter;
    }
}