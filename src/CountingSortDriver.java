/**
 * Created by JT on 2/4/15.
 */
public class CountingSortDriver {

    public static void main(String[] stuff) {
        int[] coolArray = {4, 7, 1, 4, 8, 4, 5, 3, 3, 3, 3, 3, 1, 0, 7, 7, 23, 0, 12, 43, 6, 6, 12};

        int[] newArray = CountingSort.countingSort(coolArray);

        for(int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}