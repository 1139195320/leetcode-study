package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0289 {

    public void gameOfLife(int[][] board) {
        row = board.length;
        if (row == 0) {
            return;
        }
        col = board[0].length;
        int[][] tmp = new int[row][col];
        for (int i = 0; i < row; i++) {
            tmp[i] = board[i].clone();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 周围活细胞的个数
                int count = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (!isValid(x, y)) {
                        continue;
                    }
                    count += tmp[x][y];
                }
                if (tmp[i][j] == 1) {
                    // 当前活细胞
                    if (count < 2 || count > 3) {
                        // 当前细胞死亡
                        board[i][j] = 0;
                    }
                } else {
                    // 当前死细胞
                    if (count == 3) {
                        // 当前细胞复活
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
    private int row, col;
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    private int[][] dirs = {{-1, 0}, {-1, -1}, {-1, 1}, {0, -1},
            {1, 0}, {1, -1}, {1, 1}, {0, 1}};

    public static void main(String[] args) {
        Medium0289 main = new Medium0289();
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        main.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}