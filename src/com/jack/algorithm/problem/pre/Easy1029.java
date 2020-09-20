package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy1029 {

    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length;
        int n = N >> 1;
        int res = 0;
        // 先全部选 0 的
        for (int[] cost : costs) {
            res += cost[0];
        }
        // 从 0 换成 1 需要补的差价
        int[] diffs = new int[N];
        for (int i = 0; i < costs.length; i++) {
            diffs[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(diffs);
        for (int i = 0; i < n; i++) {
            res += diffs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Easy1029 main = new Easy1029();
        System.out.println(main.twoCitySchedCost(
                new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}
        ));
    }
}