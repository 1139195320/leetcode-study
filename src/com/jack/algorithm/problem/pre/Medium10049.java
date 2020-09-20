package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium10049 {

    public int nthUglyNumber(int n) {
        // 2 3 5
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            int curA = dp[a] * 2;
            int curB = dp[b] * 3;
            int curC = dp[c] * 5;
            dp[i] = Math.min(Math.min(curA, curB), curC);
            if (dp[i] == curA) {
                a ++;
            }
            if (dp[i] == curB) {
                b ++;
            }
            if (dp[i] == curC) {
                c ++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Medium10049 main = new Medium10049();
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.print(main.nthUglyNumber(i));
            if (i != n - 1) {
                System.out.print(", ");
            }
        }
    }
}