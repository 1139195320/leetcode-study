package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0441 {

    public int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        int res = 1;
        n --;
        int cur = 2;
        while (n >= cur) {
            n -= cur;
            res ++;
            cur ++;
        }
        return res;
    }

    public int arrangeCoins2(int n) {
        // (res + 1) * res / 2 = n
        // res * res + res - 2 * n = 0;
        // res = (sqrt(8 * n + 1) - 1) / 2
        // res = (sqrt(2 * n + 1 / 4) - 1 / 2)
        // Math.sqrt(2 * n + 1 / 4) - 1 / 2;
        // Math.sqrt(2) * Math.sqrt(n + 1 / 8) - 1 / 2
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    public static void main(String[] args) {
        LeetCode0441 main = new LeetCode0441();
        System.out.println(main.arrangeCoins(5));
        System.out.println(main.arrangeCoins(8));
    }
}