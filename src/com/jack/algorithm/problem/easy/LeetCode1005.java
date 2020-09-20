package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1005 {

    public int largestSumAfterKNegations(int[] A, int k) {
        Arrays.sort(A);
        int res = 0;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int cur = A[i];
            if (k > 0) {
                if (cur == 0) {
                    k = 0;
                } else if (cur < 0) {
                    // 看下一个数
                    if (A[i + 1] == 0) {
                        cur = -cur;
                        k = 0;
                    } else if (A[i + 1] < 0) {
                        cur = -cur;
                        k --;
                    } else {
                        // 当前数小于 0，下一个数大于 0
                        if ((k & 1) == 0) {
                            // 变换偶数次
                            // i 和 i + 1 之间必须有一个负
                            if (-cur > A[i + 1]) {
                                cur = -cur;
                                A[i + 1] = -A[i + 1];
                            }
                        } else {
                            cur = -cur;
                        }
                        k = 0;
                    }
                } else {
                    // 往后所有数都是正数
                    if ((k & 1) != 0) {
                        // 变换奇数次
                        cur = -cur;
                    }
                    k = 0;
                }
            }
            res += cur;
        }
        if ((k & 1) != 0) {
            A[n - 1] = - A[n - 1];
        }
        res += A[n - 1];
        return res;
    }

    public static void main(String[] args) {
        LeetCode1005 main = new LeetCode1005();
        System.out.println(main.largestSumAfterKNegations(
                new int[]{4, 2, 3}, 1
        ));
        System.out.println(main.largestSumAfterKNegations(
                new int[]{3, -1, 0, 2}, 3
        ));
        System.out.println(main.largestSumAfterKNegations(
                new int[]{2, -3, -1, 5, -4}, 2
        ));
    }
}