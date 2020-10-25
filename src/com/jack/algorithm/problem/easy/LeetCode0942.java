package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0942 {

    public int[] diStringMatch(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] res = new int[n + 1];
        int l = 0, r = n;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == 'I') {
                res[i] = l ++;
            } else {
                res[i] = r --;
            }
        }
        res[n] = l;
        return res;
    }
}
