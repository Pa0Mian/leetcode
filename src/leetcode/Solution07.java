package leetcode;

/**
 * Created by wzx on 2017/7/31.
 */
public class Solution07 {
    public static int reverse(int x) {
        int result = 0;
        if (x > Integer.MAX_VALUE) {
            return 0;
        } else if (x < Integer.MIN_VALUE) {
            return 0;
        }
        String s = String.valueOf(x);
        if (x > 0) {
            try {
                result = Integer.valueOf(reverseStr(s));
            } catch (NumberFormatException e) {
                result = 0;
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.charAt(0));
            String s1 = s.substring(1, s.length());
            stringBuilder.append(reverseStr(s1));
            try {
                result = Integer.valueOf(stringBuilder.toString());
            } catch (NumberFormatException e) {
                return 0;
            }

        }
        return result;
    }

    private static String reverseStr(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
