package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0016 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = nums[0] + nums[1] + nums[2];
        if (minSum >= target) {
            return minSum;
        }
        int len = nums.length;
        int maxSum = nums[len - 1] + nums[len - 2] + nums[len - 3];
        if (maxSum <= target) {
            return maxSum;
        }
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < len - 2; i++) {
            int need = target - nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                int curDiff = Math.abs(sum - need);
                if (curDiff == 0) {
                    return target;
                }
                if (curDiff < minDiff) {
                    minDiff = curDiff;
                    res = nums[i] + sum;
                }
                if (sum > need) {
                    r --;
                }
                if (sum < need) {
                    l ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0016 main = new LeetCode0016();
        System.out.println(main.threeSumClosest(
                new int[]{-1, 2, 1, -4}, 1
        ));
    }
}