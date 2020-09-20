package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11611 {

    public int[] divingBoard(int shorter, int longer, int k) {
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }

    public static void main(String[] args) {
        Medium11611 main = new Medium11611();
        System.out.println(Arrays.toString(
                main.divingBoard(1, 2, 3)
        ));
    }
}