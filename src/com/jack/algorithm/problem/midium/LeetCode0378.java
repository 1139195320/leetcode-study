package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[n * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, arr, i * n, n);
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        LeetCode0378 main = new LeetCode0378();
        System.out.println(main.kthSmallest(
                new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 8
        ));
    }
}