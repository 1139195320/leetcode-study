package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0059 {

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][] {};
        }
        int[][] res = new int[n][n];
        boolean toR = true, toD = false, toL = false;
        int count = 1;
        int target = n * n;
        int l = 0, r = n - 1, u = 1, d = n - 1;
        int i = 0, j = 0;
        while (count <= target) {
            res[i][j] = count ++;
            if (toR) {
                j ++;
                if (j == r) {
                    // 边界 end
                    r --;
                    toD = true;
                    toR = false;
                }
            }
            else if (toD) {
                i ++;
                if (i == d) {
                    // 边界 end
                    d --;
                    toL = true;
                    toD = false;
                }
            }
            else if (toL) {
                 j--;
                if (j == l) {
                    // 边界 end
                    l ++;
                    toL = false;
                }
            }
            else {
                i --;
                if (i == u) {
                    // 边界 end
                    u ++;
                    toR = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0059 main = new LeetCode0059();
        for (int[] arr : main.generateMatrix(2)) {
            System.out.println(Arrays.toString(arr));
        }
        for (int[] arr : main.generateMatrix(3)) {
            System.out.println(Arrays.toString(arr));
        }
        for (int[] arr : main.generateMatrix(4)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}