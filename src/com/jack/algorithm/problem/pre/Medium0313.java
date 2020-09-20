package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int k = primes.length;
        dp[0] = 1;
        int[] index = new int[k];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            List<Integer> tIndexList = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int cur = dp[index[j]] * primes[j];
                if (cur < min) {
                    tIndexList.clear();
                    tIndexList.add(j);
                    min = cur;
                } else if (cur == min) {
                    tIndexList.add(j);
                }
            }
            dp[i] = min;
            for (int tIndex : tIndexList) {
                index[tIndex] ++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Medium0313 main = new Medium0313();
        System.out.println(main.nthSuperUglyNumber(12,
                new int[]{2, 7, 13, 19}));
    }
}