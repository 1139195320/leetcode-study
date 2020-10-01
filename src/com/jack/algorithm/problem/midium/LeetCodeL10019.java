package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCodeL10019 {

    public int minimumOperations(String leaves) {
        char[] arr = leaves.toCharArray();
        int n = arr.length;
        int min = 3;
        if (n < min) {
            return 0;
        }
        int[][] dp = new int[n][3];
        // 0-rrr... 1-rry... 2-ryr...
        dp[0][0] = arr[0] == 'r' ? 0 : 1;
        // 不可能达到的状态置为最大
        dp[0][1] = n;
        dp[0][2] = n;
        for (int i = 1; i < n; i++) {
            char c = arr[i];
            if (c == 'r') {
                // 当前是 r
                // 要达到 rrr，必须前面是 rr，此时是 r
                dp[i][0] = dp[i - 1][0];
                // 要达到 rry，前面是 rr 或 ry，此时是 y
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                // 要达到 ryr，前面是 ry 或 ryr，此时是 r
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]);
            } else {
                // 当前是 y
                // 要达到 rrr，必须前面是 rr，此时是 r
                dp[i][0] = dp[i - 1][0] + 1;
                // 要达到 rry，前面是 rr 或 ry，此时是 y
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                // 要达到 ryr，前面是 ry 或 ryr，此时是 r
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + 1;
            }
        }
        return dp[n - 1][2];
    }

    public int minimumOperations2(String leaves) {
        int n = leaves.length();
        int g = leaves.charAt(0) == 'y' ? 1 : -1;
        int gMin = g;
        int res = n;
        for (int i = 1; i < n; ++i) {
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            g += 2 * isYellow - 1;
            if (i != n - 1) {
                res = Math.min(res, gMin - g);
            }
            gMin = Math.min(gMin, g);
        }
        return res + (g + n) / 2;
    }

    public static void main(String[] args) {
        LeetCodeL10019 main = new LeetCodeL10019();
        System.out.println(main.minimumOperations("ryr"));
        // 2
        System.out.println(main.minimumOperations("rrryyyrryyyrr"));
        // 3
        System.out.println(main.minimumOperations("rryyryrryyyrr"));
        // 7
        System.out.println(main.minimumOperations("rryyryrryyyrryrrryyyyr"));
    }
}
