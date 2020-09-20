package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0565 {

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        // 记录从 i 开始的最大长度
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,
                    dfs(nums, visited, dp, i));
        }
        return res;
    }
    private int dfs(int[] nums, boolean[] visited,
                    int[] dp, int pos) {
        if (pos < 0 || pos >= nums.length
                || visited[pos]) {
            return 0;
        }
        visited[pos] = true;
        dp[pos] = 1 + dfs(nums, visited, dp, nums[pos]);
        return dp[pos];
    }

    public static void main(String[] args) {
        Medium0565 main = new Medium0565();
        System.out.println(main.arrayNesting(
                new int[]{5, 4, 0, 3, 1, 6, 2}
        ));
    }
}