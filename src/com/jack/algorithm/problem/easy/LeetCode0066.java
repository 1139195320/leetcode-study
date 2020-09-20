package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0066 {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            } else {
                digits[i] = 0;
                i --;
            }
        }
        if (i < 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
