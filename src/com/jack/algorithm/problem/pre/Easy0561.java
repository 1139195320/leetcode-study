package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy0561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Easy0561 main = new Easy0561();
    }
}