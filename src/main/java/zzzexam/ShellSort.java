package zzzexam;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int cur = i;
                if (arr[cur] < arr[cur - gap]) {
                    int temp = arr[cur];
                    while (cur - gap >= 0 && temp < arr[cur - gap]) {
                        arr[cur] = arr[cur - gap];
                        cur -= gap;
                    }
                    arr[cur] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
