package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1223 {

    public int dieSimulator(int n, int[] rollMax) {
        int MOD = 1_000_000_007;
        // 骰子最大数
        int maxDice = 6;
        // 最大连续次数
        int maxCount = 15;
        int[][][] dp = new int[n][maxDice + 1][maxCount + 1];
        for (int i = 0; i < n; i++) {
            // 当前投掷点数
            for (int j = 1; j <= maxDice; j++) {
                if (i == 0) {
                    dp[i][j][1] = 1;
                    continue;
                }
                // 上一次投掷点数
                for (int preJ = 1; preJ <= maxDice; preJ++) {
                    if (j == preJ) {
                        for (int count = 1; count < rollMax[preJ - 1]; count++) {
                            dp[i][j][count + 1] += dp[i - 1][j][count];
                            dp[i][j][count + 1] %= MOD;
                        }
                    } else {
                        for (int count = 1; count <= rollMax[preJ - 1]; count++) {
                            dp[i][j][1] += dp[i - 1][preJ][count];
                            dp[i][j][1] %= MOD;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= maxDice; i++) {
            for (int j = 0; j <= rollMax[i - 1]; j++) {
                res += dp[n - 1][i][j];
                res %= MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1223 main = new Medium1223();
        System.out.println(main.dieSimulator(
                2, new int[]{1, 1, 2, 2, 2, 3}
        ));
        System.out.println(main.dieSimulator(
                2, new int[]{1, 1, 1, 1, 1, 1}
        ));
        System.out.println(main.dieSimulator(
                3, new int[]{1, 1, 1, 2, 2, 3}
        ));
    }
}