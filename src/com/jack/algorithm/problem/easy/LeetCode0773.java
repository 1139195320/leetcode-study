package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0773 {

    private int row, col;
    private int target, newColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row = image.length;
        col = image[0].length;
        target = image[sr][sc];
        this.newColor = newColor;
        boolean[][] visited = new boolean[row][col];
        dfs(image, visited, sr, sc);
        return image;
    }
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void dfs(int[][] image, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (visited[x][y] || image[x][y] != target) {
            return;
        }
        image[x][y] = newColor;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            dfs(image, visited, nextX, nextY);
        }
    }
}
