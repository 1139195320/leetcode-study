package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard0920 {

    public int numMusicPlaylists(int N, int L, int K) {
        int MOD = 1_000_000_007;
        // 选了 i 首，j 首不一样
        int[][] dp = new int[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                // 播放最近 j 首里面未播放过的歌
                dp[i][j] += dp[i - 1][j - 1] * (N - (j - 1));
                // 播放最近 j 首里面已播放过的歌
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0);
                dp[i][j] %= MOD;
            }
        }
        return dp[L][N];
    }

    public static void main(String[] args) {
        Hard0920 main = new Hard0920();
        System.out.println(main.numMusicPlaylists(3, 3, 1));
        System.out.println(main.numMusicPlaylists(2, 3, 0));
        System.out.println(main.numMusicPlaylists(2, 3, 1));
    }
}