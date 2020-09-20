package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0172 {

    public int trailingZeroes(int n) {
        int tail0 = 0;
        int i = 5;
        while (i <= n) {
            int tmp = i;
            while (tmp % 5 == 0) {
                tail0 ++;
                tmp /= 5;
            }
            i += 5;
        }
        return tail0;
    }

    public int trailingZeroes2(int n) {
        int tail0 = 0;
        while (n > 0) {
            n /= 5;
            tail0 += n;
        }
        return tail0;
    }

    public static void main(String[] args) {
        LeetCode0172 main = new LeetCode0172();
        System.out.println(main.trailingZeroes2(3));
        System.out.println(main.trailingZeroes2(5));
    }
}