package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0529 {

    public char[][] updateBoard(char[][] board, int[] click) {
        // M -> X 雷
        // E -> B 空
        // 1-9 数字
        row = board.length;
        col = board[0].length;
        char[][] curBoard = new char[row][col];
        // 如果该点不是雷，记录该点周围的雷数
        visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            curBoard[i] = board[i].clone();
            Arrays.fill(visited[i], -1);
        }
        dfs(curBoard, click[0], click[1]);
        return curBoard;
    }
    private int row, col;
    private int[][] dirs = {{-1, 0}, {-1, -1}, {-1, 1},
            {1, 0}, {1, -1}, {1, 1}, {0, -1}, {0, 1}};
    private int[][] visited;
    private void dfs(char[][] board, int x, int y) {
        if (!isValid(x, y) || visited[x][y] != -1) {
            return;
        }
        char cur = board[x][y];
        if (cur == 'M') {
            // 这个点是雷
            board[x][y] = 'X';
            visited[x][y] = 0;
        }
        else if (cur == 'E') {
            // 这个点是还未点亮的空格
            // 统计周围的雷数
            int count = findThunder(board, x, y);
            if (count == 0) {
                // 周围没有雷
                board[x][y] = 'B';
                // 递归点亮周围点
                for (int[] dir : dirs) {
                    dfs(board, x + dir[0], y + dir[1]);
                }
                visited[x][y] = 0;
            } else {
                // 该点周围有雷，填充雷数
                board[x][y] = (char) ('0' + count);
                visited[x][y] = count;
            }
        }
        // 已经亮了的点或者数字点忽略
    }
    private int findThunder(char[][] board, int x, int y) {
        if (!isValid(x, y)) {
            return 0;
        }
        if (visited[x][y] != -1) {
            // 这个点已经统计过直接返回
            return visited[x][y];
        }
        int count = 0;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (isValid(nextX, nextY)) {
                if (board[nextX][nextY] == 'M') {
                    // 周围发现一个雷
                    count ++;
                }
            }
        }
        // 这个点统计完记录下来
        visited[x][y] = count;
        return count;
    }
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        LeetCode0529 main = new LeetCode0529();
        char[][] board = new char[][] {
                "EEEEE".toCharArray(),
                "EEMEE".toCharArray(),
                "EEEEE".toCharArray(),
                "EEEEE".toCharArray()
        };
        char[][] board1 = main.updateBoard(board, new int[]{3, 0});
        System.out.println(Arrays.deepToString(board1));
        System.out.println(Arrays.deepToString(
                main.updateBoard(board1, new int[]{1, 2})));
    }
}