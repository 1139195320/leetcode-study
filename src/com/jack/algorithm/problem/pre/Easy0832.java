package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy0832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (col >> 1); j++) {
                swap(A, i, j, col - 1 - j);
                A[i][j] ^= 1;
                A[i][col - 1 - j] ^= 1;
            }
            if ((col & 1) != 0) {
                // 列数为奇数，最中间的列
                A[i][col >> 1] ^= 1;
            }
        }
        return A;
    }
    private void swap(int[][] arr, int row,  int i, int j) {
        int tmp = arr[row][i];
        arr[row][i] = arr[row][j];
        arr[row][j] = tmp;
    }

    public static void main(String[] args) {
        Easy0832 main = new Easy0832();
        System.out.println(Arrays.deepToString(main.flipAndInvertImage(
                new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}
        )));
    }
}