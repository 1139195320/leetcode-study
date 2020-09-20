package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0190 {

    public int reverseBits(int n) {
        // you need treat n as an unsigned value
        String src = Integer.toBinaryString(n);
        int len = 32;
        int[] destArr = new int[len];
        for (int i = 0; i < src.length(); i++) {
            destArr[i] = src.charAt(src.length() - 1 - i) - '0';
        }
        // 是否是正数
        boolean right = destArr[0] == 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (!right) {
                destArr[i] ^= 1;
            }
            if (destArr[i] == 1) {
                res += (1 << (len - i - 1));
            }
        }
        return right ? res : - res - 1;
    }

    public static void main(String[] args) {
        LeetCode0190 main = new LeetCode0190();
        // 10111111111111111111111111111111
        System.out.println(main.reverseBits(-3));
    }

}