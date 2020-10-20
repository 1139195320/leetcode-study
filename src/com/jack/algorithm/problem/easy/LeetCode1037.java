package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1037 {

    public boolean isBoomerang(int[][] points) {
        int[] point1 = points[0];
        int[] point2 = points[1];
        int[] point3 = points[2];
        if (isSame(point1, point2)
                || isSame(point1, point3)
                || isSame(point2, point3)) {
            return false;
        }
        if (point1[0] == point2[0] && point1[0] == point3[0]) {
            return false;
        }
        if (point1[1] == point2[1] && point1[1] == point3[1]) {
            return false;
        }
        double k = (point2[1] - point1[1]) * 1.0
                / (point2[0] - point1[0]);
        double b = point1[1] - k * point1[0];
        return point3[1] != k * point3[0] + b;
    }
    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }
}
