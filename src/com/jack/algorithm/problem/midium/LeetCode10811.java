package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author fy
 */
public class LeetCode10811 {

    public int waysToChange(int n) {
        int [] res = new int[n + 1];
        Arrays.fill(res, 1);
        int[] coins = new int[]{1, 5, 10, 25};
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    res[j] = (res[j] + res[j - coins[i]]) % 1000000007;
                }
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        LeetCode10811 main = new LeetCode10811();
        System.out.println(main.waysToChange(5));
        System.out.println(main.waysToChange(10));
        System.out.println(main.waysToChange(25));
        System.out.println(main.waysToChange(30));
    }
}
