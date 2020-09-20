package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy11716 {

    public int massage(int[] nums) {
        int cur = nums[0];
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(pre, cur);
            cur = pre + nums[i];
            pre = tmp;
        }
        return Math.max(pre, cur);
    }

    public static void main(String[] args) {
        Easy11716 main = new Easy11716();
        System.out.println(main.massage(
                new int[]{1, 2, 3, 1}
        ));
        System.out.println(main.massage(
                new int[]{2, 7, 9, 3, 1}
        ));
        System.out.println(main.massage(
                new int[]{2, 1, 4, 5, 3, 1, 1, 3}
        ));
    }
}