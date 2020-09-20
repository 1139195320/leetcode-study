package com.jack.algorithm.problem.pre;

/**
 * @author jack
 *
 */
public class Hard0879 {

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        count = 0;
        dfs(G, P, group, profit, 0);
        return count;
    }
    private int count;
    private void dfs(int g, int target, int[] group, int[] profit, int start) {
        if (target <= 0) {
            count ++;
        }
        if (start == group.length && target > 0) {
            return;
        }
        for (int i = start; i < group.length; i++) {
            dfs(g - group[i], target - profit[i],
                    group, profit, i + 1);
        }
    }

    public int profitableSchemes2(int G, int P, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        // dp[i][j]：i 个人，j 的利润
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            int g = group[i];
            int salary = profit[i];
            for (int j = P; j >= 0; j--) {
                for (int k = G; k >= g; k--) {
                    int curSalary = salary + j;
                    curSalary = Math.min(curSalary, P);
                    dp[k][curSalary] = dp[k][curSalary] + dp[k - g][j];
                    dp[k][curSalary] %= MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= G; i++) {
            res += dp[i][P];
            res %= MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        Hard0879 main = new Hard0879();
        System.out.println(main.profitableSchemes(
                5, 3,
                new int[] {2, 2},
                new int[] {2, 3}
        ));
        System.out.println(main.profitableSchemes(
                10, 5,
                new int[] {2, 3, 5},
                new int[] {6, 7, 8}
        ));
        System.out.println();
        System.out.println(main.profitableSchemes2(
                5, 3,
                new int[] {2, 2},
                new int[] {2, 3}
        ));
        System.out.println(main.profitableSchemes2(
                10, 5,
                new int[] {2, 3, 5},
                new int[] {6, 7, 8}
        ));
    }
}