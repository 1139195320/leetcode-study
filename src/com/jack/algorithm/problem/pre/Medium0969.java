package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0969 {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        if (n < 2) {
            return res;
        }
        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return res;
        }
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = getMaxIndex(A, i);
            if (maxIndex == i) {
                continue;
            }
            // 翻转前 maxIndex
            res.add(maxIndex);
            // 翻转前 i
            res.add(i);
            int[] B = new int[i + 1];
            int k = 0;
            for (int j = i; j > maxIndex; j --) {
                B[k ++] = A[j];
            }
            for (int j = 0; j <= maxIndex; j++) {
                B[k ++] = A[j];
            }
            A = B;
        }
        return res;
    }
    private int getMaxIndex(int[] arr, int r) {
        int maxVal = arr[0];
        int maxIndex = 0;
        for (int i = 1; i <= r; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Medium0969 main = new Medium0969();
        System.out.println(main.pancakeSort(
                new int[] {2, 4, 5, 6, 3, 1}
        ));
        System.out.println(main.pancakeSort(
                new int[] {1, 2, 3}
        ));
    }
}