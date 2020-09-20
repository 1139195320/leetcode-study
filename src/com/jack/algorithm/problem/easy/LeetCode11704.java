package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode11704 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int allSum = 0;
        for (int i = 1; i <= n; i ++) {
            allSum += i;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return allSum - sum;
    }

    public int missingNumber2(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= n;
        // 存在的数都异或了 2 次，消掉了
        return res;
    }
}
