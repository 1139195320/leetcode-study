package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int curA = dp[a] * 2;
            int curB = dp[b] * 3;
            int curC = dp[c] * 5;
            int cur = Math.min(Math.min(curA, curB), curC);
            dp[i] = cur;
            if (cur == curA) {
                a ++;
            }
            if (cur == curB) {
                b ++;
            }
            if (cur == curC) {
                c ++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Medium0264 main = new Medium0264();
        System.out.println(main.nthUglyNumber(10));
    }
}