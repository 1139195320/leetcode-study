package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count ++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        return Math.max(res, count);
    }

    public static void main(String[] args) {
        Easy0485 main = new Easy0485();
    }
}