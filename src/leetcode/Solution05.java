package leetcode;


import java.util.LinkedList;

/**
 * Created by wzx on 2017/7/26.
 */
public class Solution05 {
    // 中心扩展法：0(n^3)
    public static String longestPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int i = 0;
        LinkedList<Character> palindromeMax = new LinkedList<>();
        while (i < s.length()) {
            LinkedList<Character> palindrome = new LinkedList<>();
            if (i + 1 < s.length()) {
                if (s.charAt(i+1) == s.charAt(i)) {
                    int m = i;
                    int n = i + 1;
                    while (m >= 0 && n < s.length()) {
                        if (s.charAt(m) == s.charAt(n)) {
                            palindrome.addFirst(s.charAt(m));
                        } else {
                            break;
                        }
                        m--;
                        n++;
                    }
                    int k = palindrome.size() - 1;
                    while (k >= 0) {
                        palindrome.add(palindrome.get(k));
                        k--;
                    }
                } else {
                    int m = i - 1;
                    int n = i + 1;
                    if (m >= 0 && n < s.length() &&
                            s.charAt(m) == s.charAt(n)) {
                        palindrome.addFirst(s.charAt(i));
                        palindrome.addFirst(s.charAt(m));
                        m--;
                        n++;
                        while (m >= 0 && n < s.length()) {
                            if (s.charAt(m) == s.charAt(n)) {
                                palindrome.addFirst(s.charAt(m));
                            } else {
                                break;
                            }
                            m--;
                            n++;
                        }
                        int k = palindrome.size() - 2;
                        while (k >= 0) {
                            palindrome.add(palindrome.get(k));
                            k--;
                        }
                    }
                }
            }
            if (palindrome.size() > palindromeMax.size()) {
                palindromeMax.clear();
                palindromeMax.addAll(palindrome);
            }
            i++;
        }
        StringBuilder result = new StringBuilder();
        i = 0;
        while (i < palindromeMax.size()) {
            result.append(palindromeMax.get(i));
            i++;
        }
        return result.toString();
    }

    // Manacher算法 0(n)
    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        return "";
    }

    public static void main(String[] args) {
        String result = longestPalindrome1("ccc");
        System.out.println(result);
    }
}
