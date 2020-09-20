package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0978 {

    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if (n < 3) {
            return n;
        }
        int res = 2;
        for (int i = 0; i < n; i++) {
            int j = i + 2;
            boolean flag = false;
            while (j < n
                    && ((A[j] - A[j - 1]) * (A[j - 1] - A[j - 2]) < 0)) {
                flag = true;
                j++;
            }
            if (flag) {
                res = Math.max(res, j - i);
            }
        }
        return res;
    }

    public int maxTurbulenceSize2(int[] A) {
        int n = A.length;
        int res = 1;
        int i = 0;
        for (int j = 1; j < n; j++) {
            int c = Integer.compare(A[j - 1], A[j]);
            if (j == n - 1 ||
                    c * Integer.compare(A[j], A[j + 1]) != -1) {
                // a-b b-c 同号，或者存在（a=b 或 b=c）
                if (c != 0) {
                    // a != b
                    res = Math.max(res, j - i + 1);
                }
                i = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0978 main = new Medium0978();
        System.out.println(main.maxTurbulenceSize(
                new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}
        ));
        System.out.println(main.maxTurbulenceSize(
                new int[]{4, 8, 12, 16}
        ));
        System.out.println(main.maxTurbulenceSize(
                new int[]{100}
        ));
        System.out.println(main.maxTurbulenceSize2(
                new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}
        ));
        System.out.println(main.maxTurbulenceSize2(
                new int[]{4, 8, 12, 16}
        ));
        System.out.println(main.maxTurbulenceSize2(
                new int[]{100}
        ));
    }
}