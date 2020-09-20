package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0091 {

    public int numDecodings(String s) {
        if ("0".equals(s)) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        if (s.charAt(0) != '0') {
            dp[0] = 1;
        }
        int i = 1;
        while (i < n) {
            int pre = s.charAt(i - 1) - '0';
            int cur = s.charAt(i) - '0';
            // 只能编码：1-26
            if (cur != 0) {
                dp[i] = dp[i - 1];
            }
            int num  = pre * 10 + cur;
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i] ++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
            i ++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        LeetCode0091 main = new LeetCode0091();
        System.out.println(main.numDecodings("12"));
        System.out.println(main.numDecodings("226"));
    }
}