package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        return doCanIWin(maxChoosableInteger, desiredTotal,
                new boolean[maxChoosableInteger + 1], true, 0);
    }
    private boolean doCanIWin(int maxChoosableInteger, int desiredTotal,
                              boolean[] visited, boolean isA, int pre) {
        boolean flag = !isA;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (pre + i >= desiredTotal) {
                // 当前 player win
                return isA;
            }
            if (isA) {
                flag |= doCanIWin(maxChoosableInteger, desiredTotal,
                        visited, false, pre + i);
            } else {
                flag &= doCanIWin(maxChoosableInteger, desiredTotal,
                        visited, true, pre + i);
            }
            visited[i] = false;
        }
        return flag;
    }



    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (desiredTotal > maxChoosableInteger + 1
                && desiredTotal <= maxChoosableInteger * 2) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, desiredTotal,
                0, new Boolean[1 << maxChoosableInteger]);
    }
    private boolean dfs(int maxChoosableInteger, int desiredTotal,
                        int state, Boolean[] dp) {
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = maxChoosableInteger; i >= 1; i --) {
            int tmp = 1 << (i - 1);
            if ((tmp & state) == 0) {
                // 当前选了赢了，或下一个玩家选了输了
                if (desiredTotal - i <= 0
                        || !dfs(maxChoosableInteger, desiredTotal - i,
                        state | tmp, dp)) {
                    dp[state] = true;
                    return true;
                }
            }
        }
        dp[state] = false;
        return false;
    }

    public static void main(String[] args) {
        LeetCode0464 main = new LeetCode0464();
        System.out.println(main.canIWin(10, 11));
        System.out.println(main.canIWin(10, 3));
        System.out.println(main.canIWin(5, 10));
        System.out.println(main.canIWin2(10, 11));
        System.out.println(main.canIWin2(10, 3));
        System.out.println(main.canIWin2(5, 10));
    }
}