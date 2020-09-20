package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy0922 {

    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int i = 0;
        int j = 1;
        boolean a = false, b = false;
        while (i < n && j < n) {
            if (!a) {
                if ((A[i] & 1) == 1) {
                    a = true;
                } else {
                    i += 2;
                }
            }
            if (!b) {
                if ((A[j] & 1) == 0) {
                    b = true;
                } else {
                    j += 2;
                }
            }
            if (a && b) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                a = false;
                b = false;
                i += 2;
                j += 2;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Easy0922 main = new Easy0922();
        System.out.println(Arrays.toString(main.sortArrayByParityII(
                new int[]{4, 2, 5, 7}
        )));
    }
}