/* 
 * Name: Shinra Recruit Management Interface
 * Description: Empowering Shinra administrators with efficient tools for commanding the future of our recruits.
 * Author: Justin Sovine
 * Date: February 22, 2024
 */

//
// The Arrays utility class is a part of the java.util package and provides various array manipulation methods
import java.util.Arrays;

//
// The ArrayList class from the java.util package for dynamic array manipulation
import java.util.ArrayList;

//
// The primary class orchestrating the Shinra Recruit Management Interface
class RogueTraderMetrics {
    // Private static variable representing an array of opening stock prices
    private double[] openingStockPrices;

    // Constructor to initialize the openingStockPrices array
    public RogueTraderMetrics() {
        initializeOpeningStockPrices();
    }

    // Initializes the openingStockPrices array
    private void initializeOpeningStockPrices() {
        // For simplicity, let's just manually set the opening stock prices
        openingStockPrices = { 100.5, 102.2, 98.8, 105.3, 99.7, 101.4, 103.8, 97.5, 104.1, 98.2 };
    }

    /** 
     * The main method is the entry point for Java applications
     */
    public static void main(String[] args) {

    }

    /** 
     * Calculates the average stock price. 
     * 
     * NOTE: This is what's known as a "Javadoc" comment. This is a tool that comes with Java, 
     * and it uses these special comments to generate documentation in HTML format from the source code. 
     * I'm experimenting with this on the side so may use this format in future work during this course 
     * if I feel that it adds to the submission.
     * 
     * @param arrayOfStockPrices An array of stock prices for a given period.
     * @return The average stock price calculated from the provided array.
     * @throws IllegalArgumentException if the array is empty.
     */
    private double calculateAveragePrice(double[] arrayOfStockPrices) {
        // Check if the array is empty

        // Calculate the sum of stock prices

        // Calculate and return the average
    }

    /** 
     * Returns the maximum stock price.
     * 
     * @param arrayOfStockPrices An array of stock prices for a given period.
     */
    private double findMaximumPrice(double[] arrayOfStockPrices) {
        // Check if the array is empty

        // Find the maximum price among all the stocks

        // Return the maximum price
    }

    /** 
     * 
     */
    private double calculateAveragePrice(double[] arrayOfStockPrices) {

    }

    /** 
     * 
     */
    private double calculateAveragePrice(Float[] arrayOfStockPrices) {

    }
}