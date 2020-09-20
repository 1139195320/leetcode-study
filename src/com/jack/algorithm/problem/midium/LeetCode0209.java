package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0209 {

    public int minSubArrayLen(int s, int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int i = 0;
        int j = 1;
        int n = nums.length;
        res = n;
        boolean find = false;
        while (j < n) {
            int curSum = nums[i];
            if (curSum >= s) {
                // 剪枝
                res = 1;
                find = true;
                break;
            }
            while (curSum < s && j < n) {
                curSum += nums[j ++];
            }
            if (curSum >= s) {
                res = Math.min(res, j - i);
                find = true;
            }
            i ++;
            j = i + 1;
        }
        return find ? res : 0;
    }

    public static void main(String[] args) {
        LeetCode0209 main = new LeetCode0209();
        System.out.println(main.minSubArrayLen(
                7, new int[]{2, 3, 1, 2, 4, 1, 1, 6}
        ));
    }
}