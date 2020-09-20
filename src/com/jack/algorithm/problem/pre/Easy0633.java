package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0633 {

    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Easy0633 main = new Easy0633();
        System.out.println(main.judgeSquareSum(5));
        System.out.println(main.judgeSquareSum(6));
    }
}