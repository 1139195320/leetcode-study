package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0935 {

    public int knightDialer(int N) {
        if (N <= 1) {
            return N * 10;
        }
        int k = 10;
        int[][] dp = new int[N][k];
        Arrays.fill(dp[0], 1);
        int res = 0;
        int MOD = 1_000_000_007;
        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % MOD;
            dp[i][1] = (dp[i - 1][6] + dp[i - 1][8]) % MOD;
            dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % MOD;
            dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % MOD;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][9] + dp[i - 1][0]) % MOD;
            dp[i][6] = (dp[i - 1][1] + dp[i - 1][7] + dp[i - 1][0]) % MOD;
            dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % MOD;
            dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][9] = (dp[i - 1][2] + dp[i - 1][4]) % MOD;
            if (i == N - 1) {
                for (int j = 0; j < k; j++) {
                    res += dp[i][j];
                    res %= MOD;
                }
            }
        }
        return res;
    }

    public int knightDialer2(int N) {
        if (N <= 1) {
            return N * 10;
        }
        int k = 10;
        int[] arr = new int[k];
        Arrays.fill(arr, 1);
        int res = 0;
        int MOD = 1_000_000_007;
        for (int i = 1; i < N; i++) {
            int cur0 = (arr[4] + arr[6]) % MOD;
            int cur1 = (arr[6] + arr[8]) % MOD;
            int cur2 = (arr[7] + arr[9]) % MOD;
            int cur3 = (arr[4] + arr[8]) % MOD;
            int cur4 = (arr[3] + arr[9] + arr[0]) % MOD;
            int cur6 = (arr[1] + arr[7] + arr[0]) % MOD;
            int cur7 = (arr[2] + arr[6]) % MOD;
            int cur8 = (arr[1] + arr[3]) % MOD;
            int cur9 = (arr[2] + arr[4]) % MOD;
            arr[0] = cur0;
            arr[1] = cur1;
            arr[2] = cur2;
            arr[3] = cur3;
            arr[4] = cur4;
            arr[5] = 0;
            arr[6] = cur6;
            arr[7] = cur7;
            arr[8] = cur8;
            arr[9] = cur9;
            if (i == N - 1) {
                for (int j = 0; j < k; j++) {
                    res += arr[j];
                    res %= MOD;
                }
            }
        }
        return res;
    }

    public int knightDialer3(int N) {
        int k = 10;
        if (N <= 1) {
            return N * k;
        }
        int res = 0;
        int MOD = 1_000_000_009;
        // moves[i]：表示从 i 可以跳到 moves[i] 里面的点
        int[][] moves = new int[][]{{4, 6}, {6, 8}, {7, 9},
                {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[2][k];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < N; i++) {
            // 第一个值取非，交替表示当前状态和上一个状态
            Arrays.fill(dp[~i & 1], 0);
            for (int j = 0; j < k; j++) {
                for (int to : moves[j]) {
                    // 从 j 点跳到 to 点
                    dp[~i & 1][to] += dp[i & 1][j];
                    dp[~i & 1][to] %= MOD;
                }
            }
        }
        for (int x : dp[~N & 1]) {
            res += x;
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0935 main = new Medium0935();
        System.out.println(main.knightDialer(1));
        System.out.println(main.knightDialer(2));
        System.out.println(main.knightDialer(3));
        System.out.println();
        System.out.println(main.knightDialer2(1));
        System.out.println(main.knightDialer2(2));
        System.out.println(main.knightDialer2(3));
        System.out.println();
        System.out.println(main.knightDialer3(1));
        System.out.println(main.knightDialer3(2));
        System.out.println(main.knightDialer3(3));
    }

}
