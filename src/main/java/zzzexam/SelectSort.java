package zzzexam;

import util.CommonUtils;

import java.util.Arrays;

public class SelectSort {

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minValuePosition = findMinValuePosition(arr, i, arr.length - 1);
            CommonUtils.swap(arr, i, minValuePosition);
        }
    }

    private static int findMinValuePosition(int[] arr, int begin, int end) {
        int min = begin;
        for (int i = begin; i <= end; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 4, 2, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
