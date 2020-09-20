package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1111 {

    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        if (n == 0) {
            return new int[] {};
        }
        char[] arr = seq.toCharArray();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                if (arr[i] == '(') {
                    // 偶数 (
                    res[i] = 0;
                } else {
                    // 偶数 )
                    res[i] = 1;
                }
            } else {
                if (arr[i] == '(') {
                    // 奇数 (
                    res[i] = 1;
                } else {
                    // 奇数 )
                    res[i] = 0;
                }
            }
        }
        return res;
    }

    public int[] maxDepthAfterSplit2(String seq) {
        int n = seq.length();
        if (n == 0) {
            return new int[] {};
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = i & 1;
            if (seq.charAt(i) == '(') {
                res[i] += tmp;
            } else {
                res[i] += (tmp ^ 1);
            }
        }
        return res;
    }
}
