package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0910 {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(A[i] + K, A[n - 1] - K);
            int min = Math.min(A[0] + K, A[i + 1] - K);
            res = Math.min(res, max - min);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0910 main = new Medium0910();
        System.out.println(main.smallestRangeII(
                new int[] {0, 10}, 2
        ));
        System.out.println(main.smallestRangeII(
                new int[] {1, 3, 6}, 3
        ));
    }
}