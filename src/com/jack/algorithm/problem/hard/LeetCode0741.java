package com.jack.algorithm.problem.hard;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0741 {

    /**
     * 贪心 先选出起点到终点的最佳路径，
     * 再在此走过的基础上第二次选出最佳路径，
     * 错误
     */
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        // 记录到某个点的最佳路径
        Map<Integer, List<int[]>> map =
                new HashMap<>(row * col + col);
        // i * col + j
        List<int[]> first = new ArrayList<>();
        first.add(new int[] {0, 0});
        map.put(0, first);
        dp[row - 1][col - 1] = -1;
        dp[0][0] = grid[0][0];
        boolean no = false;
        for (int i = 1; i < col; i++) {
            if (no) {
                dp[0][i] = -1;
                continue;
            }
            int cur = grid[0][i];
            if (cur == -1) {
                no = true;
                dp[0][i] = -1;
            } else {
                List<int[]> list = new ArrayList<>(map.get(i - 1));
                list.add(new int[] {0, i});
                map.put(i, list);
                dp[0][i] = dp[0][i - 1] + cur;
            }
        }
        no = false;
        for (int i = 1; i < row; i++) {
            if (no) {
                dp[i][0] = -1;
                continue;
            }
            int cur = grid[i][0];
            if (cur == - 1) {
                no = true;
                dp[i][0] = -1;
            } else {
                List<int[]> list = new ArrayList<>(map.get((i - 1) * col));
                list.add(new int[] {i, 0});
                map.put(i * col, list);
                dp[i][0] = dp[i - 1][0] + cur;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int cur = grid[i][j];
                if (cur == -1) {
                    dp[i][j] = -1;
                    continue;
                }
                int u = dp[i - 1][j];
                int l = dp[i][j - 1];
                // 选路线
                int key;
                if (u == -1 && l == -1) {
                    // 上左都不通
                    dp[i][j] = -1;
                    break;
                }
                dp[i][j] = cur;
                if (u == -1) {
                    // 上不通
                    key = i * col + j - 1;
                    dp[i][j] += l;
                } else if (l == -1) {
                    // 左不通
                    key = (i - 1) * col + j;
                    dp[i][j] += u;
                } else {
                    // 上和左都通
                    if (u >= l) {
                        key = (i - 1) * col + j;
                    } else {
                        key = i * col + j - 1;
                    }
                    dp[i][j] += Math.max(u, l);
                }
                List<int[]> list = new ArrayList<>(map.get(key));
                list.add(new int[] {i, j});
                map.put(i * col + j, list);
            }
        }
        if (dp[row - 1][col - 1] == -1) {
            // 终点不可达
            return 0;
        }
        int tailKey = (row - 1) * col + col - 1;
        List<int[]> list = map.get(tailKey);
        // 将起点到终点的最佳路线置为 0
        for (int[] arr : list) {
            grid[arr[0]][arr[1]] = 0;
        }
        return dp[row - 1][col - 1] + goBack(grid);
    }
    private int goBack(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        boolean no = false;
        for (int i = 1; i < row; i++) {
            if (no) {
                dp[i][0] = -1;
                continue;
            }
            int cur = grid[i][0];
            if (cur == -1) {
                dp[i][0] = -1;
                no = true;
            } else {
                dp[i][0] = dp[i - 1][0] + cur;
            }
        }
        no = false;
        for (int i = 1; i < col; i++) {
            if (no) {
                dp[0][i] = -1;
                continue;
            }
            int cur = grid[0][i];
            if (cur == -1) {
                dp[0][i] = -1;
                no = true;
            } else {
                dp[0][i] = dp[0][i - 1] + cur;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int cur = grid[i][j];
                if (cur == -1) {
                    dp[i][j] = -1;
                    continue;
                }
                int u = dp[i - 1][j];
                int l = dp[i][j - 1];
                if (u == -1 && l == -1) {
                    // 上左都不通
                    dp[i][j] = -1;
                    break;
                }
                dp[i][j] = cur;
                if (u == -1) {
                    // 上不通
                    dp[i][j] += l;
                } else if (l == -1) {
                    // 左不通
                    dp[i][j] += u;
                } else {
                    // 上和左都通
                    dp[i][j] += Math.max(u, l);
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 动态规划 + 备忘录
     */
    private int[][][] memo;
    private int[][] grid;
    private int n;
    public int cherryPickup2(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        memo = new int[n][n][n];
        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(0, 0, 0));
    }
    private int dp(int x1, int y1, int y2) {
        int x2 = x1 + y1 - y2;
        if (x1 == n || x2 == n || y1 == n || y2 == n ||
                grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return - 999999;
        } else if (x1 == n - 1 && y1 == n - 1) {
            return grid[x1][y1];
        } else if (memo[x1][y1][y2] != Integer.MIN_VALUE) {
            return memo[x1][y1][y2];
        } else {
            int res = grid[x1][y1];
            if (y1 != y2) {
                res += grid[x2][y2];
            }
            int res1 = Math.max(dp(x1, y1 + 1, y2 + 1),
                    dp(x1 + 1, y1, y2 + 1));
            int res2 = Math.max(dp(x1, y1 + 1, y2),
                    dp(x1 + 1, y1, y2));
            res += Math.max(res1, res2);
            memo[x1][y1][y2] = res;
            return res;
        }
    }


    public static void main(String[] args) {
        LeetCode0741 main = new LeetCode0741();
        System.out.println(main.cherryPickup(
                new int[][]{
                        {0, 1, -1},
                        {1, 0, -1},
                        {1, 1, 1}
                }
        ));
        System.out.println(main.cherryPickup(
                new int[][]{
                        {1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1}
                }
        ));
    }
}