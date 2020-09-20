package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode1403 {

    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            return Collections.singletonList(nums[0]);
        }
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }
        int curSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = nums[i];
            curSum += cur;
            list.add(cur);
            if (curSum > (sum >> 1)) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode1403 main = new LeetCode1403();
        System.out.println(main.minSubsequence(
                new int[]{4, 3, 10, 9, 8}
        ));
        System.out.println(main.minSubsequence(
                new int[]{4, 4, 7, 6, 7}
        ));
    }
}