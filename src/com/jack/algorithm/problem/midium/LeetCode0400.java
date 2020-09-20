package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0400 {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        // 区间 l 到 r
        int l = 0;
        int r = 0;
        // len 位数
        int len = 1;
        while (n > r) {
            if (r + len * 9 * Math.pow(10, len - 1) >= n) {
                break;
            }
            r += 9 * Math.pow(10, len - 1);
            l += len * 9 * Math.pow(10, len - 1);
            len ++;
        }
        // 在 l 靠右多少个位置
        int pos = n - l;
        // 在 l 后面第几个 len 位数
        int k = pos / len;
        int mod = pos % len;
        if (mod == 0) {
            return k % 10 == 0 ? 9 : k % 10 - 1;
        }
        int num = 1;
        while (len > 1) {
            num *= 10;
            len --;
        }
        num += k;
        return String.valueOf(num).charAt(mod - 1) - '0';
    }

    public static void main(String[] args) {
        LeetCode0400 main = new LeetCode0400();
        System.out.println(main.findNthDigit(2147483647));
        System.out.println(main.findNthDigit(1000000000));
        System.out.println(main.findNthDigit(3));
        System.out.println(main.findNthDigit(11));
        System.out.println(main.findNthDigit(29));
        System.out.println(main.findNthDigit(30));
        System.out.println(main.findNthDigit(31));
        System.out.println(main.findNthDigit(32));
        System.out.println(main.findNthDigit(33));
    }
}