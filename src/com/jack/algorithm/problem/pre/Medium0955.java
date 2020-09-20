package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0955 {

    public int minDeletionSize(String[] A) {
        int n = A.length;
        int len = A[0].length();
        int res = 0;
        String[] cur = new String[n];
        for (int j = 0; j < len; ++j) {
            String[] tmp = Arrays.copyOf(cur, n);
            for (int i = 0; i < n; ++i) {
                tmp[i] += A[i].charAt(j);
            }
            if (isSorted(tmp)) {
                // 保留第 j 列后仍有序，则保留
                cur = tmp;
            } else {
                // 第 j 列需删除
                res++;
            }
        }
        return res;
    }
    private boolean isSorted(String[] arr) {
        // 校验是否升序
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                // 有一个前面的比后面的大
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Medium0955 main = new Medium0955();
        // 1
        System.out.println(main.minDeletionSize(
                new String[] {"ca","bb","ac"}
        ));
        // 0
        System.out.println(main.minDeletionSize(
                new String[] {"xc","yb","za"}
        ));
        // 3
        System.out.println(main.minDeletionSize(
                new String[] {"zyx","wvu","tsr"}
        ));
    }
}