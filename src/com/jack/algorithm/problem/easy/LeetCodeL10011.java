package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCodeL10011 {

    public int expectNumber(int[] scores) {
        Arrays.sort(scores);
        int res = 1;
        int pre = scores[0];
        for (int i = 1; i < scores.length; i++) {
            int cur = scores[i];
            if (cur != pre) {
                res ++;
                pre = cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCodeL10011 main = new LeetCodeL10011();
        System.out.println(main.expectNumber(
                new int[]{1, 2, 3}
        ));
        System.out.println(main.expectNumber(
                new int[]{1, 1}
        ));
        System.out.println(main.expectNumber(
                new int[]{1, 1, 2}
        ));
    }
}