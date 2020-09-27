package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0200 {

    private int row, col;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    private boolean inArr(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                if (grid[i][j] == '1') {
                    count ++;
                    findIfIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void findIfIsland(char[][] grid, int x, int y) {
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArr(nextX, nextY) &&
                    !visited[nextX][nextY]
                    && grid[nextX][nextY] == '1') {
                visited[nextX][nextY] = true;
                findIfIsland(grid, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0200 main = new LeetCode0200();
        System.out.println(main.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray(),}));
        System.out.println(main.numIslands(new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray(),}));
        System.out.println(main.numIslands(new char[][]{
                "111".toCharArray(),
                "010".toCharArray(),
                "111".toCharArray(),}));
    }


}
