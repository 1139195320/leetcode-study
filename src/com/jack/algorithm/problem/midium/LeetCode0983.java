package com.jack.algorithm.problem.midium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fy
 */
public class LeetCode0983 {

    int[] costs;
    Integer[] memo;
    Set<Integer> daySet;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        daySet = new HashSet<>();
        for (int d: days) {
            daySet.add(d);
        }
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (daySet.contains(i)) {
            memo[i] = Math.min(
                    Math.min(dp(i + 1) + costs[0],
                        dp(i + 7) + costs[1]),
                    dp(i + 30) + costs[2]);
        }
        else {
            memo[i] = dp(i + 1);
        }
        return memo[i];
    }

    public static void main(String[] args) {
        LeetCode0983 main = new LeetCode0983();
        System.out.println(main.mincostTickets(
                new int[]{1, 4, 6, 7, 8, 20},
                new int[]{2, 7, 15}));
        System.out.println(main.mincostTickets(
                new int[]{4, 5, 9, 11, 14, 16, 17, 19, 21, 22, 24},
                new int[]{1, 4, 18}));
    }

}
