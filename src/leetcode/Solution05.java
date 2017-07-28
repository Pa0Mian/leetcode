package leetcode;


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
        int maxLenth = 1;
        int maxStart = 0;
        while (i < s.length()) {
            // 先左右扩展
            int m = i - 1;
            int n = i + 1;
            int maxTemp = 1;
            while (m >= 0 && n < s.length()) {
                if (s.charAt(m) == s.charAt(n)) {
                    maxTemp = maxTemp + 2;
                    if (maxTemp > maxLenth) {
                        maxLenth = maxTemp;
                        maxStart = m;
                    }
                } else {
                    break;
                }
                m--;
                n++;
            }

            // 再以当前字符和下个字符扩展
            int k = i;
            int l = i + 1;
            maxTemp = 0;
            while (k >= 0 && l < s.length()) {
                if (s.charAt(k) == s.charAt(l)) {
                    maxTemp = maxTemp + 2;
                    if (maxTemp > maxLenth) {
                        maxLenth = maxTemp;
                        maxStart = k;
                    }
                } else {
                    break;
                }
                k--;
                l++;
            }
            i++;
        }
        return s.substring(maxStart, maxStart + maxLenth);
    }

    // Manacher算法 0(n)
    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String s1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        s1.substring(34, 7);
        return "";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = longestPalindrome1("ababd");
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }
}
