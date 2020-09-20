package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0050 {

    public double myPow(double x, int n) {
        return n >= 0 ? doPow(x, (long) n) : (1 / doPow(x, -(long) n));
    }
    private double doPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = doPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
    private double doPow2(double x, long n) {
        double res = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            // 逐次 x²
            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0050 main = new LeetCode0050();
        System.out.println(main.myPow(2.0, 10));
        System.out.println(main.myPow(2.0, -2));
        System.out.println(main.myPow(2.0, -2147483648));
    }
}
