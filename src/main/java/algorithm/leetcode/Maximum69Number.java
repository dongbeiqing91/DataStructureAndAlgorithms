package algorithm.leetcode;

/**
 * @author Bei
 * @date 2020-01-21
 * https://leetcode-cn.com/problems/maximum-69-number/
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