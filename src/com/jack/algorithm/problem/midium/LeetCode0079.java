package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0079 {

    private boolean res;
    private int row, col;
    private char[][] board;
    private boolean[][] visited;
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.visited = new boolean[row][col];
        this.res = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    dfs(i, j, word, 1);
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    private void dfs(int x, int y, String word, int nextIndex) {
        if (nextIndex == word.length()) {
            res = true;
            return;
        }
        for (int[] dir : dirs) {
            if (res) {
                break;
            }
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (isValid(nextX, nextY)) {
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (board[nextX][nextY] == word.charAt(nextIndex)) {
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY, word, nextIndex + 1);
                    visited[nextX][nextY] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0079 main = new LeetCode0079();
//        main.test1();
        main.test2();
    }

    private void test1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(
                board, "ABCCED"
        ));
        System.out.println(exist(
                board, "SEE"
        ));
    }

    private void test2() {
        char[][] board = {
                {'a', 'a'}
        };
        System.out.println(exist(
                board, "aaa"
        ));
    }
}