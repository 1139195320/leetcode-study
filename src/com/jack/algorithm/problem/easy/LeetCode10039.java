package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode10039 {

    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count ++;
            }
            else {
                count += (num == res) ? 1 : -1;
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}
