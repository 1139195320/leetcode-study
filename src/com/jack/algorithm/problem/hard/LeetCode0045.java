package com.jack.algorithm.problem.hard;

/**
 * @author fy
 */
public class LeetCode0045 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 1;
        int lIndex = 0;
        int maxTo = lIndex + nums[0];
        while (maxTo < nums.length - 1) {
            step ++;
            int temp = maxTo;
            for (int i = lIndex + 1; i <= maxTo; i++) {
                temp = Math.max(temp, i + nums[i]);
            }
            if (temp == maxTo) {
                step = -1;
                break;
            }
            maxTo = temp;
        }
        return step;
    }

    public static void main(String[] args) {
        LeetCode0045 main = new LeetCode0045();
        System.out.println(main.jump(
                new int[]{2, 3, 1, 1, 4}));
        System.out.println(main.jump(
                new int[]{1, 2}));
        System.out.println(main.jump(
                new int[]{3, 4, 3, 2, 5, 4, 3}));
    }
}
