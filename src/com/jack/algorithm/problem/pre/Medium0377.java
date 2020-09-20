package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0377 {

    public int combinationSum4(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        dfs(nums, target, 0, 0);
        return count;
    }
    private int count;
    private void dfs(int[] nums, int target, int start, int pre) {
        if (pre >= target) {
            if (pre == target) {
                count ++;
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (pre + num > target) {
                break;
            }
            dfs(nums, target, start, pre + num);
        }
    }

    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int num : nums) {
            if (num <= target) {
                dp[num] = 1;
            }
        }
        for (int i = 2; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Medium0377 main = new Medium0377();
        System.out.println(main.combinationSum4(
                new int[]{1, 2, 3}, 4
        ));
        System.out.println(main.combinationSum4_2(
                new int[]{1, 2, 3}, 4
        ));
        System.out.println(main.combinationSum4(
                new int[]{2, 3, 12}, 4
        ));
        System.out.println(main.combinationSum4_2(
                new int[]{2, 3, 12}, 4
        ));
        System.out.println(main.combinationSum4(
                new int[]{2, 5, 7, 12}, 9
        ));
        System.out.println(main.combinationSum4_2(
                new int[]{2, 5, 7, 12}, 9
        ));
    }
}