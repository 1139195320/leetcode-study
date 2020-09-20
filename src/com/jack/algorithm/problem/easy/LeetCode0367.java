package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0367 {

    public boolean isPerfectSquare(int num) {
        int i = 1;
        int tmp = 1;
        while (tmp > 0 && tmp < num) {
            i ++;
            tmp = i * i;
        }
        return tmp == num;
    }

    public boolean isPerfectSquare2(int num) {
        if (num < 2) {
            return true;
        }
        long x = num >> 1;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }

    public boolean isPerfectSquare3(int num) {
        int tmp = 1;
        while (num > 0) {
            num -= tmp;
            tmp += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        LeetCode0367 main = new LeetCode0367();
    }
}