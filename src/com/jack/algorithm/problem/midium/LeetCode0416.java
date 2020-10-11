package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        res = false;
        visited = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, nums.length - 1, new ArrayList<>(), 0, sum >> 1);
        return res;
    }
    private boolean res;
    private Set<Integer> visited;
    private void dfs(int[] nums, int start, List<Integer> curList,
                     int preSum, int target) {
        if (visited.contains(preSum)) {
            return;
        }
        visited.add(preSum);
        if (preSum >= target || res) {
            // 此时和已经达到了一半
            if (preSum == target) {
                res = true;
            }
            return;
        }
        for (int i = start; i >= 0 && !res; i --) {
            int cur = nums[i];
            if (cur > target) {
                // 这个数比一半还大，说明不可能分出来
                return;
            }
            if (cur == target) {
                // 这个数刚好承担了一半
                res = true;
                return;
            }
            curList.add(cur);
            dfs(nums, i - 1, curList, preSum + cur, target);
            curList.remove(curList.size() - 1);
        }
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0;
        int maxNum = nums[0];
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int target = sum >> 1;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                // 因为 num 已存在
                // 所以和为 j 是否存在取决于和为 j - num 是否存在
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        LeetCode0416 main = new LeetCode0416();
        System.out.println(main.canPartition(
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100}
        ));
        System.out.println(main.canPartition(
                new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}
        ));
        System.out.println(main.canPartition(
                new int[]{1, 2, 3, 5}
        ));
    }
}