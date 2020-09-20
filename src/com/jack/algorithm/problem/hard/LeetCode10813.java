package com.jack.algorithm.problem.hard;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode10813 {

    private int res;
    private boolean[] visited;
    public int pileBox(int[][] box) {
        res = 0;
        visited = new boolean[box.length];
        dfs(box, 0, 0, 0, 0);
        return res;
    }
    private void dfs(int[][] box, int preW, int preD, int preH, int curAllH) {
        for (int i = 0; i < box.length; i++) {
            if (visited[i]) {
                continue;
            }
            int[] lattice = box[i];
            int curW = lattice[0];
            int curD = lattice[1];
            int curH = lattice[2];
            if (curW > preW && curD > preD && curH > preH) {
                visited[i] = true;
                curAllH += curH;
                res = Math.max(res, curAllH);
                dfs(box, curW, curD, curH, curAllH);
                curAllH -= curH;
                visited[i] = false;
            }
        }
    }
    public int pileBox2(int[][] box) {
        int n = box.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(box,
                (a, b) -> a[0] == b[0] ?
                        a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]
                        : a[0]- b[0]);
        int[] dp = new int[n];
        dp[0] = box[0][2];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            int max= 0;
            int baseDepth = box[i][1];
            int baseHeight = box[i][2];
            for (int j = 0; j < i; j++) {
                if (baseDepth > box[j][1] && baseHeight > box[j][2]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + baseHeight;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode10813 main = new LeetCode10813();
        System.out.println(main.pileBox(
                new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}
        ));
        System.out.println(main.pileBox(
                new int[][]{{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}}
        ));
    }
}