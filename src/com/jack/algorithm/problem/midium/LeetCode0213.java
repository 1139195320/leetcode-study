package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int preMax = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        int preMax2 = 0;
        int curMax2 = 0;
        for (int i = 1; i < nums.length; i ++) {
            int temp = curMax2;
            curMax2 = Math.max(preMax2 + nums[i], curMax2);
            preMax2 = temp;
        }
        return Math.max(curMax, curMax2);
    }

    public static void main(String[] args) {
        LeetCode0213 main = new LeetCode0213();
        System.out.println(main.rob(new int[]{2, 3, 2}));
        System.out.println(main.rob(new int[]{1, 2, 3, 1}));
    }

}
