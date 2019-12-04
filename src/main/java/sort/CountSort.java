package sort;

import java.util.Arrays;

/**
 * 计数排序, 非比较排序, 桶排序思想
 * 时间复杂度O(n+k)
 * 空间复杂度O(n+k)
 * k为整数的范围
 */
public class CountSort {
    private int[] sort(int[] arr, int maxVal) {
        int[] newArr = new int[maxVal + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i]] += 1;
        }
        int idx = 0;
        // 反向输出数组种的元素
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] != 0) {
                for (int j = 0; j < newArr[i]; j++) {
                    arr[idx++] = i;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] arr = {5, 4, 3, 2, 1};
        int[] b = countSort.sort(arr, arr.length);
        System.out.println(Arrays.toString(b));
    }
}
