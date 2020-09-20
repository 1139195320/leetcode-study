package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0593 {

    private int dist(int[]pA, int[] pB) {
        return (pA[0] - pB[0]) * (pA[0] - pB[0])
                + (pA[1] - pB[1]) * (pA[1] - pB[1]);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        // x 从小到大排序，x 相等则 y 从小到大排序
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        int len01 = dist(p[0], p[1]);
        if (len01 == 0) {
            return false;
        }
        int len12 = dist(p[1], p[2]);
        int len13 = dist(p[1], p[3]);
        int len23 = dist(p[2], p[3]);
        int len30 = dist(p[3], p[0]);
        int len20 = dist(p[2], p[0]);
        return len01 == len13 && len13 == len23 && len23 == len20 && len12 == len30;
    }

    public static void main(String[] args) {
        LeetCode0593 main = new LeetCode0593();
        System.out.println(main.validSquare(
                new int[] {0, 0},
                new int[] {1, 0},
                new int[] {0, 1},
                new int[] {1, 1}
        ));
    }
}