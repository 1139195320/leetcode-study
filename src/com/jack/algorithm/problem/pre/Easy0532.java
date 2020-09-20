package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0532 {

    public int findPairs(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(cur - nums[j]) == k) {
                    res ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Easy0532 main = new Easy0532();
    }
}