/**
 * Created by JT on 2/4/15.
 */
public class CountingSort {

    public static int[] countingSort(int[] originalArray) {
        int maxValue = findMaxValue(originalArray);
        int[] valueArray = new int[maxValue + 1];
        int[] newArray = new int[originalArray.length];

        for(int i = 0; i < valueArray.length; i++)
            valueArray[i] = 0;

        for(int i = 0; i < originalArray.length; i++)
            valueArray[originalArray[i]] += 1;

        for(int i = 1; i < valueArray.length; i++)
            valueArray[i] += valueArray[i - 1];

        for(int i = originalArray.length - 1; i >= 0; i--) {
            newArray[valueArray[originalArray[i]] - 1] = originalArray[i];
            valueArray[originalArray[i]] -= 1;
        }

        return newArray;
    }

    private static int findMaxValue(int[] array) {
        int maxValue = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        return maxValue;
    }
}