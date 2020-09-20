package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        res = false;
        Arrays.sort(nums);
        dfs(nums, nums.length - 1, new ArrayList<>(), 0, sum / 2);
        return res;
    }
    private boolean res;
    private void dfs(int[] nums, int start, List<Integer> curList,
                     int preSum, int target) {
        if (preSum >= target || res) {
            if (preSum == target) {
                res = true;
            }
            return;
        }
        for (int i = start; i >= 0 && !res; i --) {
            int cur = nums[i];
            if (cur > target) {
                return;
            }
            if (cur == target) {
                res = true;
                return;
            }
            curList.add(cur);
            dfs(nums, i - 1, curList, preSum + cur, target);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0416 main = new LeetCode0416();
        System.out.println(main.canPartition(
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100}
        ));
        System.out.println(main.canPartition(
                new int[]{1, 2, 3, 5}
        ));
    }
}