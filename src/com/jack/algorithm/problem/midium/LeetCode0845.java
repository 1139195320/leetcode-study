package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0845 {

    public int longestMountain(int[] arr) {
        int minLen = 3;
        if (arr.length < minLen) {
            return 0;
        }
        int res = 0;
        // 0-递增，1-递减
        byte flag = 0;
        int pre = arr[0];
        int curRes = 1;
        // 是否有过递增
        boolean hasIncrement = false;
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            if (cur == pre) {
                // 断开，从 cur 开始
                hasIncrement = false;
                curRes = 1;
            } else if (cur > pre) {
                // 递增
                hasIncrement = true;
                if (flag == 1) {
                    // 前面是递减
                    curRes = 1;
                    flag = 0;
                }
                curRes++;
            } else {
                // 递减
                flag = 1;
                curRes++;
                if (hasIncrement) {
                    res = Math.max(res, curRes);
                }
            }
            pre = cur;
        }
        return res >= minLen ? res : 0;
    }

    public static void main(String[] args) {
        LeetCode0845 main = new LeetCode0845();
        System.out.println(main.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(main.longestMountain(new int[]{2, 2, 2}));
    }
}
