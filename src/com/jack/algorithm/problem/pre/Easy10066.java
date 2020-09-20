package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy10066 {

    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n < 2) {
            return a;
        }
        int[] arrL = new int[n];
        int[] arrR = new int[n];
        int[] res = new int[n];
        arrL[0] = a[0];
        arrR[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++) {
            arrL[i] = arrL[i - 1] * a[i];
        }
        for (int i = n - 2; i >= 0; i --) {
            arrR[i] = arrR[i + 1] * a[i];
        }
        res[0] = arrR[1];
        res[n - 1] = arrL[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = arrL[i - 1] * arrR[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        Easy10066 main = new Easy10066();
        System.out.println(Arrays.toString(main.constructArr(
                new int[]{1, 2, 3, 4, 5}
        )));
    }
}