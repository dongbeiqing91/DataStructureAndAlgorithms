package util;

/**
 * @author Bei
 * @date 2019/12/9
 */
public class CommonUtils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
