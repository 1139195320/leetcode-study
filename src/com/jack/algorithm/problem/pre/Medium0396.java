package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0396 {

    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int pre = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = A[i];
            sum += cur;
            pre += cur * i;
        }
        int res = pre;
        for (int i = n - 1; i >= 0; i--) {
            pre = pre + sum - A[i] * n;
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0396 main = new Medium0396();
        System.out.println(main.maxRotateFunction(
                new int[] {4, 3, 2, 6}
        ));
    }
}