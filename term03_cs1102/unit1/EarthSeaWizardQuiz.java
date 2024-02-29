/* 
 * Name: Earthsea Wizard Quiz
 * Description: A program to test your knowledge of the Earthsea universe!
 * Author: Justin Sovine
 * Date: February 8, 2024
 */

// The Scanner class in Java is a part of the java.util package and provides a simple way to read input from various sources
import java.util.Scanner;

// The primary class orchestrating the Earthsea Wizard Quiz program
public class EarthSeaWizardQuiz {
    public static void main(String[] args) {
        // Instantiate the scanner class as an object
        Scanner scanner = new Scanner(System.in); 

        // Declare variables for keeping track of questions
        int correctCount = 0;
        int totalQuestions = 5;
        char wizardAnswer1, wizardAnswer2, wizardAnswer3, wizardAnswer4, wizardAnswer5;

        // Display intro text
        System.out.println("\nThe following is a quiz based around the \"Earthsea\" universe written by Ursula K. LeGuin. Have fun!\n");

        /*
         * Question 1
         */
        System.out.println("Q1 - What is the true name of the Archmage?");
        System.out.println("A. Sparrowhawk");
        System.out.println("B. Ged");
        System.out.println("C. Tenar");
        System.out.println("D. Ogion");

        // Get user input, convert input to upper case, and reference only the first character
        // Using do-while the user is prompted to enter a valid option (A, B, C, or D) until a correct input is received.
        do {
            System.out.print(">> ");
            wizardAnswer1 = scanner.next().toUpperCase().charAt(0);
        } while (wizardAnswer1 < 'A' || wizardAnswer1 > 'D');        

        // Check user input against correct answer
        if (wizardAnswer1 == 'B') {
            System.out.println("Correct! You are a true wizard of Earthsea!\n");
            correctCount++;
        } else {
            System.out.println("Incorrect. The true name is B, Ged.\n");
        }

        /*
         * Question 2
         */
        System.out.println("Q2 - What is the School of Wizardry where Ged learns magic?");
        System.out.println("A. Roke");
        System.out.println("B. Gont");
        System.out.println("C. Osskil");
        System.out.println("D. Havnor");

        // Get user input, convert input to upper case, and reference only the first character
        // Using do-while the user is prompted to enter a valid option (A, B, C, or D) until a correct input is received.
        do {
            System.out.print(">> ");
            wizardAnswer2 = scanner.next().toUpperCase().charAt(0);
        } while (wizardAnswer2 < 'A' || wizardAnswer2 > 'D');        

        // Check user input against correct answer
        if (wizardAnswer2 == 'A') {
            System.out.println("Correct! You are a true wizard of Earthsea!\n");
            correctCount++;
        } else {
            System.out.println("Incorrect. The true name is A, Roke.\n");
        }

        /*
         * Question 3
         */
        System.out.println("Q3 - What is the name of the shadow pursuing Ged?");
        System.out.println("A. Therru");
        System.out.println("B. Kalessin");
        System.out.println("C. Cob");
        System.out.println("D. Solitude");

        // Get user input, convert input to upper case, and reference only the first character
        // Using do-while the user is prompted to enter a valid option (A, B, C, or D) until a correct input is received.
        do {
            System.out.print(">> ");
            wizardAnswer3 = scanner.next().toUpperCase().charAt(0);
        } while (wizardAnswer3 < 'A' || wizardAnswer3 > 'D');        

        // Check user input against correct answer
        if (wizardAnswer3 == 'C') {
            System.out.println("Correct! You are a true wizard of Earthsea!\n");
            correctCount++;
        } else {
            System.out.println("Incorrect. The true name is C, Cob.\n");
        }

        /*
         * Question 4
         */
        System.out.println("Q4 - What is the name of Ged's dragon companion?");
        System.out.println("A. Orm Embar");
        System.out.println("B. Yarrow");
        System.out.println("C. Tehanu");
        System.out.println("D. Kalessin");

        // Get user input, convert input to upper case, and reference only the first character
        // Using do-while the user is prompted to enter a valid option (A, B, C, or D) until a correct input is received.
        do {
            System.out.print(">> ");
            wizardAnswer4 = scanner.next().toUpperCase().charAt(0);
        } while (wizardAnswer4 < 'A' || wizardAnswer4 > 'D');        

        // Check user input against correct answer
        if (wizardAnswer4 == 'A') {
            System.out.println("Correct! You are a true wizard of Earthsea!\n");
            correctCount++;
        } else {
            System.out.println("Incorrect. The true name is A, Orm Embar.\n");
        }

        /*
         * Question 5
         */
        System.out.println("Q5 -  What is the balance that wizards must maintain in Earthsea?");
        System.out.println("A. Power");
        System.out.println("B. Silence");
        System.out.println("C. Life");
        System.out.println("D. Death");

        // Get user input, convert input to upper case, and reference only the first character
        // Using do-while the user is prompted to enter a valid option (A, B, C, or D) until a correct input is received.
        do {
            System.out.print(">> ");
            wizardAnswer5 = scanner.next().toUpperCase().charAt(0);
        } while (wizardAnswer5 < 'A' || wizardAnswer5 > 'D');        

        // Check user input against correct answer
        if (wizardAnswer5 == 'B') {
            System.out.println("Correct! You are a true wizard of Earthsea!\n");
            correctCount++;
        } else {
            System.out.println("Incorrect. The true name is B, Silence.\n");
        }

        /*
         * Finalize score and return results
         */
        double percentage = (double) correctCount / totalQuestions; // Type-cast correctCount as a double and divide it by totalQuestions
        double finalScore = percentage * 100; // Convert fraction of correct answers to percentage (0.75 -> 75%)

        // Display score
        System.out.println("You have completed the EarthSea quiz.. Your final magical score is: " + finalScore + "%");

        // Typecast finalScore and use a switch conditional to display different messages based on the score percentage
        switch ((int) finalScore) {
            case 100:
                System.out.println("Congratulations! You are a true Master Wizard of Earthsea!\n");
                break;
            case 80:
                System.out.println("Well done! You have shown great proficiency in Earthsea magic.\n");
                break;
            case 60:
                System.out.println("Not bad! You have some understanding of the ways of Earthsea.\n");
                break;
            case 40:
                System.out.println("Keep practicing! You're on the path to mastering Earthsea magic.\n");
                break;
            case 20:
                System.out.println("You might need more study. The secrets of Earthsea await!\n");
                break;
            case 0:
                System.out.println("Oh no! Your knowledge of Earthsea needs serious improvement.\n");
                break;
            default:
                System.out.println("You've strayed beyond the known paths of Earthsea! Seek the hidden names and try again.\n");
        }

        // Close input scanner
        scanner.close();
    }
}