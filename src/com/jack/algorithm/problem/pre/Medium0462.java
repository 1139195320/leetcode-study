package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0462 {

    public int minMoves2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int mid;
        if (n % 2 == 0) {
            mid = (nums[n / 2] + nums[n / 2 - 1]) / 2;
        } else {
            mid = nums[n / 2];
        }
        for (int num : nums) {
            count += Math.abs(num - mid);
        }
        return count;
    }

    public static void main(String[] args) {
        Medium0462 main = new Medium0462();
        System.out.println(main.minMoves2(
                new int[] {1, 2, 3}
        ));
        System.out.println(main.minMoves2(
                new int[] {1, 2, 3, 100}
        ));
    }
}