package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1314 {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i <= K && i < row; i++) {
            for (int j = 0; j <= K && j < col; j++) {
                res[0][0] += mat[i][j];
            }
        }
        for (int i = 1; i < row; i++) {
            res[i][0] += res[i - 1][0];
            int u = i - K - 1;
            int d = i + K;
            if (u >= 0 || d < row) {
                for (int k = 0; k <= K && k < col; k++) {
                    if (u >= 0) {
                        res[i][0] -= mat[u][k];
                    }
                    if (d < row) {
                        res[i][0] += mat[d][k];
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] += res[i][j - 1];
                // 左边界
                int l = j - K - 1;
                // 右边界
                int r = j + K;
                if (l >= 0 || r < col) {
                    for (int k = i - K; k <= i + K; k++) {
                        if (k >= 0 && k < row) {
                            if (l >= 0) {
                                res[i][j] -= mat[k][l];
                            }
                            if (r < col) {
                                res[i][j] += mat[k][r];
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1314 main = new LeetCode1314();
        for (int[] arr : main.matrixBlockSum(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1
        )) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr : main.matrixBlockSum(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2
        )) {
            System.out.println(Arrays.toString(arr));
        }
    }
}