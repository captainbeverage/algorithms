/**
 * Created by JT on 2/4/15.
 */
public class CheckSumDriver {

    public static void main(String[] stuff) {
        int[] coolArray = {4, 7, 1, 4, 8, 4, 5, 3, 3, 3, 3, 3, 1, 0, 7, 7, 23, 0, 12, 43, 6, 6, 12};

        QuickSort.quickSort(coolArray, 0, coolArray.length - 1);

        boolean isFound = CheckSum.checkSum(coolArray, 20);

        System.out.println(isFound);
    }
}