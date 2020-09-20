package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            dp[i][0] = num;
            dp[i][1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (num > dp[j][0]) {
                    dp[i][1] = dp[j][1] + 1;
                    break;
                }
            }
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0300 main = new Medium0300();
        System.out.println(main.lengthOfLIS(
                new int[]{10, 9, 2, 5, 3, 7, 101, 18}
        ));
    }
}
