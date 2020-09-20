package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy11001 {

    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(B, 0, A, 0, n);
            return;
        }
        System.arraycopy(A, 0, A, n, m);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (A[n + i] < B[j]) {
                    A[k] = A[n + i];
                    i ++;
                } else {
                    A[k] = B[j];
                    j ++;
                }
            }
            if (i < m) {
                A[k] = A[n + i];
                i ++;
            } else {
                A[k] = B[j];
                j ++;
            }
        }
    }
}
