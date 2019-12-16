package sort;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 思路: 找一个间隔数, 比如说5, 对第0, 5, 10个数进行插入排序, 其他数字保持不变,
 * 再找一个更小的间隔数, 比如3, 对第0, 3, 6, 9...个数进行插入排序,
 * 依此类推, 间隔越来越小直至1. 下一个间隔排序后依然满足上一个间隔有序
 * 间隔大,移动次数少;间隔小,移动距离短
 * 时间复杂度O(n^1.3)
 * 空间复杂度O(1)
 * 稳定性: 不稳定
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int cur = i;
                // 从gap开始向前, 插入排序
                // 如果要插入的值更小
                if (arr[cur] < arr[cur - gap]) {
                    int temp = arr[cur];
                    // 移动数组元素,并继续向前寻找,直到要插入的值更大时,即为要找的位置
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
        int[] data = new int[]{5, 2, 8, 9, 1, 3, 4};
        shellSort(data);
        System.out.println(Arrays.toString(data));
    }

}
