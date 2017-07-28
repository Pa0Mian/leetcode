package leetcode;

/**
 * Created by wzx on 2017/7/28.
 */
public class Solution06 {
    /**
     * 暴力方法，矩阵+遍历
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[][]  matrix = new char[numRows][s.length()];
        int index = 0;
        int i = 0;
        boolean end = false;
        if (numRows == 1) {
            return s;
        }
        while (true) {
            for (int j = 0; j < numRows; j++) {
                if (i % (numRows - 1) == 0) {
                    if (index < s.length()) {
                        matrix[j][i] = s.charAt(index);
                        index++;
                    } else {
                        end = true;
                        matrix[j][i] = 0;
                    }
                } else {
                    if ((i+j) % (numRows - 1) == 0) {
                        if (index < s.length()) {
                            matrix[j][i] = s.charAt(index);
                            index++;
                        } else {
                            end = true;
                            matrix[j][i] = 0;
                        }
                    } else {
                        matrix[j][i] = 0;
                    }
                }
            }
            if (end) {
                break;
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int m = 0; m < numRows; m ++) {
            for (int j = 0; j < s.length(); j++) {
                if (matrix[m][j] != 0) {
                    stringBuilder.append(matrix[m][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(convert1("gjmwractemolpfkwzaeiuxroknqcvcfclryeraaxmoidvuzuvgepdyfolvsgzxkkqiqjkqgzhrccnexikdzpbefob"
               , 59));
        System.out.println(System.currentTimeMillis()-start);
    }
}
