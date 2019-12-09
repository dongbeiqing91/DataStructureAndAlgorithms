package sort;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 把小的元素往前调（或者把大的元素往后调）
 * 时间复杂度: 平均O(n^2), 最坏O(n^2), 最好O(n)
 * 空间复杂度: O(1)
 * 稳定性: 稳定
 */
public class BubbleSort {

    public static int[] bubbleSortAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                CommonUtils.swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int[] ints = bubbleSortAsc(arr);
        System.out.println(Arrays.toString(ints));
    }
}
