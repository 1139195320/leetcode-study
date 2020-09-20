package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0263 {

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        LeetCode0263 main = new LeetCode0263();
    }
}