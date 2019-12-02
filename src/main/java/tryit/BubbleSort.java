package tryit;

import java.util.Arrays;

/**
 * @author Bei
 * @date 2019-12-02
 */
public class BubbleSort {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        int[] a = {3, 5, 1, 2, 4};
        int l = a.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (a[j] < a[i]) {
                    BubbleSort.swap(a, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
