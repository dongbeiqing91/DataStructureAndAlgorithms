package algorithm.leetcode;

/**
 * @author Bei
 * @date 2020-01-21
 * https://leetcode-cn.com/problems/maximum-69-number/
 * Given a positive integer num consisting only of digits 6 and 9.
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '6') {
                str = str.replaceFirst("6", "9");
                break;
            }
        }
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Maximum69Number m = new Maximum69Number();
        int i = m.maximum69Number(9696);
        System.out.println(i);
    }
}