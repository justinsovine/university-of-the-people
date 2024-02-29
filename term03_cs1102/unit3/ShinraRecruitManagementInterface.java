/* 
 * Name: Shinra Recruit Management Interface
 * Description: Empowering Shinra administrators with efficient tools for commanding the future of our recruits.
 * Author: Justin Sovine
 * Date: February 22, 2024
 */


//
// The Scanner class in Java is a part of the java.util package and provides a simple way to read input from various sources
import java.util.Scanner;

//
// Random class for generating random numbers used in selecting performance comments.
import java.util.Random;

//
// For handling invalid input exceptions
import java.util.InputMismatchException;

//
// The Arrays utility class is a part jof the java.util package and provides various array manipulation methods
//import java.util.Arrays;

//
// The primary class orchestrating the Shinra Recruit Management Interface
class ShinraRecruitManagementInterface {
    private static int totalRecruits; // Defaults to 0
    private static int[] recruitIds         = new int[100];
    private static int[] recruitAges        = new int[100];
    private static double[] recruitGrades   = new double[100];
    private static String[] recruitNames    = new String[100];

    private static Scanner scanner;  // Declare the Scanner as a static member
    static {
        scanner = new Scanner(System.in);  // Initialize the Scanner in a static initializer block
    }

    /*
     * Main Method
     * ------------
     * This method serves as the entry point for the Shinra Recruit Management Interface.
     * It presents a menu to the administrator, allowing them to perform various actions
     * such as enrolling a new recruit, updating recruit records, viewing recruit profiles,
     * listing all recruits, or exiting the system.
     */
    public static void main(String[] args) {
        //
        // Clears terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        //
        // Main event loop
        do {
            //
            // Main menu
            System.out.println("\nCitizens, unite! Come to the light — Mako energy.");
            System.out.println("Power is truth. Shinra is the future. Real happiness can be found in obedience to the company.");

            System.out.println("\nWelcome to Shinra Recruit Management Interface. Please make a selection:\n");

            System.out.println("[1] Enroll a New Recruit");
            System.out.println("[2] Update Recruit Records");
            System.out.println("[3] View Recruit Profiles");
            System.out.println("[4] List All Recruits");
            System.out.println("[5] Exit to ShinraOS");
            
            System.out.print("\n>> ");
            int choice = getInputAsInteger(); // Reads an integer input from the user with error handling for invalid inputs.
            scanner.nextLine();  // Consume newline left-over. I want to add this to the function but haven't yet

            switch (choice) {
                case 1:
                    addRecruit();
                    break;
                case 2:
                    updateRecruit();
                    break;
                case 3:
                    viewRecruitDetails();
                    break;
                case 4:
                    listAllRecruits();
                    break;
                case 5:
                    //
                    // Clears terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    //
                    // Exits program
                    System.out.println("\nDon't forget, Mako is the lifeblood of our planet, and Shinra is working to harness that power for a brighter tomorrow.\n");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid choice.");
            }
        } while(true);
    }

    /*
     * Add Recruit Method
     * -------------------
     * This method allows the administrator to enroll a new recruit by providing
     * information such as the recruit's name, age, and grade. The recruit ID is
     * automatically assigned and incremented for each new recruit.
     */
    private static void addRecruit() {
        System.out.print("\nEnter recruit name: ");
        String name = getInputAsString();

        int id = ++totalRecruits; // Increments totalRecruits and then sets that value to id, pretty slick

        System.out.print("Enter recruit age: ");
        int age = getInputAsInteger();
        scanner.nextLine();  // Consume newline left-over.

        System.out.print("Enter recruit grade (0.0-100.0): ");
        double grade = getInputAsDouble();

        // Assign the recruit's values to the end of the arrays
        recruitNames[totalRecruits - 1] = name;
        recruitIds[totalRecruits - 1] = id;
        recruitAges[totalRecruits - 1] = age;
        recruitGrades[totalRecruits - 1] = grade;

        System.out.println("Recruit added successfully!");
    }

    /*
     * Update Recruit Method
     * ----------------------
     * This method enables the administrator to update information for an existing recruit.
     * The administrator is prompted to enter the recruit ID and provide new age and grade.
     */
    private static void updateRecruit() {
        System.out.print("\nEnter recruit ID to update information: ");
        int updateId = getInputAsInteger();
        scanner.nextLine();  // Consume newline left-over.

        int index = findRecruitIndex(updateId);
        if (index != -1) {
            System.out.print("Enter new age: ");
            int newAge = getInputAsInteger();
            scanner.nextLine();  // Consume newline left-over.

            System.out.print("Enter new grade: ");
            double newGrade = getInputAsDouble();
            scanner.nextLine();  // Consume newline left-over.

            // Update recruit age and grade
            recruitAges[index] = newAge;
            recruitGrades[index] = newGrade;

            System.out.println("Recruit information updated successfully!");
        } else {
            System.out.println("Recruit with ID " + updateId + " not found.");
        }
    }

    /*
     * View Recruit Details Method
     * ---------------------------
     * This method allows the administrator to view detailed information about a specific recruit
     * by providing the recruit ID. The recruit's ID, name, age, grade, and a random performance comment
     * are displayed if the recruit is found.
     */
    private static void viewRecruitDetails() {
        System.out.print("\nEnter recruit ID to view details: ");
        int viewId = getInputAsInteger();
        int index = findRecruitIndex(viewId); // Get the index of a recruit based on their recruit ID
        scanner.nextLine();  // Consume newline left-over.

        // Checks to see if recruit exists
        if (index != -1) {
            System.out.println("\n----------------");
            System.out.println("Recruit Details:");
            System.out.println("----------------");
            System.out.println("ID: " + recruitIds[index]);
            System.out.println("Name: " + recruitNames[index]);
            System.out.println("Age: " + recruitAges[index]);
            System.out.println("Grade: " + recruitGrades[index]);
            printRandomPerformanceComment();
        } else {
            System.out.println("Recruit with ID " + viewId + " not found.");
        }
    }

    /*
     * List All Recruits Method
     * -------------------------
     * This method displays a list of all enrolled recruits. It shows the recruit IDs and names.
     * If no recruits are enrolled, a message indicating this is displayed.
     */
    private static void listAllRecruits() {
        // Checks to see if any recruits are enrolled
        if (totalRecruits > 0) {
            System.out.println("\n---------------");
            System.out.println("All Recruits:");
            System.out.println("---------------");

            // Iterates through the list of recruits based on the static totalRecruits integer
            for (int i = 0; i < totalRecruits; i++) {
                System.out.println("[" + recruitIds[i] + "]\t" + recruitNames[i]); // Uses the TAB key for fun
            }
        } else {
            System.out.println("\nNo recruits enrolled yet.");
        }
    }

    /*
     * Find Recruit Index Method
     * ------------------
     * This method locates the index of a recruit within the arrays based on their recruit ID.
     */
    private static int findRecruitIndex(int id) {
        for (int i = 0; i < totalRecruits; i++) {
            if (recruitIds[i] == id) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Get Input as Integer Method
     * ----------------------------
     * This method prompts the user to enter an integer and handles invalid inputs using a loop
     * and exception handling. It returns the valid integer entered by the user.
     */
    private static int getInputAsInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next()); // Takes a String as an argument and parses it into an int. Throws a NumberFormatException if the input String is not a valid integer.
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    /*
     * Get Input as Double Method
     * ---------------------------
     * This method prompts the user to enter a double and handles invalid inputs using a loop
     * and exception handling. It returns the valid double entered by the user.
     */
    private static double getInputAsDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.next()); // Takes a String as an argument and parses it into an int. Throws a NumberFormatException if the input String is not a valid double.
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                System.out.print("Enter again: ");
            }
        }
    }

    /*
     * Get Input as String Method
     * ---------------------------
     * This method prompts the user to enter a string and returns the entered string.
     */
    private static String getInputAsString() {
        return scanner.nextLine();
    }

    /*
     * Print Random Performance Comment Method
     * ---------------------------------------
     * This method generates and prints a random performance comment. It is used in the
     * viewRecruitDetails method to provide feedback on a recruit's performance.
     */
    private static void printRandomPerformanceComment() {
        Random random = new Random();
        int randomIndex = random.nextInt(3); // Randomly selects 0, 1, or 2
        String performanceComment;

        switch (randomIndex) {
            case 0 -> {
                performanceComment = "\nPerformance below Shinra's ambitious standards. Urgent improvement required.\n";
                break;
            }
            case 1 -> {
                performanceComment = "\nMeeting Shinra's expectations effectively. A reliable contributor to corporate progress.\n";
                break;
            }
            case 2 -> {
                performanceComment = "\nOutstanding service! Exceeds Shinra's lofty expectations, demonstrating unwavering dedication to corporate success.\n";
                break;
            }
            default -> {
                performanceComment = "\nInvalid performance level.\n";
                break;
            }
        }

        System.out.println(performanceComment);
    }
}