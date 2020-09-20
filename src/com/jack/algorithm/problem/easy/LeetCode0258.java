package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0258 {

    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            int tmp = num;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        LeetCode0258 main = new LeetCode0258();
        System.out.println(main.addDigits(123));
        System.out.println(main.addDigits(69));
    }
}