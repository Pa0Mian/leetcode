package leetcode;

/**
 * Created by wzx on 2017/7/28.
 * leetcode problem 06:
 *   The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R
     And then read line by line: "PAHNAPLSIIGYIR"
     Write the code that will take a string and make this conversion given a number of rows:

     string convert(string text, int nRows);
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
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

    /**
     * todo
     * 找规律，2n - 2
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {

        }
        return  "";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(convert1("gjmwractemolpfkwzaeiuxroknqcvcfclryeraaxmoidvuzuvgepdyfolvsgzxkkqiqjkqgzhrccnexikdzpbefob"
               , 59));
        System.out.println(System.currentTimeMillis()-start);
    }
}
