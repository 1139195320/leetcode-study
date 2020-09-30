package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10503 {

    public int reverseBits(int num) {
        if (num == -1) {
            return 32;
        }
        String[] arr = Integer.toBinaryString(num).split("0");
        if (arr.length < 1) {
            return arr.length + 1;
        }
        int res = arr[0].length() + 1;
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i - 1].length() + arr[i].length() + 1);
        }
        return res;
    }
}
