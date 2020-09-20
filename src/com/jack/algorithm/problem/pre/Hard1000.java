package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard1000 {

    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        int tmp = n;
        while (tmp >= K) {
            tmp = tmp - K + 1;
        }
        if (tmp != 1) {
            return -1;
        }
        int[] suffixSum = new int[n];
        suffixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            suffixSum[i] = suffixSum[i - 1] + stones[i];
        }
        int INF = Integer.MAX_VALUE >> 1;
        // 从 l 到 r 堆的石头合并
        int[][] dp = new int[n][n];
        // r 最小为 K - 1 才能满足前面有 K 堆
        for (int r = K - 1; r < n; r++) {
            // l 为 r 左边第 K - 1 堆开始往左移
            for (int l = r - K + 1; l >= 0; l--) {
                int minStones = INF;
                // 从 r 到 l，每次减少 K - 1 堆，即 K 堆一合并
                for (int k = r; k > l; k -= (K - 1)) {
                    minStones = Math.min(minStones,
                            dp[l][k - 1] + dp[k][r]);
                }
                dp[l][r] = minStones;
                // r - l 是 K - 1 的整数倍，此时可以合并 l 到 r
                if ((r - l) % (K - 1) == 0) {
                    dp[l][r] += suffixSum[r] -
                            (l > 0 ? suffixSum[l - 1] : 0);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Hard1000 main = new Hard1000();
        System.out.println(main.mergeStones(
                new int[]{3, 2, 4, 1}, 2
        ));
        System.out.println(main.mergeStones(
                new int[]{3, 2, 4, 1}, 3
        ));
    }
}