package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11616 {

    public int[] subSort(int[] array) {
        int n = array.length;
        if (n < 3) {
            return new int[] {-1, -1};
        }
        int l = -1, r = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur1 = array[i];
            if (cur1 < max) {
                r = i;
            } else {
                max = Math.max(max, cur1);
            }
            int cur2 = array[n - 1 - i];
            if (cur2 > min) {
                l = n - 1 - i;
            } else {
                min = Math.min(min, cur2);
            }
        }
        return new int[] {l, r};
    }

    public static void main(String[] args) {
        Medium11616 main = new Medium11616();
        System.out.println(Arrays.toString(main.subSort(
                new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}
        )));
    }
}