package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0813 {

    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        // dp[i][j] ：从 0 - j 的数，切 i 刀
        double[][] dp = new double[K][n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            dp[0][i] = sum / (i + 1);
        }
        for (int k = 1; k < K; k++) {
            for (int i = k; i < n; i++) {
                sum = 0.0;
                for (int j = i; j > k - 1; j--) {
                    sum += A[j];
                    dp[k][i] = Math.max(dp[k][i],
                            sum / (i - j + 1) + dp[k - 1][j - 1]);
                }
            }
        }
        return dp[K - 1][n - 1];
    }

    public static void main(String[] args) {
        Medium0813 main = new Medium0813();
        System.out.println(main.largestSumOfAverages(
                new int[]{9, 1, 2, 3, 9}, 3
        ));
    }
}