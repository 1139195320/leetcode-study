package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode11611 {

    public int[] divingBoard(int shorted, int longer, int k) {
        if (k == 0) {
            return new int[] {};
        }
        if (shorted == longer) {
            return new int[] {shorted * k};
        }
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorted * (k - i) + longer * i;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode11611 main = new LeetCode11611();
        System.out.println(Arrays.toString(
                main.divingBoard(1, 2, 3)
        ));
    }
}