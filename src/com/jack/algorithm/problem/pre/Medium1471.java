package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1471 {

    public int[] getStrongest(int[] arr, int k) {
        if (k == 0) {
            return new int[] {};
        }
        int[] res = new int[k];
        Arrays.sort(arr);
        // 中位数
        int mid;
        int n = arr.length;
        if (n % 2 == 0) {
            mid = arr[n / 2 - 1];
        } else {
            mid = arr[n >> 1];
        }
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp, (a, b) -> {
            int diff = Math.abs(b - mid) - Math.abs(a - mid);
            if (diff != 0) {
                return diff;
            }
            return b - a;
        });
        for (int i = 0; i < k; i++) {
            res[i] = tmp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1471 main = new Medium1471();
        System.out.println(Arrays.toString(main.getStrongest(
                new int[]{1, 2, 3, 4, 5}, 2
        )));
        System.out.println(Arrays.toString(main.getStrongest(
                new int[]{1, 1, 3, 5, 5}, 2
        )));
        System.out.println(Arrays.toString(main.getStrongest(
                new int[]{6, 7, 11, 7, 6, 8}, 5
        )));
        System.out.println(Arrays.toString(main.getStrongest(
                new int[]{6, -3, 7, 2, 11}, 3
        )));
    }
}