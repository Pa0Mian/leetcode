package leetcode;


import java.util.*;

/**
 * Created by wzx on 2017/7/26.
 */

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
  第三题
 大意是要找出最长的不重复的字符串的长度（这个字符串中没有重复的字符）
 一开始使用遍历，发现逻辑复杂
 第二次想用栈，进出时判断栈中是否有，最大长度即栈的高度，后来发现只要用Set就可以了，还可以使用contains函数判断有没有这个元素
 */
public class Solution03 {
    // O^3
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < s.length(); i ++) {
            HashSet<Character> currentSet = new HashSet<>();
            currentSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j ++) {
                if (currentSet.contains(s.charAt(j))) {
                    if (currentSet.size() > max) {
                        max = currentSet.size();
                    }
                    break;
                } else {
                    currentSet.add(s.charAt(j));
                    if (currentSet.size() > max) {
                        max = currentSet.size();
                    }
                }
            }
        }
        return max;
    }
    // 优化 O^2
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> currentSet = new HashSet<>();
        int max = 1;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (currentSet.contains(s.charAt(right))) {
                currentSet.remove(s.charAt(left));
                left++;
            } else {
                currentSet.add(s.charAt(right));
                max = Math.max(right-left+1, max);
                right++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int max =  lengthOfLongestSubstring2("aab");
        System.out.println(max);
    }
}