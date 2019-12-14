package sort;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1), 算法所需的辅助空间不随待排序规模的变化而变化, 是个常量
 * 稳定性: 稳定
 */
public class InsertSort {

    public static void insertSort(int[] arr) { // 从左向右找位置
        int j;
        // arr[i]待插入的对象, a[0] ~ a[i-1]为已排好序的数组, 要在0~i-1之间找到合适的位置j插入arr[i],原a[j]~a[i-1]依次后移一位
        for (int i = 1; i < arr.length; i++) { // 第一张牌已经摸好了, 开始摸第二张牌
            for (j = 0; j < i; j++) { // 和已经摸好的牌进行比较
                if (arr[i] < arr[j]) { // 找到要插入的位置j
                    break;
                }
            }
            int temp = arr[i];
            for (int k = i; k > j; k--) {
                arr[k] = arr[k - 1];
            }
            arr[j] = temp;
        }
    }

    public static void insertSort2(int[] arr) { // 从右向左找位置
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) { // 如果要插入的数比前一个数更小
                int cur = i; // 避免下面的循环修改i
                int temp = arr[i]; // 要插入的值
                // 数组从i-1开始向后移动一位, 并继续向前比较, 寻找应该要插入的位置
                while (cur - 1 >= 0 && temp < arr[cur - 1]) {
                    arr[cur] = arr[cur - 1];
                    cur--;
                }
                // 此时cur已经移动到了要插入的位置
                arr[cur] = temp;
            }
        }
    }

    // 这个写法有点像冒泡
    public static void insertSort3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    // 如果该位置比它前一个位置要小, 则将改位置的数插入到前一个数的前面, 即为调换位置
                    CommonUtils.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 53, 6, 2, 11, 3};
        int[] b = Arrays.copyOf(a, a.length);
        int[] c = Arrays.copyOf(a, a.length);
        insertSort(a);
        System.out.println(Arrays.toString(a));
        insertSort2(b);
        System.out.println(Arrays.toString(b));
        insertSort3(c);
        System.out.println(Arrays.toString(c));
    }

}
