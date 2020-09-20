package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11621 {

    public int[] findSwapValues(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return new int[] {};
        }
        int sum1 = 0, sum2 = 0;
        for (int data : array1) {
            sum1 += data;
        }
        for (int data : array2) {
            sum2 += data;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        int diff = sum2 - sum1;
        if (diff % 2 != 0) {
            return new int[] {};
        }
        diff >>= 1;
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            int r = array2[j];
            int l = array1[i];
            if (r - l == diff) {
                return new int[] {l, r};
            } else if (r - l > diff) {
                i ++;
            } else {
                j ++;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Medium11621 main = new Medium11621();
        System.out.println(Arrays.toString(main.findSwapValues(
                new int[]{4, 1, 2, 1, 1, 2},
                new int[]{3, 6, 3, 3}
        )));
    }
}