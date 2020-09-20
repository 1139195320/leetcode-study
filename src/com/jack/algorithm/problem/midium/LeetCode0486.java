package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0486 {

    public boolean PredictTheWinner(int[] nums) {
        return play(nums, 0, nums.length - 1, true,
                0, 0);
    }
    private boolean play(int[] nums, int l, int r, boolean isOne,
                         int scoreOne, int scoreTwo) {
        if (l >= r) {
            if (isOne) {
                scoreOne += nums[l];
            } else {
                scoreTwo += nums[l];
            }
            return scoreOne >= scoreTwo;
        }
        if (isOne) {
            return play(nums, l + 1, r, false,
                    scoreOne + nums[l], scoreTwo)
                    || play(nums, l, r - 1, false,
                    scoreOne + nums[r], scoreTwo);
        } else {
            return play(nums, l + 1, r, true,
                    scoreOne, scoreTwo + nums[l])
                    && play(nums, l, r - 1, true,
                    scoreOne, scoreTwo + nums[r]);
        }
    }


    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }


    public boolean PredictTheWinner3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j],
                        nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }

    public boolean PredictTheWinner4(int[] nums) {
        // 1 先取 1-20
        int n = nums.length;
        if (n < 3) {
            return true;
        }
        return dfs(nums, 1, n - 1, false, nums[0])
                || dfs(nums, 0, n - 2, false, nums[n - 1]);
    }
    private boolean dfs(int[] nums,int l, int r, boolean flag, int sum) {
        if (l == r) {
            if (flag) {
                sum += nums[l];
            }
            else {
                sum -= nums[l];
            }
            return sum >= 0;
        }
        if (flag) {
            // 玩家一选，有一种 success 即可
            return dfs(nums, l + 1, r, false, sum + nums[l])
                    || dfs(nums, l, r - 1, false, sum + nums[r]);
        }
        else {
            // 玩家二选，两种都 success 才行
            return dfs(nums, l + 1, r, true, sum - nums[l])
                    && dfs(nums, l, r - 1, true, sum - nums[r]);
        }
    }


    public static void main(String[] args) {
        LeetCode0486 main = new LeetCode0486();
        System.out.println(main.PredictTheWinner(
                new int[] {4, 8, 6}
        ));
        System.out.println(main.PredictTheWinner(
                new int[] {1, 5, 233, 7}
        ));
        System.out.println(main.PredictTheWinner2(
                new int[] {4, 8, 6}
        ));
        System.out.println(main.PredictTheWinner2(
                new int[] {1, 5, 233, 7}
        ));
        System.out.println(main.PredictTheWinner3(
                new int[] {4, 8, 6}
        ));
        System.out.println(main.PredictTheWinner3(
                new int[] {1, 5, 233, 7}
        ));
    }
}
