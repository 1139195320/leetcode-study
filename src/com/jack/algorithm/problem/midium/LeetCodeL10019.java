package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCodeL10019 {

    public int minimumOperations(String leaves) {
        int res = 0;
        char[] arr = leaves.toCharArray();
        int len = arr.length;
        int min = 3;
        char[] base = {'r', 'y'};
        if (len < min) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        // 保证第一个肯定是 r
        if (arr[0] != base[0]) {
            res ++;
            arr[0] = base[0];
        }
        // 初始 tmp 为 r
        int tmp = 0;
        int curCount = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == base[tmp]) {
                curCount ++;
            } else {
                list.add(curCount);
                tmp ^= 1;
                curCount = 1;
            }
            if (i == len - 1) {
                list.add(curCount);
            }
        }
        int n = list.size();
        int[][] dp = new int[n][3];
        // 0-rrr... 1-rry... 2-ryr...
        for (int i = 1; i < n; i++) {
            int cur = list.get(i);
            if ((i & 1) == 0) {
                // 当前是 r
                // 要达到 rrr，必须前面是 rr，此时是 r
                dp[i][0] = dp[i - 1][0];
                // 要达到 rry，前面是 rr 或 ry，此时是 y
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cur;
                // 要达到 ryr，前面是 ry 或 ryr，此时是 r
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]);
            } else {
                // 当前是 y
                // 要达到 rrr，必须前面是 rr，此时是 r
                dp[i][0] = dp[i - 1][0] + cur;
                // 要达到 rry，前面是 rr 或 ry，此时是 y
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                // 要达到 ryr，前面是 ry 或 ryr，此时是 r
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cur;
            }
        }
        return res + dp[n - 1][2];
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
