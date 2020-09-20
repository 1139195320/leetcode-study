package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = calcCounts(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j],
                            1 + dp[i - count[0]][j - count[1]]);
                }
            }
        }
        return dp[m][n];
    }
    private int[] calcCounts(String str) {
        int zero = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                zero ++;
            }
        }
        return new int[] {zero, str.length() - zero};
    }

    public static void main(String[] args) {
        Medium0474 main = new Medium0474();
        System.out.println(main.findMaxForm(
                new String[] {"10", "0001", "111001", "1", "0"}, 5, 3
        ));
    }
}