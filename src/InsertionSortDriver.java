/**
 * Created by JT on 2/13/15.
 */
public class InsertionSortDriver {
    public static void main(String[] stuff) {
        int[] coolArray = {4, 7, 1, 4, 8, 4, 5, 3, 3, 3, 3, 3, 1, 0, 7, 7, 23, 0, 12, 43, 6, 6, 12};

        InsertionSort.insertionSort(coolArray);

        for(int i = 0; i < coolArray.length; i++)
            System.out.print(coolArray[i] + " ");
    }
}
