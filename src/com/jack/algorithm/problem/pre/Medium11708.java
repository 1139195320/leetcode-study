package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11708 {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = height[i];
            arr[i][1] = weight[i];
        }
        Arrays.sort(arr, (a, b) ->
                a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0][1];
        dp[0][1] = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i][1];
            dp[i][0] = cur;
            dp[i][1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j][1] < cur) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium11708 main = new Medium11708();
        System.out.println(main.bestSeqAtIndex(
                new int[]{65, 70, 56, 75, 60, 68},
                new int[]{100, 150, 90, 190, 95, 110}
        ));
    }
}
