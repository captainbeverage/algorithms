import java.util.Scanner;
import java.io.*;

/**
 * @author Jordan Harris
 * @since 2/24/2015
 *
 * This is a driver, which asks the user to input the name of .txt file that contains a search value on the first
 * line and a list of integers, which each integer listed on a new line. The program creates an array and reads these
 * values into the array. It then asks the user which algorithm to use for sorting, then uses either QuickSort or
 * Insertion Sort to sort the array. Once the array has been sorted, the program uses the Search Algorithms class
 * (currently has binary search with a linear adjustment) to find the number of integers in the array less than or
 * equal to the search value. This number, along with the sorted array are output to a .txt file as input by the user.
 *
 * Methods: main, getSizeFromFile, assignArrayFromFile, getSortingAlgorithm, outputToFile, getFileName
 */

public class FindIntegersDriver {
    public static void main(String[] stuff) throws IOException {
        int[] arrayOfInt;         // Array to hold the integers from file
        int size;                 // Holds the number of integers in the file
        int searchValue;          // Holds the search value integer from file
        int numberOfIntegers;     // Holds the number of integers less than or equal to the search value
        String inputFilename;     // Holds the name of the input file
        String outputFilename;    // Holds the name of the output file
        String sortingAlgorithm;  // Holds the name of the sorting algorithm to use

        // Gets the name of the input file
        Scanner input = new Scanner(System.in);
        inputFilename = getFilename(input);
        System.out.println("Reading file...");

        // Gets the number of values from the file and creates the array based on the size
        size = getSizeFromFile(inputFilename) - 1;
        arrayOfInt = new int[size];

        // Does 2 things: Assigns the values from the file to the array, then assigns the search value from the array
        searchValue = assignArrayFromFile(arrayOfInt, inputFilename);

        // Gets the sorting algorithm to use from the user
        sortingAlgorithm = getSortingAlgorithm(input);

        // Runs QuickSort if the user entered 'quick' and Insertion Sort if the user entered 'insertion'
        if(sortingAlgorithm.equals("quick")) {
            System.out.println("Sorting numbers with QuickSort...");
            SortingAlgorithms.quickSort(arrayOfInt, 0, size - 1);
        }
        else {
            System.out.println("Sorting numbers with Insertion Sort...");
            SortingAlgorithms.insertionSort(arrayOfInt, size);
        }

        // Searches through the array with modified binary search. The search returns the index for the number of
        // integers less than or equal to the search so it is incremented by one.
        numberOfIntegers = SearchAlgorithms.binarySearchLastIndex(arrayOfInt, size, searchValue) + 1;

        // Gets the output filename from the user
        System.out.println("Enter the output filename to write to: ");
        outputFilename = input.nextLine();

        System.out.println("Outputting to file...");

        // Outputs the values to file
        outputToFile(outputFilename, arrayOfInt, numberOfIntegers);

        System.out.println("Please see " + outputFilename + " for output.");
    }

    // Reads through the file and returns the number of values to sort and search through
    public static int getSizeFromFile(String filename) throws IOException {
        int size = 0; // Holds the number of values in the file

        // Opens the file to read input
        FileReader file = new FileReader(filename);
        Scanner inputFile = new Scanner(file);

        // Loops through the file, increasing the size for each value found
        while(inputFile.hasNext()) {
            size++;
            inputFile.nextInt();
        }

        inputFile.close();

        // Returns the number of values to sort and search through in the file
        return size;
    }

    // Reads through the file and assigns each number to the array
    public static int assignArrayFromFile(int[] array, String filename) throws IOException {
        // Opens the file to read input
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        // Gets the search value as the first integer from the file
        int searchValue = inputFile.nextInt();

        // Loops through the file, adding each integer to the array
        for(int i = 0; i < array.length; i++)
            array[i] = inputFile.nextInt();

        // Closes the input file again
        inputFile.close();

        // Returns the searchValue;
        return searchValue;
    }

    // Gets which sorting algorithm to use from the user
    public static String getSortingAlgorithm(Scanner input) {
        String sortingAlgorithm; // Holds the sorting algorithm to use

        // Gets the sorting algorithm to use from the user
        System.out.println("Enter 'quick' to sort the numbers using QuickSort.");
        System.out.println("Enter 'insertion' to sort the numbers using Insertion Sort.");
        sortingAlgorithm = input.nextLine();

        // Data validation for user input
        while(!sortingAlgorithm.equals("quick") && !sortingAlgorithm.equals("insertion")) {
            System.out.println("Error entering sorting method...");
            System.out.println("Enter 'quick' to sort the numbers using QuickSort.");
            System.out.println("Enter 'insertion' to sort the numbers using Insertion Sort.");
            sortingAlgorithm = input.nextLine();
        }

        // Returns the sortingAlgorithm to use
        return sortingAlgorithm;
    }

    // Outputs the solution and the sorted array to a file
    public static void outputToFile(String filename, int[] array, int numberOfIntegers) throws IOException {
        PrintWriter outputFile = new PrintWriter(filename);

        // Writes the search value to the output file
        outputFile.println(numberOfIntegers);

        // Writes the sorted array to the output file
        for(int i = 0; i < array.length; i++)
            outputFile.println(array[i]);

        outputFile.close();
    }

    // Gets the filename to read from the user
    public static String getFilename(Scanner input) throws IOException {
        // Gets the name of the input file
        System.out.println("Enter the name of the file to read: ");
        String inputFilename = input.nextLine();
        File file = new File(inputFilename);

        // User validation for file existence
        while(!file.exists()) {
            System.out.println("Error... File not found.");
            System.out.println("Enter the name of the file to read: ");
            inputFilename = input.nextLine();
            file = new File(inputFilename);
        }

        // Returns the name of the file
        return inputFilename;
    }
}
