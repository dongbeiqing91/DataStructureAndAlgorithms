package sort;

import java.util.Arrays;

/**
 * 折半插入排序
 */
public class BinaryInsertSort {

    public static void binaryInsertSort(int[] arr) { // 由小到大排列
        // arr[i]待插入的对象, a[0] ~ a[i-1]为已排好序的数组, 要在0~i-1之间找到合适的位置j插入arr[i],原a[j]~a[i-1]依次后移一位
        for (int i = 1; i < arr.length; i++) { // i从1开始: 第一张牌无需判断位置, 第二张牌才需要判断插入在哪里
            // 既然前i个元素已经排好序了, 就可以用二分查找/折半查找来快速确定要插入的位置
            int j = findPosByBinarySearch(arr, 0, i - 1, arr[i]);
            int temp = arr[i];
            for (int k = i; k > j; k--) {
                arr[k] = arr[k - 1];
            }
            arr[j] = temp;
        }
    }

    private static int findPosByBinarySearch(int[] arr, int left, int right, int targetValue) {
        while (left <= right) {
            int mid = (right + left) / 2;
            if (targetValue < arr[mid]) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        return left; // return right + 1 也可以, 这个时候right已经跑到left左边去了
    }

    public static void main(String[] args) {
        int[] a = {53, 4, 22, 2, 7, 3};
        binaryInsertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
