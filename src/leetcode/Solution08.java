package leetcode;


import java.math.BigDecimal;

/**
 * Created by Pao.Main on 2017/9/7.
 */
public class Solution08 {
    // 性能不好 2.8%
    public int myAtoi(String str) {
        String tem = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tem.length(); i++) {
            char ch = tem.charAt(i);
            if (i == 0) {
                if (ch == '-' || ch == '+' || (ch >= 48 && ch <= 57)) {
                    stringBuilder.append(ch);
                } else {
                    break;
                }
            } else {
                if (ch >= 48 && ch <= 57) {
                    stringBuilder.append(ch);
                } else {
                    break;
                }
            }
        }
        try {
            BigDecimal lVaule = new BigDecimal(stringBuilder.toString());
            if (lVaule.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1) {
                return Integer.MAX_VALUE;
            } else if (lVaule.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1) {
                return Integer.MIN_VALUE;
            }
            return lVaule.intValue();
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
        return 0;
    }

    // 优化 48.1%
    public int myAtoi2(String str) {
        String tem = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        boolean isNegative = false;
        for (int i = 0; i < tem.length(); i++) {
            char ch = tem.charAt(i);
            if (i == 0) {
                if (ch == '-')
                    isNegative = true;
                else if (ch == '+')
                    continue;
                else if (ch >= 48 && ch <= 57)
                    stringBuilder.append(ch);
                else
                    break;
            } else {
                if (ch >= 48 && ch <= 57) {
                    stringBuilder.append(ch);
                } else {
                    break;
                }
            }
        }
        tem = stringBuilder.toString();
        long resultTemp = 0;
        int result = 0;
        for (int i = 0; i < tem.length(); i++) {
            char ch = tem.charAt(tem.length() - i - 1);
            resultTemp += (ch - '0') * Math.pow(10, i);
            if (!isNegative) {
                if (resultTemp >= Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                    break;
                }
                result = (int) resultTemp;
            } else {
                // 这里必须用resultTemp - 1和Inter.MAX_VALUE判断
                // 不能用resultTemp和Inter.MAX_VALUE+1做判断，因为(int)(Inter.MAX_VALUE+1)会溢出
                if (resultTemp - 1 >= Integer.MAX_VALUE) {
                    result = Integer.MIN_VALUE;
                    break;
                }
                result = -(int) resultTemp;
            }
        }
        return result;
    }
}
