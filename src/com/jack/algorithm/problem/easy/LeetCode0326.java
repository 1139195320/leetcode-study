package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0326 {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }
        // 转换为 3 进制，1 开头，后面跟任意个 0
        return Integer.toString(n, 3)
                .matches("^10*$");
    }

    public boolean isPowerOfThree3(int n) {
        // 整数以内最大的 3 的 19 次幂
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        LeetCode0326 main = new LeetCode0326();
    }
}