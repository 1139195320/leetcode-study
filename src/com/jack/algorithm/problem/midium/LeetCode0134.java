package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // gas 加油量，cost 耗油量
        int n = gas.length;
        int total = 0;
        int diff = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            diff += gas[i] - cost[i];
            if (diff < 0) {
                res = i + 1;
                diff = 0;
            }
        }
        return total >= 0 ? res : -1;
    }

    public static void main(String[] args) {
        LeetCode0134 main = new LeetCode0134();
        System.out.println(main.canCompleteCircuit(
                new int[] {1, 2, 3, 4, 5},
                new int[] {3, 4, 5, 1, 2}
        ));
        System.out.println(main.canCompleteCircuit(
                new int[] {2, 3, 4},
                new int[] {3, 4, 3}
        ));
    }
}