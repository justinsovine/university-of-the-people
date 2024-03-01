/* 
 * NAME: Rogue Trader Metrics 
 * 
 * DESCRIPTION: 
 * RogueTraderMetrics is a covert initiative dedicated to monitoring and analyzing anomalous stock market trends. 
 * The initiative was established to track and comprehend the financial implications of SCP anomalies, artifacts, 
 * and entities in the global markets. The mission of Rogue Trader Metrics is twofold: to predict potential 
 * financial crises caused by anomalous entities and to exploit market anomalies for funding the 
 * SCP Foundation's clandestine operations. 
 * 
 * AUTHOR: Justin Sovine
 * DATE: February 29, 2024 (Leap day!)
 */

//
// The Arrays utility class is a part of the java.util package and provides various array manipulation methods
import java.util.Arrays;

//
// The ArrayList class from the java.util package for dynamic array manipulation
import java.util.ArrayList;

//
// The primary class orchestrating Rogue Trader Metrics
class RogueTraderMetrics {

    /* 
     * The main method is the entry point for Java applications
     */
    public static void main(String[] args) {
        /* 
         * Array and ArrayList containing the same opening stock prices.
         */
        float[] openingStockPricesArray = new float[]{100.5f, 102.2f, 98.8f, 105.3f, 99.7f, 101.4f, 103.8f, 97.5f, 104.1f, 98.8f};
        ArrayList<Float> openingStockPricesArrayList = new ArrayList<>(Arrays.asList(100.5f, 102.2f, 98.8f, 105.3f, 99.7f, 101.4f, 103.8f, 97.5f, 104.1f, 98.8f));
        
        /* 
         * Array and ArrayList containing empty sets. Replace the above with the below and it will trigger the exception handling
         * and show which method the invalid call was made from using the getCallingMethodName() method.
         */
        //float[] openingStockPricesArray = new float[]{};
        //ArrayList<Float> openingStockPricesArrayList = new ArrayList<>();

        //
        // Welcome screen
        System.out.println("\nWelcome, Agent. You are now connected to Rogue Trader Metrics, the advanced tool for deciphering financial anomalies in service of the SCP Foundation's clandestine operations.\n");
        
        //
        // Print the starting values
        System.out.println("~".repeat(100));
        System.out.println("Opening Stock Prices (Array): " + String.join(", ", Arrays.toString(openingStockPricesArray)));
        System.out.println("Opening Stock Prices (ArrayList): " + openingStockPricesArrayList);


        //
        // Calling the array methods
        float averagePrice = calculateAveragePrice(openingStockPricesArray);
        float maximumPrice = findMaximumPrice(openingStockPricesArray);
        float stockCheck = 98.8f;
        int occurrences = countOccurrences(openingStockPricesArray, stockCheck);
        ArrayList<Float> cumulativeSum = computeCumulativeSum(openingStockPricesArray);

        //
        // Print the array results
        System.out.println("~".repeat(100));
        System.out.println("Array method results...");
        System.out.println("Average Price: " + averagePrice);
        System.out.println("Maximum Price: " + maximumPrice);
        System.out.println("Occurrences of " + stockCheck + ": " + occurrences);
        System.out.println("Cumulative Sum: " + cumulativeSum);

        //
        // Calling the ArrayList methods
        float averagePrice2 = calculateAveragePrice(openingStockPricesArrayList);
        float maximumPrice2 = findMaximumPrice(openingStockPricesArrayList);
        float stockCheck2 = 98.8f;
        int occurrences2 = countOccurrences(openingStockPricesArrayList, stockCheck);
        ArrayList<Float> cumulativeSum2 = computeCumulativeSum(openingStockPricesArrayList);

        //
        // Print the array results
        System.out.println("~".repeat(100));
        System.out.println("ArrayList method results...");
        System.out.println("Average Price: " + averagePrice2);
        System.out.println("Maximum Price: " + maximumPrice2);
        System.out.println("Occurrences of " + stockCheck2 + ": " + occurrences2);
        System.out.println("Cumulative Sum: " + cumulativeSum2);
        System.out.println("~".repeat(100));

        System.out.println("\nExiting Rogue Trader Metrics...\n");
    }

    /** 
     * Calculates and returns the average stock price.
     * 
     * NOTE: This is what's known as a "Javadoc" comment. This is a tool that comes with Java, 
     * and it uses these special comments to generate documentation in HTML format from the source code. 
     * I'm experimenting with this on the side so may use this format in future work during this course 
     * if I feel that it adds to the submission.
     * 
     * @param arrayOfStockPrices An array of stock prices for a given period.
     * @return The average stock price calculated from the provided array.
     * @throws IllegalArgumentException if the array is empty or if stock prices aren't floats
     */
    private static float calculateAveragePrice(float[] arrayOfStockPrices) {
        // Check if the array is empty and contains floats. Why assume when you can test? :)
        validateArray(arrayOfStockPrices);

        // Calculate the sum of all stock prices
        float sum = 0.0f;
        for (float price : arrayOfStockPrices) {
            sum += price;
        }

        // Calculate the average
        float average = sum / arrayOfStockPrices.length;

        // Return the average
        return average;
    }

    /** 
     * Calculates and returns the average stock price.
     * 
     * NOTE: This is an example of method overloading which allows a class to have multiple methods with the same name 
     * as long as they have a different number or type of parameters.
     * 
     * @param arrayListOfStockPrices An ArrayList of stock prices for a given period.
     * @return The average stock price calculated from the provided array.
     * @throws IllegalArgumentException if the array is empty or if stock prices aren't floats
     */
    private static float calculateAveragePrice(ArrayList<Float> arrayListOfStockPrices) {
        // Check if the ArrayList is empty.
        validateArrayList(arrayListOfStockPrices);

        // Calculate the sum of all stock prices
        float sum = 0.0f;
        for (float price : arrayListOfStockPrices) {
            sum += price;
        }

        // Calculate the average
        float average = sum / arrayListOfStockPrices.size();

        // Return the average
        return average;
    }

    /**
     * Returns the maximum stock price.
     *
     * @param arrayOfStockPrices An array of stock prices for a given period.
     * @return The maximum price among all the stocks.
     * @throws IllegalArgumentException if the array is empty.
     */
    private static float findMaximumPrice(float[] arrayOfStockPrices) {
        // Check if the array is empty and contains floats. Why assume when you can test? :)
        validateArray(arrayOfStockPrices);

        // Find the maximum price among all the stocks
        float maxPrice = Float.MIN_VALUE; // Set an initial value to compare
        for (float price : arrayOfStockPrices) {
            if (price > maxPrice) {
                maxPrice = price; // Update maxPrice if a higher value is found
            }
        }

        // Return the maximum price
        return maxPrice;
    }

    /**
     * Returns the maximum stock price.
     *
     * @param arrayListOfStockPrices An ArrayList of stock prices for a given period.
     * @return The maximum price among all the stocks.
     * @throws IllegalArgumentException if the ArrayList is empty.
     */
    private static float findMaximumPrice(ArrayList<Float> arrayListOfStockPrices) {
        // Check if the ArrayList is empty. Why assume when you can test? :)
        validateArrayList(arrayListOfStockPrices);

        // Find the maximum price among all the stocks
        float maxPrice = Float.MIN_VALUE; // Set an initial value to compare
        for (float price : arrayListOfStockPrices) {
            if (price > maxPrice) {
                maxPrice = price; // Update maxPrice if a higher value is found
            }
        }

        // Return the maximum price
        return maxPrice;
    }

    /**
     * Counts the occurrences of a target price in the given ArrayList of stock prices.
     *
     * @param arrayListOfStockPrices The ArrayList of stock prices.
     * @param targetPrice            The target price to count occurrences for.
     * @return The number of times the target price occurs in the ArrayList.
     * @throws IllegalArgumentException if the ArrayList is null.
     */
    private static int countOccurrences(float[] arrayOfStockPrices, float targetPrice) {
        // Check if ArrayList arrayListOfStockPrices is empty. Why assume when you can test? :)
        validateArray(arrayOfStockPrices);

        // Check if float targetPrice is empty
        if (targetPrice == 0.0) {
            System.out.println("targetPrice is empty");
            return -1;
        }

        // Calculate how many times target price occurs in the array
        int occurrenceCount = 0;
        for (float price : arrayOfStockPrices) {
            if (price == targetPrice) {
                occurrenceCount++;
            }
        }

        // Return the calculation as an integer
        return occurrenceCount;
    }

    /**
     * Counts the occurrences of a target price in the given ArrayList of stock prices.
     *
     * @param arrayListOfStockPrices The ArrayList of stock prices.
     * @param targetPrice The target price to count occurrences for.
     * @return The number of times the target price occurs in the ArrayList.
     * @throws IllegalArgumentException if the ArrayList is null or invalid.
     */
    private static int countOccurrences(ArrayList<Float> arrayListOfStockPrices, float targetPrice) {
        // Check if ArrayList listOfStockPrices is empty. Why assume when you can test? :)
        validateArrayList(arrayListOfStockPrices);

        // Check if float targetPrice is empty
        if (targetPrice == 0.0) {
            System.out.println("targetPrice is empty");
            return -1;
        }

        // Calculate how many times target price occurs in the ArrayList
        int occurrenceCount = 0;
        for (float price : arrayListOfStockPrices) {
            if (price == targetPrice) {
                occurrenceCount++;
            }
        }

        // Return the calculation as an integer
        return occurrenceCount;
    }

    /**
     * Calculates the cumulative sum of stock prices at each position in the input ArrayList.
     *
     * @param arrayOfStockPrices The ArrayList of stock prices.
     * @return A new ArrayList containing the cumulative sum of prices at each position.
     * @throws IllegalArgumentException if the ArrayList is null.
     */
    private static ArrayList<Float> computeCumulativeSum(ArrayList<Float> arrayListOfStockPrices) {
        // Check if ArrayList arrayListOfStockPrices is empty. Why assume when you can test? :)
        validateArrayList(arrayListOfStockPrices);

        // Calculate the cumulative sum of prices at each position
        ArrayList<Float> cumulativeSumList = new ArrayList<>();
        float sum = 0.0f;
        for (float price : arrayListOfStockPrices) {
            sum += price;
            cumulativeSumList.add(sum);
        }

        // Return the calculation as an ArrayList
        return cumulativeSumList;
    }

    /**
     * Calculates the cumulative sum of stock prices at each position in the input array.
     *
     * @param arrayOfStockPrices The array of stock prices.
     * @return A new ArrayList containing the cumulative sum of prices at each position.
     * @throws IllegalArgumentException if the array is empty.
     */
    private static ArrayList<Float> computeCumulativeSum(float[] arrayOfStockPrices) {
        // Check if the array is empty. Why assume when you can test? :)
        validateArray(arrayOfStockPrices);

        // Calculate the cumulative sum of prices at each position
        ArrayList<Float> cumulativeSumList = new ArrayList<>();
        float sum = 0.0f;
        for (float price : arrayOfStockPrices) {
            sum += price;
            cumulativeSumList.add(sum);
        }

        // Return the calculation as an ArrayList
        return cumulativeSumList;
    }

    /**
     * Validates whether the Array is not empty, or contains valid floats.
     *
     * @param arrayOfStockPrices The Array of stock prices.
     * @throws IllegalArgumentException if the Array is null, empty, or not a float.
     */
    private static void validateArray(float[] arrayOfStockPrices) {
        //
        // Check if the array is empty.
        if (arrayOfStockPrices.length == 0) {
            // Throw an error if the array is empty
            throw new IllegalArgumentException("The array is empty.");
        }

        //
        // Check if all values are floats.
        for (float price : arrayOfStockPrices) {
            if (!(price >= Float.MIN_VALUE && price <= Float.MAX_VALUE)) {
                throw new IllegalArgumentException("Invalid stock price: " + price);
            }
        }
    }

    /**
     * Validates whether the ArrayList is not empty, or contains valid floats.
     *
     * @param arrayListOfStockPrices The ArrayList of stock prices.
     * @throws IllegalArgumentException if the ArrayList is null, empty, or not a float.
     */
    private static void validateArrayList(ArrayList<Float> arrayListOfStockPrices) {
        //
        // Check if the ArrayList is empty.
        if (arrayListOfStockPrices.isEmpty()) {
            // Print the calling method and throw an error if the ArrayList is empty
            throw new IllegalArgumentException(getCallingMethodName() + " => The ArrayList is empty.");
        }

        //
        // Check if all values are floats.
        for (float price : arrayListOfStockPrices) {
            if (!(price >= Float.MIN_VALUE && price <= Float.MAX_VALUE)) {
                // Print the calling method and throw an error for invalid stock price
                throw new IllegalArgumentException(getCallingMethodName() + " => Invalid stock price: " + price);
            }
        }
    }

    /**
     * Helper method to get the name of the calling method.
     *
     * @return The name of the calling method.
     */
    private static String getCallingMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 4) {
            // The calling method is at index 3 in the stack trace
            return stackTrace[3].getMethodName();
        } else {
            return "Unknown method";
        }
    }
}