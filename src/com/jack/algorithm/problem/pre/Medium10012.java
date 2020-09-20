package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium10012 {

    private boolean res;
    private int row, col;
    private char[][] board;
    private boolean[][] visited;
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    private void dfs(int x, int y, String word, int index) {
        if (index == word.length()) {
            res = true;
            return;
        }
        if (res) {
            return;
        }
        char target = word.charAt(index);
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (isValid(nextX, nextY)
                    && !visited[nextX][nextY]
                    && board[nextX][nextY] == target) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, word, index + 1);
                if (res) {
                    break;
                }
                visited[nextX][nextY] = false;
            }
        }
    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.visited = new boolean[row][col];
        this.res = false;
        char firstC = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == firstC) {
                    visited[i][j] = true;
                    dfs(i, j, word, 1);
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium10012 main = new Medium10012();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(main.exist(
                board, "ABCCED"
        ));
        System.out.println(main.exist(
                board, "SEE"
        ));
        System.out.println(main.exist(
                new char[][] {"ab".toCharArray(), "cd".toCharArray()},
                "abcd"
        ));
    }
}