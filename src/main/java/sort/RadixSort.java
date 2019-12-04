package sort;

import java.util.Arrays;

/**
 * 基数排序, 桶排序的思想, 多关键字排序
 * 有低位优先和高位优先两种, 这里是低位优先 LSD (Least Significant Digit First)
 * 先排高位是分治思想, 递归 MSD (Most Significant Digit First)
 * 字符串也可以进行基数排序
 */
public class RadixSort {

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10]; // 桶

        for (int i = 0; i < 3; i++) { // 3为最高的位数, 遍历一遍数组拿到最高位数再传过来更好

            //求当前位数上的数字
            int division = (int)Math.pow(10, i); // 421这个数, 421/(10^0) % 10 = 1, 421/(10^1) % 10 = 2, 421/(10^2) % 10 = 4
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / division % 10;
                count[num]++;
            }

            // 计数排序
            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }

            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }

            System.arraycopy(result, 0, arr, 0, arr.length); // 把result复制回arr, 下一位数再排一遍
            Arrays.fill(count, 0);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {421, 240, 115, 532, 305, 430, 12};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }
}
