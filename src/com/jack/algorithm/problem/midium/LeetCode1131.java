package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 * 三维曼哈顿距离
 */
public class LeetCode1131 {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0;
        int n = arr1.length;
        int[][] dirs = {{1, 1, 1}, {1, -1, 1}, {-1, 1, 1}, {-1, -1, 1},
                {1, 1, -1}, {1, -1, -1}, {-1, 1, -1}, {-1, -1, -1}};
        int[] max = new int[dirs.length];
        int[] min = new int[dirs.length];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < dirs.length; i++) {
            int[] dir = dirs[i];
            for (int j = 0; j < n; j++) {
                int sum = arr1[j] * dir[0] + arr2[j] * dir[1] + j * dir[2];
                max[i] = Math.max(max[i], sum);
                min[i] = Math.min(min[i], sum);
                res = Math.max(res, max[i] - min[i]);
            }
        }
        return res;
    }
}
