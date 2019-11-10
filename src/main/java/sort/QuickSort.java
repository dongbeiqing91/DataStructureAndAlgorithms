package sort;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i, j, pivot;
            i = l;
            j = r;
            pivot = a[i];
            while (i < j) {
                while (i < j && a[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[j] < pivot) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = pivot;
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
