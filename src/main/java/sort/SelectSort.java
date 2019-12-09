package sort;

import java.util.Arrays;

/**
 * 给每个位置选择待排序元素中当前最小的元素。比如给第一个位置选择最小的，在剩余元素里面给第二个位置选择次小的
 * 时间复杂度: 平均O(n^2), 最好O(n^2), 最坏O(n^2)
 * 空间复杂度: O(1)
 * 稳定性: 不稳定
 */
public class SelectSort {
    private static int[] selectSort(int[] a) {
        int minIdx, temp;
        for (int i = 0; i < a.length; i++) { // i < a.length - 1 也行, 因为最后一个数已经是最大的数
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
        int[] b = selectSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(b));
    }
}
