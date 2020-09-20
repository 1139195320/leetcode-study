package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n >>= 1;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n < 1) {
            return false;
        }
        return Integer.toBinaryString(n).matches("^10*$");
    }

    public boolean isPowerOfTwo3(int n) {
        if (n < 1) {
            return false;
        }
        return 1073741824 % n == 0;
    }

    public static void main(String[] args) {
        LeetCode0231 main = new LeetCode0231();
        System.out.println(main.isPowerOfTwo(4));
        System.out.println(main.isPowerOfTwo(5));
        System.out.println(main.isPowerOfTwo2(4));
        System.out.println(main.isPowerOfTwo2(5));
        System.out.println(main.isPowerOfTwo3(4));
        System.out.println(main.isPowerOfTwo3(5));
    }
}