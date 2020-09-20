package com.jack.algorithm.problem.easy;

/**
 * @author jack
 *
 * 罗马数字转阿拉伯数字
 */
public class LeetCode0013 {

    private static String[][] romanData = new String[][]{
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}
    };

    public int romanToInt(String num) {
        int res = 0;
        for (int i = romanData.length - 1; i >= 0; i--) {
            for (int j = romanData[i].length - 1; j >= 0; j--) {
                if (num.startsWith(romanData[i][j])) {
                    int tmp = 1;
                    for (int k = i; k > 0; k--) {
                        tmp *= 10;
                    }
                    res += (tmp * j);
                    num = num.substring(romanData[i][j].length());
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0013 main = new LeetCode0013();
        System.out.println(main.romanToInt("III"));
        System.out.println(main.romanToInt("IV"));
        System.out.println(main.romanToInt("IX"));
        System.out.println(main.romanToInt("LVIII"));
        System.out.println(main.romanToInt("MCMXCIV"));
    }
}