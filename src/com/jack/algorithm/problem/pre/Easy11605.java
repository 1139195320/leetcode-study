package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy11605 {

    public int trailingZeroes(int n) {
        int res = 0;
        int i = 5;
        while (i <= n) {
            int cur = i;
            while (cur % 5 == 0) {
                res ++;
                cur /= 5;
            }
            i += 5;
        }
        return res;
    }

    public static void main(String[] args) {
        Easy11605 main = new Easy11605();
        System.out.println(main.trailingZeroes(3));
        System.out.println(main.trailingZeroes(5));
        // 5 10 15 20 25
        System.out.println(main.trailingZeroes(25));
    }
}