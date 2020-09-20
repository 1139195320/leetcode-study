package com.jack.algorithm.problem;

import java.util.Arrays;

/**
 * @author jack
 */
public class SudokuMain {

    private static final int N = 9;
    private final int n = 3;
    /**
     * 横向
     **/
    private int[] hs;
    /**
     * 纵向
     **/
    private int[] vs;
    /**
     * 小块儿
     **/
    private int[][] blocks;
    private int[] counts;
    private boolean res;
    private void backtrace(int[][] src, int x, int y) {
        if (x == N - 1 && y == N) {
            res = true;
            return;
        }
        if (y == N) {
            // 换行
            x ++;
            y = 0;
        }
        if (src[x][y] != 0) {
            // 该坐标不需要填
            backtrace(src, x, y + 1);
            return;
        }
        // 填 x, y 这个坐标
        for (int i = 1; i <= N && !res; i++) {
            if (counts[i] >= N) {
                // 这个数字出现次数已达到最大上限
                continue;
            }
            int tmp = 1 << i;
            if ((hs[y] & tmp) == 0
                    && (vs[x] & tmp) == 0
                    && (blocks[x / n][y / n] & tmp) == 0) {
                hs[y] += tmp;
                vs[x] += tmp;
                blocks[x / n][y / n] += tmp;
                src[x][y] = i;
                counts[i] ++;
                backtrace(src, x, y + 1);
                if (res) {
                    break;
                }
                counts[i] --;
                src[x][y] = 0;
                hs[y] -= tmp;
                vs[x] -= tmp;
                blocks[x / n][y / n] -= tmp;
            }
        }
    }
    public void generateSudoku(int[][] src) {
        // 生成数独
        res = false;
        int row = src.length;
        if (row != N) {
            return;
        }
        int col = src[0].length;
        if (col != N) {
            return;
        }
        hs = new int[N];
        vs = new int[N];
        blocks = new int[n][n];
        counts = new int[N + 1];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                counts[src[i][j]] ++;
            }
        }
        backtrace(src, 0, 0);
    }

    public static void main(String[] args) {
        SudokuMain main = new SudokuMain();
        int[][] src = new int[N][N];
        main.generateSudoku(src);
        for (int[] row : src) {
            System.out.println(Arrays.toString(row));
        }
    }
}
