package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0009 {

    public boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        if (num < 10) {
            return true;
        }
        int tmp = num;
        int len = 0;
        int divisor = 1;
        while (tmp > 0) {
            len ++;
            divisor *= 10;
            tmp /= 10;
        }
        divisor /= 10;
        int mul = 1;
        // 左右各多少位，进行比较
        int mLen = len >> 1;
        for (int i = 0; i < mLen; i++) {
            mul *= 10;
        }
        int left = num / mul;
        if (len % 2 != 0) {
            // 奇数位，忽略正中间的数字
            left /= 10;
            divisor /= 10;
        }
        int right = 0;
        mul /= 10;
        while (mLen > 0) {
            right += (num % 10) * mul;
            num /= 10;
            mul /= 10;
            mLen --;
        }
        return left == right;
    }

    public boolean isPalindrome2(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        if (num < 10) {
            return true;
        }
        int reverseNum = 0;
        while (num > reverseNum) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        return num == reverseNum || num == reverseNum / 10;
    }

    public static void main(String[] args) {
        LeetCode0009 main = new LeetCode0009();
        System.out.println(main.isPalindrome(9999));
        System.out.println(main.isPalindrome(121));
        System.out.println(main.isPalindrome(-121));
        System.out.println(main.isPalindrome(10));
        System.out.println(main.isPalindrome(1001));
        System.out.println(main.isPalindrome(102301));
    }
}