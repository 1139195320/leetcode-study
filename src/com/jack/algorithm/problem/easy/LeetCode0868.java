package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0868 {

    public int binaryGap(int n) {
        int res = 0;
        String s = Integer.toBinaryString(n);
        int pre = -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                if (pre != -1) {
                    res = Math.max(res, i - pre);
                }
                pre = i;
            }
        }
        return res;
    }

    public int binaryGap2(int n) {
        int res = 0;
        int i = 0;
        int pre = -1;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (pre != -1) {
                    res = Math.max(res, i - pre);
                }
                pre = i;
            }
            i ++;
            n >>= 1;
        }
        return res;
    }
}
