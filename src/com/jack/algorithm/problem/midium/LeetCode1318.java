package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1318 {

    private int n;
    public int minFlips(int a, int b, int c) {
        char[] arrA = Integer.toBinaryString(a).toCharArray();
        char[] arrB = Integer.toBinaryString(b).toCharArray();
        char[] arrC = Integer.toBinaryString(c).toCharArray();
        char[] arrRes = Integer.toBinaryString(a | b).toCharArray();
        n = Math.max(arrRes.length, arrC.length);
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c1 = get(arrRes, i);
            char c2 = get(arrC, i);
            if (c1 == c2) {
                continue;
            }
            if (c1 == '0') {
                // 原来的两个都是 0
                // 需把一个变成 1
                res ++;
            } else {
                // 原来的两个如果是 1 需都变成 0
                if (get(arrA, i) == '1') {
                    res ++;
                }
                if (get(arrB, i) == '1') {
                    res ++;
                }
            }
        }
        return res;
    }
    private char get(char[] arr, int pos) {
        int realPos = arr.length - n + pos;
        if (realPos < 0) {
            return '0';
        }
        return arr[realPos];
    }


    public int minFlips2(int a, int b, int c) {
        int res = 0;
        int max = 31;
        for (int i = 0; i < max; i++) {
            int curA = (a >> i) & 1;
            int curB = (b >> i) & 1;
            int curC = (c >> i) & 1;
            int cur = curA | curB;
            if (cur == curC) {
                continue;
            }
            if (cur == 0) {
                // 原来的两个都是 0
                // 需把一个变成 1
                res ++;
            } else {
                // 原来的两个如果是 1 需都变成 0
                res += curA + curB;
            }
        }
        return res;
    }
}
