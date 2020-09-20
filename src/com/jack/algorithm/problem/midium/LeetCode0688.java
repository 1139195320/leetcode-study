package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0688 {

    private int[][] dirs = {{-2, 1}, {-2, -1}, {1, -2}, {1, 2},
            {2, -1}, {2, 1}, {-1, 2}, {-1, -2}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        for (; K > 0; K --) {
            double[][]tmpDp = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = 0;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            // 从上一个点跳到该点的概率
                            tmpDp[x][y] += dp[i][j] / 8.0;
                        }
                    }
                }
            }
            dp = tmpDp;
        }
        double res = 0;
        for (double[] row : dp) {
            for (double x : row) {
                res += x;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0688 main = new LeetCode0688();
        System.out.println(main.knightProbability(
                3, 2, 0, 0
        ));
    }
}
