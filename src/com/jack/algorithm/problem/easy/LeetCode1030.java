package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int max = Math.max(R - 1 - r0, r0) + Math.max(C - 1 - c0, c0);
        int[][] res = new int[R * C][2];
        res[0] = new int[] {r0, c0};
        int i = 1;
        for (int distance = 1; distance <= max; distance++) {
            for (int r = Math.max(r0 - distance, 0); 
                    r <= Math.min(r0 + distance, R - 1); r++) {
                int c1 = c0 + (distance - Math.abs(r - r0));
                if (c1 < C) {
                    res[i ++] = new int[]{r, c1};
                }
                int c2 = c0 - (distance - Math.abs(r - r0));
                if (c2 >= 0 && c2 != c1) {
                    res[i ++] = new int[]{r, c2};
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1030 main = new LeetCode1030();
        System.out.println(Arrays.deepToString(
                main.allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(
                main.allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(
                main.allCellsDistOrder(2, 3, 1, 2)));
    }
}