/**
 * Created by JT on 2/13/15.
 */
public class InsertionSort {
    public static void insertionSort(int[] array) {

        int i;
        int key;

        for(int j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;
            while(i >= 0 && array[i] > key) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }
}
