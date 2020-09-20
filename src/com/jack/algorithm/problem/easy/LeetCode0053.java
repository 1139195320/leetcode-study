package com.jack.algorithm.problem.easy;

/**
 * @author fy
 */
public class LeetCode0053 {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0053 main = new LeetCode0053();
        System.out.println(main.maxSubArray(
                new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
