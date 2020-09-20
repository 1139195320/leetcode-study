package com.jack.algorithm.problem.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCodeL10007 {

    public int numWays(int n, int[][] relation, int k) {
        map = new HashMap<>(n);
        for (int[] arr : relation) {
            Set<Integer> set = map.computeIfAbsent(arr[0], key -> new HashSet<>());
            set.add(arr[1]);
        }
        target = n - 1;
        res = 0;
        dfs(k, 0);
        return res;
    }
    private int res;
    private int target;
    private Map<Integer, Set<Integer>> map;
    private void dfs(int k, int cur) {
        if (k == 0) {
            if (cur == target) {
                res ++;
            }
            return;
        }
        Set<Integer> nextSet = map.get(cur);
        if (nextSet == null) {
            return;
        }
        for (int next : nextSet) {
            dfs(k - 1, next);
        }
    }

    public int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] arr : relation) {
                dp[i + 1][arr[1]] += dp[i][arr[0]];
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        LeetCodeL10007 main = new LeetCodeL10007();
        System.out.println(main.numWays(
                5,
                new int[][]{
                        {0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}
                },
                3
        ));
    }
}