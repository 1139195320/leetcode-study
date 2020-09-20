package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode11606 {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        long res = Integer.MAX_VALUE;
        int lenA = a.length;
        int lenB = b.length;
        while (i < lenA && j < lenB) {
            int curA = a[i];
            int curB = b[j];
            long diff = curA - curB;
            if (diff == 0) {
                return 0;
            }
            else if (diff > 0) {
                res = Math.min(res, diff);
                j ++;
                while (j < lenB && b[j] == curB) {
                    j ++;
                }
            }
            else {
                res = Math.min(res, -diff);
                i ++;
                while (i < lenA && a[i] == curA) {
                    i ++;
                }
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        LeetCode11606 main = new LeetCode11606();
        System.out.println(main.smallestDifference(
                new int[] {1, 3, 15, 11, 2},
                new int[] {23, 127, 235, 19, 8}
        ));
        System.out.println(main.smallestDifference(
                new int[]{-2147483648, 1},
                new int[]{2147483647, 0}
        ));
    }
}