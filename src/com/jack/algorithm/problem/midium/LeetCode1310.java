package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = pre[query[0]] ^ pre[query[1] + 1];
        }
        return res;
    }
}
