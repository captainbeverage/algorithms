/**
 * @author Jordan Harris
 * @since 2/17/2015
 *
 * This class contains sorting algorithms for arrays of integers.
 */

public class SortingAlgorithms {

    // O(n^2) sorting algorithm
    public static void insertionSort(int[] array, int size) {

        int i;    // Holds the index
        int key;  // Holds the key value

        // Loops through the array
        for(int j = 1; j < size; j++) {
            // Assigns the key to the value of the current index
            key = array[j];
            // Assigns the comparison value to one less than the current index
            i = j - 1;
            // While previous values are greater than the key, the lower values are all moved up one index
            // and the index is decremented (to read all values lower in the array)
            while(i >= 0 && array[i] > key) {
                array[i+1] = array[i];
                i--;
            }
            // The key is now inserted at the appropriate place in the array
            array[i+1] = key;
        }
    }

    // O(nlogn) sorting algorithm
    public static void quickSort(int[] arr, int left, int right) {
        // Partitions the array and assigns it to the index
        int index = partition(arr, left, right);
        // If the left index is less than the index, quickSort is recursively run with the index as the right index
        if(left < index - 1)
            quickSort(arr, left, index - 1);
        // If the index is less than the right index, quickSort is recursively run with the index as the left index
        if(index < right)
            quickSort(arr, index, right);
    }

    // Private method for quickSort algorithm
    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right;              // Left and right indices
        int temp;                             // Temp variable for swaps
        int pivot = arr[(left + right) / 2];  // Holds the pivot

        // Loops through the array while the left index is less than the right index
        while(i <= j) {
            // Increments the left index while the value of the left index is less than the pivot
            while(arr[i] < pivot)
                i++;
            // Decrements the right index while the value of the righ tindex is greater than the pivot
            while(arr[j] > pivot)
                j--;
            // If the left index is less than the right index, the values are swapped
            // then the left index increments and the right index decrements
            if(i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // Returns the index
        return i;
    }

}
