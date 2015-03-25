import java.util.Scanner;
import java.io.*;

/**
 * @author Jordan Harris
 * @since 2/17/2015
 *
 * This is a driver, which asks the user to input the name of .txt file that contains a search value on the first
 * line and a list of integers, which each integer listed on a new line. The program creates an array and reads these
 * values into the array. It then sorts the array using Insertion Sort. Once the array has been sorted, the program
 * uses the Search Algorithms class (currently has binary search) to find the number of integers in the array less than
 * or equal to the search value. This number, along with the sorted array are output to a .txt file as input by the user.
 */

public class FindIntegersWithInsertionSort {
    public static void main(String[] stuff) throws IOException {
        int[] arrayOfInt = new int[100];  // Array to hold the integers from file
        int searchValue;                  // Holds the search value integer from file
        String inputFilename;             // Holds the name of the input file
        String outputFilename;            // Holds the name of the output file
        int index;                        // Holds the index where the search value would be inserted
        int numberOfIntegers;             // Holds the number of integers less than or equal to the search value

        // Gets the name of the input file
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the file to read: ");
        inputFilename = input.nextLine();

        // Opens the file
        File file = new File(inputFilename);
        Scanner inputFile = new Scanner(file);

        // Gets the search value as the first integer from the file
        searchValue = inputFile.nextInt();

        // Loops through the file, adding each integer to the array
        int size = 0;
        while(inputFile.hasNext()) {
            arrayOfInt[size] = inputFile.nextInt();
            size++;
        }

        // Closes the input file again
        inputFile.close();

        // Sorts the array with QuickSort
        SortingAlgorithms.insertionSort(arrayOfInt, size);

        // Searches through the array with modified binary search
        index = SearchAlgorithms.binarySearchLastIndex(arrayOfInt, size, searchValue);

        // Finds the number of integers less than or equal to the search value
        numberOfIntegers = index + 1;

        // Gets the output filename from the user
        System.out.println("Enter the output filename to write to: ");
        outputFilename = input.nextLine();

        PrintWriter outputFile = new PrintWriter(outputFilename);

        // Writes the search value to the output file
        outputFile.println(numberOfIntegers);

        // Writes the sorted array to the output file
        for(int i = 0; i < size; i++) {
            outputFile.println(arrayOfInt[i]);
        }

        // Closes the output file
        outputFile.close();

        System.out.println("Please see " + outputFilename + " for output.");
    }
}
