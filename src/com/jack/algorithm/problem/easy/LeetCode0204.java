package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0204 {

    public int countPrimes(int n) {
        // 超时
        if (n <= 2) {
            return 0;
        }
        int res = 1;
        for (int i = 3; i < n; i += 2) {
            boolean flag = true;
            for (int j = 2; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res ++;
            }
        }
        return res;
    }

    public int countPrimes2(int n) {
        // 将（不大于根号n的质数）的奇数倍去掉后，剩余的奇数就是质数
        boolean[] arr = new boolean[n];
        int res = 0;
        if (n > 2) {
            res = 1;
        }
        int sqrtN = (int) Math.sqrt(n);
        // 只遍历奇数
        for (int i = 3; i < n; i += 2) {
            if (!arr[i]) {
                // 是质数
                if (i <= sqrtN) {
                    for (int j = i; j * i < n; j += 2) {
                        // 质数的奇数倍
                        arr[i * j] = true;
                    }
                }
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0204 main = new LeetCode0204();
        System.out.println(main.countPrimes(10));
    }
}