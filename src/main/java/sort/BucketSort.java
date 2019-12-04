package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 */
public class BucketSort {
    public void sort(int[] arr) {

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
        int bucketNum = (maxVal - minVal) / arr.length + 1;
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
        //对每个桶进行排序
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }
        //最后输出桶种元素
        System.out.println(bucketArr.toString());
    }

    public static void main(String[] args) {
        int[] a = {20, 16, 13, 8, 1};
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(a);

    }
}
