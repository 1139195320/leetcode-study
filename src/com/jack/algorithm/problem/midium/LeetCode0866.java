package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0866 {

    public int primePalindrome(int n) {
        while (true) {
            if (reverse(n) == n && isPrime(n)) {
                return n;
            }
            n ++;
            if (n >= 10_000_000 && n < 100_000_000) {
                n = 100_000_001;
            }
        }
    }
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int r = (int) Math.sqrt(n);
        for (int i = 2; i <= r; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
}
