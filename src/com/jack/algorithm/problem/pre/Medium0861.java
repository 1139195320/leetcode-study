package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0861 {

    public int matrixScore(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for (int i = 0; i < n; i++) {
            // 如果这一行的第一个数是 0，则翻转这一行
            if (A[i][0] == 0) {
                flip(A, i);
            }
        }
        int res = (1 << (m - 1)) * n;
        for (int i = 1; i < m; i++) {
            // 先遍历列
            int count = 0;
            for (int[] a : A) {
                // 里面遍历行
                count += a[i];
            }
            res += (1 << (m - 1 - i))
                    * Math.max(count, n - count);
        }
        return res;
    }
    private void flip(int[][] arr, int row) {
        // 翻转 第 row 行
        for (int i = 0; i < arr[0].length; i++) {
            arr[row][i] ^= 1;
        }
    }

    public static void main(String[] args) {
        Medium0861 main = new Medium0861();
        // 1 1 1 1
        // 1 0 0 1
        // 1 1 1 1
        System.out.println(main.matrixScore(
                new int[][]{
                        {0, 0, 1, 1},
                        {1, 0, 1, 0},
                        {1, 1, 0, 0}
                }
        ));
    }
}