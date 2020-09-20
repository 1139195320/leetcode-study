package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0718 {

    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][]dp = new int[lenA][lenB];
        int res = 0;
        for (int i = 0; i < lenB; i++) {
            dp[0][i] = A[0] == B[i] ? 1 : 0;
            res = Math.max(res, dp[0][i]);
        }
        for (int i = 1; i < lenA; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
            res = Math.max(res, dp[i][0]);
        }
        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0718 main = new LeetCode0718();
        System.out.println(main.findLength(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}
        ));
    }
}