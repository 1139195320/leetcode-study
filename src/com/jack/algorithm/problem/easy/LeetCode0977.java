package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0977 {

    public int[] sortedSquares(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i] * arr[i];
        }
        Arrays.sort(tmp);
        return tmp;
    }
}
