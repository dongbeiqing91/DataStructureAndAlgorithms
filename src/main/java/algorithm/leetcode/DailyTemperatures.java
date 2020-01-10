package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author Bei
 * @date 2020-01-09
 * Given a list of daily temperatures T, return a list such that,
 * for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] arr = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; i--) {
            next[T[i]] = i;
            int index = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                if (next[j] < index) {
                    index = next[j];
                }
            }
            if (index != Integer.MAX_VALUE) {
                arr[i] = index - i;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        DailyTemperatures f = new DailyTemperatures();
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] arr = f.dailyTemperatures(T);
        System.out.println(Arrays.toString(arr));
    }
}
