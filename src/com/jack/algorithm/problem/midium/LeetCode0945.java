package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0945 {

    public int minIncrementForUnique(int[] A) {
        int n = A.length;
        if (n < 2) {
            return 0;
        }
        int res = 0;
        Arrays.sort(A);
        int pre = A[0];
        for (int i = 1; i < n; i++) {
            int cur = A[i];
            if (cur <= pre) {
                res += (pre - cur + 1);
                cur = pre + 1;
            }
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0945 main = new LeetCode0945();
        System.out.println(main.minIncrementForUnique(
                new int[]{1, 2, 2}
        ));
        System.out.println(main.minIncrementForUnique(
                new int[]{3, 2, 1, 2, 1, 7}
        ));
    }
}