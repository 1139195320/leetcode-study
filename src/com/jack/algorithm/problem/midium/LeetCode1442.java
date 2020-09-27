package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1442 {

    public int countTriplets(int[] arr) {
        int res = 0;
        int n = arr.length;
        int[] preArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preArr[i] = preArr[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int a = preArr[i] ^ preArr[j];
                    int b = preArr[j] ^ preArr[k + 1];
                    if (a == b) {
                        res ++;
                    }
                }
            }
        }
        return res;
    }

    public int countTriplets2(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int a = 0;
            for (int j = i; j < n; j++) {
                a ^= arr[j];
                int b = 0;
                for (int k = j + 1; k < n; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int countTriplets3(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            for (int k = i + 1; k < n; k++) {
                tmp ^= arr[k];
                if (tmp == 0) {
                    res += k - i;
                }
            }
        }
        return res;
    }
}
