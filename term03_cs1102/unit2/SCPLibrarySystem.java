/* 
 * Name: SCP Foundation Database
 * Description: This library system facilitates the management, borrowing, and return of anomalies for experimentation.
 * Author: Justin Sovine
 * Date: February 15, 2024
 */

//
// The Scanner class in Java is a part of the java.util package and provides a simple way to read input from various sources
import java.util.Scanner;

//
// The Arrays utility class is a part jof the java.util package and provides various array manipulation methods
import java.util.Arrays;

//
// The primary class orchestrating the SCP Foundation Database program
public class SCPLibrarySystem {
    public static void main(String[] args) {

        //
        // Instantiate the scanner class as an object
        Scanner scanner = new Scanner(System.in); 

        //
        // Declare variables for keeping track of anomalies and researchers (i.e. books and authors)
        String[] researchers  = {"Ein Gregor", "Zara Thorne", "??????"};
        String[] anomalies    = {"173", "682", "939"};
        int[]    quantities   = {1, 1, 19};
        String[] borrowedAnomalies  = {};
        int[]    borrowedQuantities = {};

        //
        // Declare variables for cool dot-dot-dot effect
        int numberOfDots = 10;        // Number of dots
        int delayMilliseconds = 500;  // Delay between dots

        //
        // This code clears the terminal for a nice effect
        // \033 - This is the ANSI escape code prefix. It is equivalent to the ASCII Escape character (ESC), which has the decimal value 27.
        // [H   - Moves the cursor to the top-left corner of the screen. This is similar to the home position.
        // [2J  - Clears the entire screen.
        System.out.print("\033[H\033[2J");
        System.out.flush();

        //
        // Display MOTD - Irrelevant but fun
        System.out.println("> WARNING: BIOMETRIC SCAN REQUIRED");
        System.out.println("                            ");
        System.out.println("            .  .            ");
        System.out.println("          dOO  OOb          ");
        System.out.println("         dOP'..'YOb         ");
        System.out.println("         OOboOOodOO         ");
        System.out.println("       ..YOP.  .YOP..       ");
        System.out.println("     dOOOOOObOOdOOOOOOb     ");
        System.out.println("    dOP' dOYO()OPOb 'YOb    ");
        System.out.println("        O   OOOO   O        ");
        System.out.println("    YOb. YOdOOOObOP .dOP    ");
        System.out.println("     YOOOOOOP  YOOOOOOP     ");
        System.out.println("       ''''      ''''       ");
        System.out.println("                            ");
        System.out.println("> Scanning reader for memetic inoculation level 6 or higher...");
        System.out.println("> Status: Negative");

        //
        // Main program loop
        int choice = 0;
        while(true) {
            //
            // Count anomalies
            int anomalyCount = 0; // Initialize anomaly counter
            for (int quantity : quantities) {
                anomalyCount += quantity;
            }
            int anomalyBorrowedCount = 0; // Initialize anomaly counter
            for (int quantity : borrowedQuantities) {
                anomalyBorrowedCount += quantity;
            }

            //
            // Display menu
            System.out.println("\nWelcome to the SCP Foundation Database");
            System.out.println("There are currently " + anomalyCount + " anomalies contained.");
            System.out.println("There are currently " + anomalyBorrowedCount + " anomalies being borrowed for testing.\n");

            System.out.println("1. List all anomalies");
            System.out.println("2. Contain new anomaly");
            System.out.println("3. Borrow anomaly for testing");
            System.out.println("4. Return anomaly to containment");
            System.out.println("5. Exit database");

            System.out.print("\nSelect an option (1-5): ");

            //
            // Get user selection
            try {
                // Valid input
                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (java.util.InputMismatchException e) {
                // Clears terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Invalid input
                System.out.println("Invalid option. Please choose a valid option (1-4).\n");
                scanner.nextLine();  // Get valid input
                continue;
            }

            //
            // Perform relevant system function
            switch (choice) {
                //
                // List Anomalies (e.g. List Books)
                case 1 -> {
                    System.out.println("\nDisplaying all anomalies currently contained.");
                    System.out.println("\n------------------------");
                    for (int i = 0; i < anomalies.length; i++) {
                        System.out.println("Anomaly: SCP-" + anomalies[i]);
                        System.out.println("Researcher: Dr. " + researchers[i]);
                        System.out.println("Quantity: " + quantities[i]);
                        System.out.println("------------------------");
                    }

                    System.out.println("\nDisplaying all anomalies currently borrowed for testing.");
                    if (borrowedAnomalies.length != 0) {
                        System.out.println("\n------------------------");
                        for (int i = 0; i < borrowedAnomalies.length; i++) {
                            System.out.println("Anomaly: SCP-" + borrowedAnomalies[i]);
                            System.out.println("Researcher: (You)");
                            System.out.println("Quantity: " + borrowedQuantities[i]);
                            System.out.println("------------------------");
                        }
                    } else {
                        System.out.println("There are currently no anomolies being borrowed for testing. Returning to menu.");
                    }
                }

                //
                // Contain Anomaly (e.g. Add Book)
                case 2 -> {
                    //
                    // Get name of anomaly
                    System.out.println("\nYou have chosen to contain an anomaly. Please enter its details below.");
                    System.out.print("Designation Number: SCP-");
                    int newAnomalyInt = scanner.nextInt(); // We want the name to be an integer for thematic purposes
                    String newAnomalyStr = String.valueOf(newAnomalyInt); // Convert designation into string
                    scanner.nextLine();  // Consume newline left-over (https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo)
                    
                    //
                    // Get quantity of anomalies 
                    System.out.print("How many copies of the anomaly are you containing? ");
                    int newQuantity = scanner.nextInt();

                    //
                    // Check if anomaly is already being contained
                    // Iterate through the array to check if the string is present
                    boolean isAnomalyInDatabase = false;
                    for (String element : anomalies) {
                        if (element.equals(newAnomalyStr)) {
                            isAnomalyInDatabase = true;
                            break; // No need to continue once found
                        }
                    }

                    //
                    // Is anomaly contained already?
                    if (isAnomalyInDatabase) {
                        //
                        // Anomaly is currently in containment. 
                        System.out.println("\nSome SCP-" + newAnomalyStr + " already exist in containment.");
                        // Find the index of an anomaly in the array
                        int anomalyIndex = -1;
                        for (int i = 0; i < anomalies.length; i++) {
                            // equalsIgnoreCase method in Java that checks if two strings are equal, disregarding differences in case sensitivity.
                            // https://www.javatpoint.com/java-string-equalsignorecase
                            if (anomalies[i].equalsIgnoreCase(newAnomalyStr)) {
                                anomalyIndex = i;
                                break;
                            } else {
                                anomalyIndex = -1;
                            }
                        }

                        // Update quantities
                        System.out.println("\nContaining " + newQuantity + " SCP-" + newAnomalyStr + "...");
                        quantities[anomalyIndex] += newQuantity;

                        //
                        // Return to menu
                        System.out.println("Anomaly successfully contained!");
                        break;
                    }
                    
                    //
                    // Get researcher name
                    System.out.print("Researcher responsible for the new anomaly: Dr. ");
                    String newResearcher = scanner.nextLine();

                    //
                    // Assign to researcher
                    System.out.println("Assigning anomaly to Dr. " + newResearcher + "...");
                    researchers = Arrays.copyOf(researchers, researchers.length + 1); // Extend the array size by 1
                    researchers[researchers.length - 1] = newResearcher; // Add the new string to the end of the array

                    //
                    // Add anomaly and quantity to library
                    System.out.println("\nContaining " + newQuantity + " SCP-" + newAnomalyStr + "...");
                    anomalies = Arrays.copyOf(anomalies, anomalies.length + 1);    // Extend the array size by 1
                    quantities = Arrays.copyOf(quantities, quantities.length + 1); // " "
                    anomalies[anomalies.length - 1] = newAnomalyStr; // Add the new item to the end of the array
                    quantities[quantities.length - 1] = newQuantity; // " "
                    
                    //
                    // Return to menu
                    System.out.println("Anomaly successfully contained!");
                }

                //
                // Borrow SCP (e.g. Borrow Books)
                case 3 -> {
                    System.out.println("\nYou have chosen to borrow an anomaly for testing.\n");

                    //
                    // What anomaly to borrow for research?
                    System.out.print("What anomaly do you want to borrow? SCP-");
                    int borrowAnomalyInt = scanner.nextInt(); // We want the name to be an integer for thematic purposes
                    String borrowAnomalyStr = String.valueOf(borrowAnomalyInt); // Convert designation into string
                    scanner.nextLine();  // Consume newline left-over

                    //
                    // How many to borrow for research?
                    System.out.print("How many SCP-" + borrowAnomalyStr + " do you want to borrow? ");
                    int borrowAnomalyQuantityInt = scanner.nextInt(); // We want the name to be an integer for thematic purposes
                    scanner.nextLine();  // Consume newline left-over

                    //
                    // Check if anomaly is already being tested on
                    // Iterate through the array to check if the string is present
                    boolean isAnomalyInTesting = false;
                    for (String element : borrowedAnomalies) {
                        if (element.equals(borrowAnomalyStr)) {
                            isAnomalyInTesting = true;
                            break; // No need to continue once found
                        }
                    }

                    //
                    // Find the index of an anomaly in the array
                    int anomalyIndex = -1;
                    for (int i = 0; i < anomalies.length; i++) {
                        // equalsIgnoreCase method in Java that checks if two strings are equal, disregarding differences in case sensitivity.
                        // https://www.javatpoint.com/java-string-equalsignorecase
                        if (anomalies[i].equalsIgnoreCase(borrowAnomalyStr)) {
                            anomalyIndex = i;
                            break;
                        } else {
                            anomalyIndex = -1;
                        }
                    }

                    //
                    // Is anomaly borrowed already?
                    if (isAnomalyInTesting) {
                        //
                        // Anomaly is currently in testing. 
                        System.out.println("\nSome SCP-" + borrowAnomalyStr + " already exist in testing.");
                        
                        //
                        // Find the index of a borrowed anomaly in the array
                        int borrowedAnomalyIndex = -1;
                        for (int i = 0; i < borrowedAnomalies.length; i++) {
                            // equalsIgnoreCase method in Java that checks if two strings are equal, disregarding differences in case sensitivity.
                            // https://www.javatpoint.com/java-string-equalsignorecase
                            if (borrowedAnomalies[i].equalsIgnoreCase(borrowAnomalyStr)) {
                                borrowedAnomalyIndex = i;
                                break;
                            } else {
                                borrowedAnomalyIndex = -1;
                            }
                        }

                        // Update quantities
                        System.out.println("\nRemoving " + borrowAnomalyQuantityInt + " more SCP-" + borrowAnomalyStr + " for testing...");
                        borrowedQuantities[borrowedAnomalyIndex] += borrowAnomalyQuantityInt; // Update borrowed quantity with borrowed index
                        quantities[anomalyIndex] -= borrowAnomalyQuantityInt; // Update contained quantity with original index

                        //
                        // Return to menu
                        System.out.println("More SCP-" + borrowAnomalyStr + " were successfully borrowed for testing!");
                        break;
                    }

                    //
                    // Check if anomaly is contained
                    System.out.println("\nChecking to see if anomaly is currently contained...");
                    if (anomalyIndex != -1) {
                        System.out.println("SCP-" + anomalies[anomalyIndex] + " is currently contained!");
                    } else {
                        System.out.println("SCP-" + borrowAnomalyStr + " is not currently contained.");
                        System.out.println("Please contain it or select another anomaly for research.");
                        break;
                    }

                    //
                    // Check if the requested quantity is available to borrow for testing
                    if (quantities[anomalyIndex] >= borrowAnomalyQuantityInt) {
                        // Update the quantity and display success message
                        quantities[anomalyIndex] -= borrowAnomalyQuantityInt;
                        System.out.println("Your superiors have approved your request!");
                        System.out.println("Removing " + borrowAnomalyQuantityInt + " SCP-" + anomalies[anomalyIndex] + " from containment...");
                    } else {
                        // Display error message if the requested quantity is not available
                        System.out.println("Your superiors have denied your request. Insufficient quantity available for research.");
                        break;
                    }

                    //
                    // Add anomalies to borrowed list
                    System.out.println("Placing " + borrowAnomalyQuantityInt + " SCP-" + anomalies[anomalyIndex] + " into testing chamber...");
                    borrowedAnomalies = Arrays.copyOf(borrowedAnomalies, borrowedAnomalies.length + 1);    // Extend the array size by 1
                    borrowedQuantities = Arrays.copyOf(borrowedQuantities, borrowedQuantities.length + 1); // " "
                    borrowedAnomalies[borrowedAnomalies.length - 1] = borrowAnomalyStr; // Add the new item to the end of the array
                    borrowedQuantities[borrowedQuantities.length - 1] = borrowAnomalyQuantityInt; // " "

                    // Success
                    System.out.println("Testing is underway. Returning to menu.");
                }

                // Return SCP (e.g. Return Book)
                case 4 -> {
                    System.out.println("\nYou have chosen to return an anomaly.\n");

                    //
                    // What anomaly to return to containment?
                    System.out.print("What anomaly do you want to return to containment? SCP-");
                    int returnAnomalyInt = scanner.nextInt(); // We want the name to be an integer for thematic purposes
                    String returnAnomalyStr = String.valueOf(returnAnomalyInt); // Convert designation into string
                    scanner.nextLine();  // Consume newline left-over

                    //
                    // How many to return to containment?
                    System.out.print("How many SCP-" + returnAnomalyStr + " do you want to return to containment? ");
                    int returnAnomalyQuantityInt = scanner.nextInt(); // We want the name to be an integer for thematic purposes
                    scanner.nextLine();  // Consume newline left-over
                    
                    //
                    // Find the index of an anomaly in the array
                    int anomalyIndex = -1;
                    for (int i = 0; i < borrowedAnomalies.length; i++) {
                        // equalsIgnoreCase method in Java that checks if two strings are equal, disregarding differences in case sensitivity.
                        // https://www.javatpoint.com/java-string-equalsignorecase
                        if (borrowedAnomalies[i].equalsIgnoreCase(returnAnomalyStr)) {
                            anomalyIndex = i;
                            break;
                        } else {
                            anomalyIndex = -1;
                        }
                    }

                    //
                    // Find the index of an anomaly in the ORIGINAL array
                    int originalAnomalyIndex = -1;
                    for (int i = 0; i < anomalies.length; i++) {
                        // equalsIgnoreCase method in Java that checks if two strings are equal, disregarding differences in case sensitivity.
                        // https://www.javatpoint.com/java-string-equalsignorecase
                        if (anomalies[i].equalsIgnoreCase(returnAnomalyStr)) {
                            originalAnomalyIndex = i;
                            break;
                        } else {
                            originalAnomalyIndex = -1;
                        }
                    }

                    //
                    // Check if anomaly is being borrowed currently
                    System.out.println("\nChecking to see if anomaly is currently undergoing testing...");
                    if (anomalyIndex != -1) {
                        System.out.println("You have finished your research with SCP-" + borrowedAnomalies[anomalyIndex]);
                    } else {
                        System.out.println("SCP-" + returnAnomalyStr + " is not currently undergoing testing.");
                        System.out.println("Please borrow it for testing or select another anomaly to return.");
                        break;
                    }

                    //
                    // Check if the requested quantity is available to return to containment
                    if (borrowedQuantities[anomalyIndex] >= returnAnomalyQuantityInt) {
                        // Update the quantity and display success message
                        System.out.println("Your superiors are pleased with your work!");
                        System.out.println("Returning " + returnAnomalyQuantityInt + " SCP-" + borrowedAnomalies[anomalyIndex] + " to containment...");
                        borrowedQuantities[anomalyIndex] -= returnAnomalyQuantityInt;
                        quantities[originalAnomalyIndex] += returnAnomalyQuantityInt;
                    } else {
                        // Display error message if the requested quantity is not available
                        System.out.println("Your superiors are displeased with this oversight. Insufficient quantity available to return to containment.");
                        break;
                    }

                    //
                    // Remove borrowed status if quantity is zero
                    System.out.println("Doing paperwork for " + returnAnomalyQuantityInt + " SCP-" + borrowedAnomalies[anomalyIndex] + " test results...");
                    if (borrowedQuantities[anomalyIndex] == 0) {
                        // Reuse the same name for the new array
                        borrowedAnomalies = new String[borrowedAnomalies.length - 1];
                        borrowedQuantities = new int[borrowedQuantities.length - 1];

                        // Copy elements before the index
                        System.arraycopy(borrowedAnomalies, 0, borrowedAnomalies, 0, anomalyIndex);
                        System.arraycopy(borrowedQuantities, 0, borrowedQuantities, 0, anomalyIndex);

                        // Check to make sure that there is anything after the index to copy
                        if (anomalyIndex < borrowedAnomalies.length) {
                            // Copy elements after the index
                            System.arraycopy(borrowedAnomalies, anomalyIndex + 1, borrowedAnomalies, anomalyIndex, borrowedAnomalies.length - anomalyIndex - 1);
                            System.arraycopy(borrowedQuantities, anomalyIndex + 1, borrowedQuantities, anomalyIndex, borrowedQuantities.length - anomalyIndex - 1);
                        }
                    }

                    // Success
                    System.out.println("Paperwork complete! Returning to menu.");
                }

                // Exit Database
                case 5 -> {
                    System.out.print("\nApplying amnestics and exiting the database");

                    // Loop using Thread.sleep() to create a "dot-dot-dot" effect
                    for (int i = 0; i < numberOfDots; i++) {
                        try {
                            Thread.sleep(delayMilliseconds); // Sleeps for delayMilliseconds
                            System.out.print(".");
                        } catch (InterruptedException e) {
                            e.printStackTrace(); // Is this necessary?
                        }
                    }
                    System.out.println(); // Is this necessary?

                    // Clears terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    // Final exit message
                    System.out.println("You've forgotten everything you saw here...\n");
                    System.exit(0);
                }
                
                // Invalid Option
                default -> {
                    System.out.println("Invalid option. Please choose a valid option (1-4).\n"); // Technically this never displays
                }
            }
        }

    }
}