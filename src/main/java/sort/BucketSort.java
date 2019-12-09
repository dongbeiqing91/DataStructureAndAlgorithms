package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 * 时间复杂度O(n+k), 最坏O(n^2), 最好O(n)
 * 空间复杂度O(n+k)
 * 不常用, 主要使用计数排序和基数排序
 */
public class BucketSort {
    public static void sort(int[] arr) {

        int minVal = arr[0];
        int maxVal = arr[0];
        //求出数组中最大值和最小值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            } else if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        //桶数
        int bucketNum = (maxVal - minVal) / arr.length + 1; // 也不一定要分arr.length + 1 个桶
        //创建一个二维数组存放桶和桶中的元素
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }
        //将每个元素放入桶
        for (int value : arr) {
            int num = (value - minVal) / arr.length;
            bucketArr.get(num).add(value);
        }
        //对每个桶进行排序 (这就是为什么原版桶排序不常用的原因. 它的派生: 计数排序和基数排序用的更多, 尤其是计数排序)
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }
        //最后输出桶种元素
        System.out.println(bucketArr.toString());
    }

    public static void main(String[] args) {
        int[] a = {20, 16, 13, 8, 1};
        sort(a);
    }
}
