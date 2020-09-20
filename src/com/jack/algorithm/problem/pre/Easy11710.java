package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy11710 {

    public int majorityElement(int[] nums) {
        // 候选人 及其数量
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (cur == candidate) {
                // 得一票
                count ++;
            } else {
                if (count == 0) {
                    // 候选人更新
                    candidate = cur;
                    count = 1;
                } else {
                    count --;
                }
            }
        }
        return count > 0 ? candidate : -1;
    }

    public static void main(String[] args) {
        Easy11710 main = new Easy11710();
        System.out.println(main.majorityElement(
                new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}
        ));
        System.out.println(main.majorityElement(
                new int[]{2, 2, 1, 1, 1, 2, 2}
        ));
    }
}