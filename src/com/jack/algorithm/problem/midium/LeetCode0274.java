package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0274 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        Arrays.sort(citations);
        if (n <= citations[0]) {
            return n;
        }
        for (int i = n - 1; i > 0; i--) {
            int c = n - i;
            if (c <= citations[i] && c >= citations[i - 1]) {
                return c;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        Arrays.sort(citations);
        if (n <= citations[0]) {
            return n;
        }
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            j ++;
            if (j > citations[i]) {
                return j - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode0274 main = new LeetCode0274();
        System.out.println(main.hIndex(
                new int[]{3, 0, 6, 1, 5}
        ));
    }
}