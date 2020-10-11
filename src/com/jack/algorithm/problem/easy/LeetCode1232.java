package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        // y = kx + b
        // 两（不重复的）点确定一条线
        int[] dot1 = coordinates[0];
        int[] dot2 = coordinates[1];
        if (dot2[0] == dot1[0]) {
            // 平行于 y 轴的线
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != dot1[0]) {
                    return false;
                }
            }
        }
        else {
            double k = 1.0 * (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
            double b = dot1[1] - k * dot1[0];
            for (int i = 2; i < coordinates.length; i++) {
                int[] dot = coordinates[i];
                if (k * dot[0] + b != dot[1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
