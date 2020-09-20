package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0096 {

    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }

    public int numTrees3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < (i - 1) / 2 + 1; j++) {
                int o = i - 1 - j;
                int tmp = Math.max(1, dp[j]) * Math.max(1, dp[o]);
                if (o != j) {
                    dp[i] += tmp * 2;
                } else {
                    dp[i] += tmp;
                }
            }
        }
        return dp[n];
    }

    /**
     * 卡塔兰数
     */
    public int numTrees2(int n) {
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = (c << 1) * ((i << 1) + 1) / (i + 2);
        }
        return (int) c;
    }

    public static void main(String[] args) {
        LeetCode0096 main = new LeetCode0096();
        System.out.println(main.numTrees(3));
        System.out.println(main.numTrees2(3));
    }
}
