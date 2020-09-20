package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3) {
            return true;
        }
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Easy1502 main = new Easy1502();
    }
}