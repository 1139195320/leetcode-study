package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jack
 */
public class LeetCode0646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (pairs[j][0] > pairs[i][1]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0646 main = new LeetCode0646();
        System.out.println(main.findLongestChain(
                new int[][]{{1, 2}, {2, 3}, {3, 4}}
        ));
    }
}