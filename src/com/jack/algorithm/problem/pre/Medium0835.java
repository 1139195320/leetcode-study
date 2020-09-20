package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0835 {

    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int[][] count = new int[2 * n + 1][2 * n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] == 1) {
                    for (int i2 = 0; i2 < n; ++i2) {
                        for (int j2 = 0; j2 < n; ++j2) {
                            if (B[i2][j2] == 1) {
                                count[i - i2 + n][j - j2 + n] += 1;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int[] row: count) {
            for (int v: row) {
                res = Math.max(res, v);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Medium0835 main = new Medium0835();
        System.out.println(main.largestOverlap(
                new int[][]{
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0}
                },
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 0, 1}
                }
        ));
    }
}