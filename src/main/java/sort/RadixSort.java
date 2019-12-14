package sort;

import java.util.Arrays;

/**
 * 基数排序, 桶排序的思想, 多关键字排序
 * 有低位优先和高位优先两种, 这里是低位优先 LSD (Least Significant Digit First)
 * 先排高位是分治思想, 递归 MSD (Most Significant Digit First)
 * 字符串也可以进行基数排序
 * 时间复杂度O(n+k)
 * 空间复杂度O(n+k)
 * 稳定性: 稳定
 */
public class RadixSort {

    public static int[] lsdRadixSort(int[] arr) {
        int[] result = new int[arr.length]; // 三次排序的结果
        int[] count = new int[10]; // 计数排序要用的数组 (桶)
        // 空间复杂度换时间复杂度

        for (int i = 0; i < 3; i++) { // 3为最高的位数, 遍历一遍数组拿到最高位数再传过来更好
            //求当前位数上的数字
            int division = (int) Math.pow(10, i); // 10的i次方
            for (int value : arr) {
                int num = value / division % 10; // 例如421这个数, 421/(10^0) % 10 = 1, 421/(10^1) % 10 = 2, 421/(10^2) % 10 = 4
                count[num]++;
            }

            // 计数排序
            for (int m = 1; m < count.length; m++) {
                count[m] += count[m - 1]; // 统计数字m及它前面有多少个数, 以供后面判断它对应的数应该放在数组的第几个
            }

            for (int n = 0; n < arr.length; n++) {
                int number = arr[n];
                int num = number / division % 10;
                result[count[num] - 1] = number; // count[num] - 1: 数字num及其前面有count[num]个数, 变成index要-1
                count[num]--; // 重复的个数-1
                // 比如说, 0,0,1,2,2: 两个2, count[2]=5, 代表最后这个2前面有4个数, 那就放在result[4]里
                // 倒数第二个2放在放在result[3]
            }

            System.arraycopy(result, 0, arr, 0, arr.length); // 把result复制回arr, 下一位数再排一遍
            Arrays.fill(count, 0); // 把count数组的每个元素重置为0

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {421, 240, 115, 532, 305, 430, 12};
        int[] result = RadixSort.lsdRadixSort(arr);
        System.out.println(Arrays.toString(result));
    }
}
