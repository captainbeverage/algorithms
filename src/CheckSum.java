/**
 * Created by JT on 2/4/15.
 */
public class CheckSum {

    public static boolean checkSum(int[] array, int searchValue) {
        for(int i = 0; i < array.length - 1; i++) {

            int low = i + 1;
            int high = array.length - 1;
            int mid = (array.length + i)/2;

            while(low <= high) {
                if(array[mid] + array[i] < searchValue) {
                    low = mid + 1;
                } else if(array[mid] + array[i] > searchValue) {
                    high = mid - 1;
                } else {
                    return true;
                }

                mid = (low + high) / 2;
            }
        }

        return false;
    }
}