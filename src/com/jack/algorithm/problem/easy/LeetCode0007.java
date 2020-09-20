package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0007 {

    public int reverse(int x) {
        // 是否是正数
        boolean flag = true;
        if (x < 0) {
            flag = false;
            x = - x;
        }
        long MAX = Integer.MAX_VALUE;
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (flag) {
            if (res > MAX) {
                res = 0;
            }
        } else {
            if (res > MAX + 1) {
                res = 0;
            } else {
                res = - res;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        LeetCode0007 main = new LeetCode0007();
        System.out.println(main.reverse(123));
        System.out.println(main.reverse(-123));
        System.out.println(main.reverse(120));
        System.out.println(main.reverse(0));
        System.out.println(main.reverse(-0));
    }
}