package com.jack.algorithm.problem.hard;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0085 {

    /**
     * not ok
     */
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // 分别存当前矩形横纵长度
        int[][][] dp = new int[row][col][2];
        int first = matrix[0][0] - '0';
        dp[0][0][0] = first != 0 ? 1 : 0;
        dp[0][0][1] = first != 0 ? 1 : 0;
        res = first;
        for (int i = 1; i < row; i++) {
            int cur = matrix[i][0] - '0';
            dp[i][0][0] = cur != 0 ? 1 : 0;
            dp[i][0][1] = cur != 0 ? dp[i - 1][0][1] + 1 : 0;
            res = Math.max(res, dp[i][0][0] * dp[i][0][1]);
        }
        for (int i = 1; i < col; i++) {
            int cur = matrix[0][i] - '0';
            dp[0][i][0] = cur != 0 ? dp[0][i - 1][1] + 1 : 0;
            dp[0][i][1] = cur != 0 ? 1 : 0;
            res = Math.max(res, dp[0][i][0] * dp[0][i][1]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int cur = matrix[i][j] - '0';
                int[] up = dp[i - 1][j];
                int[] left = dp[i][j - 1];
                int x = 0;
                int y = 0;
                if (cur != 0) {
                    y = up[1] + 1;
                    x += 1;
                    int tmpJ = j;
                    while (left[1] >= y) {
                        int tmp = left[0];
                        x += tmp;
                        if (left[1] == y) {
                            break;
                        }
                        tmpJ = tmpJ - tmp - 1;
                        if (tmpJ < 0) {
                            break;
                        }
                        left = dp[i][tmpJ];
                    }
                }
                dp[i][j][0] = x;
                dp[i][j][1] = y;
                res = Math.max(res, x * y);
            }
        }
        for (int[][] arrArr : dp) {
            for (int[] arr : arrArr) {
                System.out.print(Arrays.toString(arr) + ", ");
            }
            System.out.println();
        }
        return res;
    }

    public int maximalRectangle2(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] h = new int[col];
        int[] l = new int[col];
        int[] r = new int[col];
        Arrays.fill(r, col);
        for (char[] arr : matrix) {
            int curL = 0;
            int curR = col;
            for (int j = 0; j < col; j++) {
                if (arr[j] == '1') {
                    h[j]++;
                    l[j] = Math.max(l[j], curL);
                } else {
                    h[j] = 0;
                    l[j] = 0;
                    curL = j + 1;
                }
            }
            for (int j = col - 1; j >= 0; j--) {
                if (arr[j] == '1') {
                    r[j] = Math.min(r[j], curR);
                } else {
                    r[j] = col;
                    curR = j;
                }
                res = Math.max(res, (r[j] - l[j]) * h[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0085 main = new LeetCode0085();
//        System.out.println(main.maximalRectangle(
//                new char[][]{
//                        {'1', '0', '1', '0', '0'},
//                        {'1', '0', '1', '1', '1'},
//                        {'1', '1', '1', '1', '1'},
//                        {'1', '0', '0', '1', '0'}
//                }
//        ));
        System.out.println(main.maximalRectangle2(
                new char[][]{
                        {'0', '1', '1', '0', '1'},
                        {'1', '1', '0', '1', '0'},
                        {'0', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '1'},
                        {'0', '0', '0', '0', '0'}
                }
        ));
    }
}