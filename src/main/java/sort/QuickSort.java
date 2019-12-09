package sort;

import java.util.Arrays;

/**
 * 快速排序是对冒泡的改进
 * 分隔成两部分, 左边比轴值小,右边比轴值大, 再递归两部分
 * 思想: 分治思想和递归思想
 * 时间复杂度: 平均O(nlogn), 最好O(nlogn), 最坏O(n^2)
 * 空间复杂度: O(nlogn)
 * 稳定性: 不稳定
 */
public class QuickSort {
    public static int[] quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i, j, pivot;
            i = l;
            j = r;
            pivot = a[i]; // 取出枢轴的值
            System.out.printf("pivot = %d\n", pivot);
            System.out.printf("before move: %s\n", Arrays.toString(a));
            while (i < j) { // 左右下标不重合
                while (i < j && a[j] > pivot) { // 右下标移动到比枢轴小的数
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j]; // 在右半部分找到了比枢轴小的数, 移到左边部分, 左下标右移
                }
                while (i < j && a[i] < pivot) { // 左下标移动到比枢轴大的数
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i]; // 将比枢轴大的数移到枢轴的右边
                }
            }
            a[i] = pivot; // 枢轴移到中间, 即为左右下标重合的位置(所以这里写a[j] = pivot 也可以 因为 i == j ), 这样左边比枢轴都小, 右边比枢轴都大
            System.out.printf("after move: %s\n\n", Arrays.toString(a));
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {15, 5, 9, 18, 2, 21, 1, 4};
        int[] b = quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(b));
    }
}
