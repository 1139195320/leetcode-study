package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0576 {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD = 1_000_000_009;
        int[][] dp = new int[m][n];
        int[][] preDp = new int[m][n];
        preDp[i][j] = 1;
        dp[i][j] = 1;
        for (; N > 1; N --) {
            int[][] tmpDp = new int[m][n];
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int[] dir : dirs) {
                        int preX = x + dir[0];
                        int preY = y + dir[1];
                        if (preX >= 0 && preX < m && preY >= 0 && preY < n) {
                            tmpDp[x][y] += preDp[preX][preY];
                            dp[x][y] += preDp[preX][preY];
                            dp[x][y] %= MOD;
                        }
                    }
                }
            }
            preDp = tmpDp;
        }
//        for (int[] row : dp) {
//            System.out.println(Arrays.toString(row));
//        }
        if (m == 1 && n == 1) {
            return dp[0][0] * 4 % MOD;
        }
        int res = 0;
        if (m == 1) {
            // n > 1
            res += dp[0][0] * 3;
            res += dp[0][n - 1] * 3;
            for (int k = 1; k < n - 1; k++) {
                res += dp[0][k] << 1;
                res %= MOD;
            }
        }
        else if (n == 1) {
            // m > 1
            res += dp[0][0] * 3;
            res += dp[m - 1][0] * 3;
            for (int k = 1; k < m - 1; k++) {
                res += dp[k][0] << 1;
                res %= MOD;
            }
        }
        else {
            // m > 1
            // n > 1
            res += (dp[0][0] + dp[m - 1][0] +
                    dp[0][n - 1] + dp[m - 1][n - 1]) << 1;
            res %= MOD;
            for (int k = 1; k < n - 1; k++) {
                res += dp[0][k];
                res += dp[m - 1][k];
                res %= MOD;
            }
            for (int k = 1; k < m - 1; k++) {
                res += dp[k][0];
                res += dp[k][n - 1];
                res %= MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0576 main = new Medium0576();
        System.out.println(main.findPaths(2, 2, 2, 0, 0));
        System.out.println(main.findPaths(1, 3, 3, 0, 1));
    }
}
