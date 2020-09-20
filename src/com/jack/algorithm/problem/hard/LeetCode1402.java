package com.jack.algorithm.problem.hard;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1402 {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        if (n == 0 || satisfaction[n - 1] <= 0) {
            return 0;
        }
        int pre = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = pre + satisfaction[i];
            if (cur < 0) {
                break;
            }
            res += cur;
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1402 main = new LeetCode1402();
        System.out.println(main.maxSatisfaction(
                new int[]{-1, -8, 0, 5, -9}
        ));
        System.out.println(main.maxSatisfaction(
                new int[]{4, 3, 2}
        ));
    }
}