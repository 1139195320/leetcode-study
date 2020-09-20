package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1219 {

    private int row, col;
    private boolean[][] visited;
    private int res;
    private int[][] grid;
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row
                && y >= 0 && y < col
                && !visited[x][y]
                && grid[x][y] != 0;
    }
    public int getMaximumGold(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        this.grid = grid;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(i, j, 0);
            }
        }
        return res;
    }
    private void dfs(int x, int y, int preSum) {
        if (!isValid(x, y)) {
            return;
        }
        res = Math.max(res, preSum + grid[x][y]);
        for (int[] dir : dirs) {
            visited[x][y] = true;
            dfs(x + dir[0], y + dir[1], preSum + grid[x][y]);
            visited[x][y] = false;
        }
    }

    public static void main(String[] args) {
        LeetCode1219 main = new LeetCode1219();
        System.out.println(main.getMaximumGold(
                new int[][] {
                        {0, 6, 0},
                        {5, 8, 7},
                        {0, 9, 0},
                }
        ));
    }
}