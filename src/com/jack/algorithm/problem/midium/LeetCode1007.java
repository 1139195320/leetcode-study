package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1007 {

    public int minDominoRotations(int[] A, int[] B) {
        int res = -1;
        int n = A.length;
        int a = A[0];
        int b = B[0];
        if (a != b) {
            int aCount = find(A, B, a);
            int bCount = find(A, B, b);
            res = Math.min(aCount, bCount);
        } else {
            res = find(A, B, a);
        }
        return res > n ? -1 : res;
    }
    private int find(int[] A, int[] B, int target) {
        int n = A.length;
        // 如果让上面的成需要交换的次数
        int countUp = 0;
        // 如果让下面的成需要交换的次数
        int countDown = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != target && B[i] != target) {
                // 上下都不是 target
                return n + 1;
            }
            if (A[i] == target && B[i] == target) {
                // 上下都是 target，不需要交换
                continue;
            }
            if (A[i] == target) {
                // 上面是 target
                countDown ++;
            } else {
                // 下面是 target
                countUp ++;
            }
        }
        return Math.min(countUp, countDown);
    }
}
