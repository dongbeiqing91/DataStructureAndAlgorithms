package algorithm.leetcode;

/**
 * @author Bei
 * @date 2020-01-21
 * https://leetcode-cn.com/problems/guess-numbers/
 */
public class GuessNumber {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
