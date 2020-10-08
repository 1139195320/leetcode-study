package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0633 {

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0633 main = new LeetCode0633();
        System.out.println(main.judgeSquareSum(5));
        System.out.println(main.judgeSquareSum(6));
    }
}