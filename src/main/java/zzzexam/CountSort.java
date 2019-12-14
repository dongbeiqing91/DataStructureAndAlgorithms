package zzzexam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {

    public static void CountSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] newArray = new int[max - min + 1];
        for (int item : arr) {
            newArray[item - min]++;
        }
        int index = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == 0) {
                continue;
            }
            for (int j = 0; j < newArray[i]; j++) {
                arr[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {94, 89, 97, 92, 90, 90, 90};
        CountSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
