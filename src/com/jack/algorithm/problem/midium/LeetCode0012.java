package com.jack.algorithm.problem.midium;

/**
 * @author jack
 *
 * 阿拉伯数字转罗马数字
 */
public class LeetCode0012 {

    private static String[][] romanData = new String[][]{
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}
    };

    public String intToRoman(int num) {
        return romanData[3][num / 1000 % 10] +
                romanData[2][num / 100 % 10] +
                romanData[1][num / 10 % 10] +
                romanData[0][num % 10];
    }

    public static void main(String[] args) {
        LeetCode0012 main = new LeetCode0012();
        System.out.println(main.intToRoman(3));
        System.out.println(main.intToRoman(4));
        System.out.println(main.intToRoman(9));
        System.out.println(main.intToRoman(58));
        System.out.println(main.intToRoman(1994));
    }
}
