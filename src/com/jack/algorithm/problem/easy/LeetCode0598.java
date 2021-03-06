package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0598 {

    public int maxCount(int m, int n, int[][] ops) {
        int a = m;
        int b = n;
        for (int[] op : ops) {
            a = Math.min(a, op[0]);
            b = Math.min(b, op[1]);
        }
        return a * b;
    }

    public static void main(String[] args) {
        LeetCode0598 main = new LeetCode0598();
    }
}