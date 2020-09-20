package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0338 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0338 main = new LeetCode0338();
        System.out.println(Arrays.toString(main.countBits(5)));
        System.out.println(Arrays.toString(main.countBits2(5)));
    }
}