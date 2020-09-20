package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy0976 {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for (int i = n - 3; i >= 0; i--) {
            int c = A[i + 2];
            int a = A[i + 1];
            int b = A[i];
            if (c < a + b) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Easy0976 main = new Easy0976();
        System.out.println(main.largestPerimeter(
                new int[]{3, 2, 3, 4}
        ));
        System.out.println(main.largestPerimeter(
                new int[]{3, 6, 2, 3}
        ));
    }
}
