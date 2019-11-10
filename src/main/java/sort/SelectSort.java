package sort;

import java.util.Arrays;

public class SelectSort {
    public int[] selectSort(int[] a) {
        int minIdx, temp;
        for (int i = 0; i < a.length; i++) {
            minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j; // 最小数的下标
                }
            }
            // 交换最小的数到前面
            temp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] b = selectSort.selectSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(b));
    }
}
