package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int res = 1;
        int curEndX = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            int startX = point[0];
            int endX = point[1];
            if (curEndX < startX) {
                res ++;
                curEndX = endX;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0452 main = new Medium0452();
        System.out.println(main.findMinArrowShots(
                new int[][]{
                        {10, 16}, {2, 8}, {1, 6}, {7, 12}
                }
        ));
    }
}