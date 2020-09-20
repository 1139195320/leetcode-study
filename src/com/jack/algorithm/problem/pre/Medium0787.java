package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0787 {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int K) {
        int res = 0;
        int[][] dp = new int[2][n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dp[0], INF);
        Arrays.fill(dp[1], INF);
        // 因为 src 是起点，所以初始化 src 为终点所需最少的钱为 0
        dp[0][src] = dp[1][src] = 0;
        for (int i = 0; i < K; i++) {
            for (int[] flight : flights) {
                // 1、flight[1] 为终点所需的钱
                // 2、flight[0] 为终点的钱 + flight[0] 到 flight[1] 的钱
                dp[i & 1][flight[1]] = Math.min(dp[i & 1][flight[1]],
                        dp[~i & 1][flight[0]] + flight[2]);
            }
        }
        // 以 dst 为终点最少需要花的钱，如果数据仍是 INF 说明不可达
        return dp[K & 1][dst] < INF ? dp[K & 1][dst] : -1;
    }
}
