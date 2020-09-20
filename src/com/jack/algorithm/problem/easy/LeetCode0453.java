package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0453 {

    public int minMoves(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            count += (num - min);
        }
        return count;
    }

    public int minMoves2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = moves + nums[i] - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;
    }

    public int minMoves3(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode0453 main = new LeetCode0453();
        System.out.println(main.minMoves(
                new int[] {1, 2, 3}
        ));
        System.out.println(main.minMoves2(
                new int[] {1, 2, 3}
        ));
    }
}