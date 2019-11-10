package sort;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i, j, pivot;
            i = l;
            j = r;
            pivot = a[i]; // 取出枢轴的值
            while (i < j) { // 全程保证左下标在右下标的左边
                while (i < j && a[j] > pivot) {
                    j--;
                }
                // 右下标移动到比枢轴小的数
                if (i < j) {
                    a[i++] = a[j]; // 把这个右下标所在的比枢轴小的数赋值给左下标所在位置, 左下标右移一位
                }
                while (i < j && a[j] < pivot) {
                    i++;
                }
                // 左下标移动到比枢轴大的数
                if (i < j) {
                    a[j--] = a[i]; // 把这个左下标所在的比枢轴大的数 赋值给 右下标所在位置, 右下标左移一位
                }
            }
            a[i] = pivot; // 把枢轴的值还原到左下标的位置
            System.out.println(Arrays.toString(a));
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
            return a;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] a = {5, 4, 3, 2, 1};
        int[] b = q.quickSort(a, 0, a.length - 1);
        System.out.println("Final Result:");
        System.out.println(Arrays.toString(b));
    }
}
