package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0048 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n / 2); i++) {
            int right = n - i - 1;
            int down = n - i - 1;
            for (int j = i; j < n - i - 1; j++) {
                // 顺时针赋值
                int tmp = matrix[i][j];
                // 上边 <= 左边
                matrix[i][j] = matrix[down - j + i][i];
                // 左边 <= 下边
                matrix[down - j + i][i] = matrix[down][right - j + i];
                // 下边 <= 右边
                matrix[down][right - j + i] = matrix[j][right];
                // 右边 <= 上边
                matrix[j][right] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0048 main = new LeetCode0048();
        main.test1();
        main.test2();
    }
    private void test1() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("====================");
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    private void test2() {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("====================");
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}