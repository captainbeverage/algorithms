/**
 * @author Jordan Harris
 * @since 2/17/2015
 *
 * This class contains search algorithms for arrays of integers.
 */

public class SearchAlgorithms {

    /*
     Uses binary search to find a location with T(n) = logn. If a location is found where the exact search value
     is found, the location is incremented as long as there are more of the same values. This allows this algorithm
     to return the correct index for the LAST index of the search value in a sorted array. At worst, this algorithm
     will run T(n) = n/2 = O(n) in the case that all numbers are the same in the array. On average, this search algorithm
     will run at O(logn).
    */
    public static int binarySearchLastIndex(int[] array, int size, int searchValue) {
        // Holds the low, mid, and high search variables
        int low = 0;
        int high = size - 1;
        int mid = (size + low)/2;

        // Searches through the array while the low index is less than the high
        while(low <= high) {
            // If the value found is lower than the searchValue, the low is assigned to the mid value + 1
            if(array[mid] < searchValue) {
                low = mid + 1;
            }
            // If the value found is higher than the searchValue, the high is assigned to the mid value - 1
            else if(array[mid] > searchValue) {
                high = mid - 1;
            } else {
                // Increments mid while there are more values which equal the searchValue
                while(array[mid] == array[mid+1]) {
                    mid++;
                }
                // Returns the index
                return mid;
            }
            // Mid is reassigned
            mid = (low + high) / 2;
        }
        // Returns the index
        return mid;
    }
}
