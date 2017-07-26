package leetcode;

import leetcode.util.Stack;

/**
 * Created by wzx on 2017/7/26.
 */
public class Solution05 {
    public static String longestPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while ( i + 1 < s.length()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == s.charAt(i)) {
                    System.out.print(stack.peek());
                    i++;
                    break;
                }
            }
            stack.push(s.charAt(i));
            i++;
        }
        while (i < s.length()) {

        }
        return "";
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}
