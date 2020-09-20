package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0877 {

    public boolean stoneGame(int[] piles) {
        for (int pile : piles) {
            sum += pile;
        }
        return doStoneGame(piles, 0, piles.length - 1,
                true, 0, 0);
    }
    private int sum;
    private boolean doStoneGame(int[] piles, int l, int r,
                                boolean isA, int preA, int preB) {
        if (l >= r) {
            return preA > preB;
        }
        if (preA > sum / 2) {
            return true;
        }
        if (preB > sum / 2) {
            return false;
        }
        if (isA) {
            return doStoneGame(piles, l + 1, r,
                    false, preA + piles[l], preB)
                    || doStoneGame(piles, l, r - 1,
                    false, preA + piles[r], preB);
        } else {
            return doStoneGame(piles, l + 1, r,
                    true, preA, preB + piles[l])
                    && doStoneGame(piles, l, r - 1,
                    true, preA, preB + piles[r]);
        }
    }

    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int size = 1; size <= n; size++) {
            for (int i = 0; i + size <= n; i++) {
                int j = i + size - 1;
                if ((i + j + n) % 2 == 1) {
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1],
                            piles[j] + dp[i + 1][j]);
                } else {
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1],
                            -piles[j] + dp[i + 1][j]);
                }
            }
        }
        return dp[1][n] > 0;
    }
    public boolean stoneGame3(int[] piles) {
        return true;
    }

    public static void main(String[] args) {
        Medium0877 main = new Medium0877();
        System.out.println(main.stoneGame(
                new int[]{5, 3, 4, 5}
        ));
        System.out.println(main.stoneGame2(
                new int[]{5, 3, 4, 5}
        ));
    }
}