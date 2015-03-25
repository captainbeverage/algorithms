/**
 * Created by JT on 2/4/15.
 */
public class QuickSort {

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int temp;
        int pivot = arr[(left + right) / 2];

        while(i <= j) {
            while(arr[i] < pivot)
                i++;
            while(arr[j] > pivot)
                j--;
            if(i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return i;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if(left < index - 1)
            quickSort(arr, left, index - 1);
        if(index < right)
            quickSort(arr, index, right);
    }
}