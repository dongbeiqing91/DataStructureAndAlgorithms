package zzzexam;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arr) {
        int j;
        // arr[i]待插入的对象, a[0] ~ a[i-1]为已排好序的数组, 要在0~i-1之间找到合适的位置j插入arr[i],原a[j]~a[i-1]依次后移一位
        for (int i = 1; i < arr.length; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    break; // 找到了位置j
                }
            }
            int temp = arr[i];
            for (int k = i; k > j; k--) {
                arr[k] = arr[k - 1];
            }
            arr[j] = temp;
        }

    }





    public static void main(String[] args) {
        int[] a = {55, 444, 3, 22, 1};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
