package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0517 {

    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0) {
            return -1;
        }
        int target = sum / n;
        for (int i = 0; i < machines.length; i++) {
            machines[i] -= target;
        }
        int res = 0;
        int curSum = 0;
        int maxSum = 0;
        for (int machine : machines) {
            curSum += machine;
            maxSum = Math.max(maxSum , Math.abs(curSum));
            res = Math.max(res, Math.max(maxSum, machine));
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0517 main = new LeetCode0517();
        System.out.println(main.findMinMoves(
                new int[]{1, 0, 5}
        ));
        System.out.println(main.findMinMoves(
                new int[]{0, 3, 0}
        ));
        System.out.println(main.findMinMoves(
                new int[]{0, 2, 0}
        ));
    }
}