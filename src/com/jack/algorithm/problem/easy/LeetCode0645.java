package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0645 {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num - 1] ++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                res[0] = i + 1;
            }
            if (count[i] == 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }

    public int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(nums[i]);
            if (nums[tmp - 1] > 0) {
                nums[tmp - 1] *= -1;
            } else {
                res[0] = tmp;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }

}
