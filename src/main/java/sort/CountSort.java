package sort;

import java.util.Arrays;

/**
 * 计数排序, 非比较排序, 桶排序思想
 * 把原数组中的数存到newArr的下标里, newArr[index]=index这个数在原数组中的个数
 * 如果newArr[index] != 0, 输出newArr[index]次index, 排序完毕
 * 只能用于整数的排序
 * 时间复杂度O(n+k)
 * 空间复杂度O(n+k)
 * k为整数的范围
 */
public class CountSort {
    public static int[] sort(int[] arr, int maxVal) {
        int[] newArr = new int[maxVal + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i]] += 1; // newArr[原数] = 个数
        }
        int idx = 0;
        // 反向输出数组种的元素
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == 0) { // 等于0说明没有i这个数
                continue;
            }
            for (int j = 0; j < newArr[i]; j++) {
                arr[idx++] = i;
            }
        }
        return arr;
    }

    private static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return arr[max];
    }

    public static void main(String[] args) {
        int[] arr = {500, 4, 3, 2, 1};
        int[] b = sort(arr, findMax(arr));
        System.out.println(Arrays.toString(b));
    }
}
