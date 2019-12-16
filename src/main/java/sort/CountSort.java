package sort;

import java.util.Arrays;

/**
 * 计数排序, 非比较排序, 桶排序思想
 * 把原数组中的数存到newArr的下标里, newArr[index]=index这个数在原数组中的个数
 * 如果newArr[index] != 0, 输出newArr[index]次index, 排序完毕
 * 只能用于整数的排序, 要排序的数量大但范围小, 比如 你高考的分是多少名
 * 负数可以再用另一个数组排序
 * 时间复杂度O(n+k)
 * 空间复杂度O(n+k)
 * k为整数的范围
 * 稳定性: 稳定
 */
public class CountSort {

    // 稳定
    public static int[] sort(int[] arr, int maxVal) {
        int[] result = new int[arr.length]; // 用于返回
        int[] countArray = new int[maxVal + 1];
        for (int value : arr) {
            countArray[value]++; // countArray[原数] = 个数
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1]; // 意味着i这个数及它之前有countArray[i]个数, 也就是i在排序时放在countArray[i]-1这个位置
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            int value = arr[j];
            // for循环是倒着遍历的, 相同的数, index大的也是放在后面一个, 所以算法是稳定的
            result[--countArray[value]] = value; // -- 有个作用: 1)index是位置-1; 2)重复的数的个数-1
        }
        return result;
    }

    // 这么写是不稳定的, 但是少用了一个辅助数组
    public static void sort_unstable(int[] arr, int maxVal) {
        int[] countArray = new int[maxVal + 1];
        for (int value : arr) {
            countArray[value]++; // countArray[原数] = 个数
        }
        int idx = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == 0) { // 等于0说明没有i这个数
                continue;
            }
            // 这么写,i如果在原数组中存在一样的数, 那i在前在后就不知道, 所以不稳定
            for (int j = 0; j < countArray[i]; j++) {
                arr[idx++] = i;
            }
        }
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
        int[] arr = {5, 4, 3, 2, 1};
        int[] res1 = sort(arr, findMax(arr));
        System.out.println(Arrays.toString(res1));

        int[] arr2 = {5, 4, 3, 2, 1};
        sort_unstable(arr2, findMax(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
