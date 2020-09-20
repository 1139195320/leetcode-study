package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0037 {

    /**
     * 还未填充的点
     */
    private List<int[]> whiteDotList;
    private int[] visitedRow;
    private int[] visitedCol;
    private int[][] visitedBoard;
    /**
     * 可以选的数字
     */
    private int[] dataArr;
    private char[][] board;
    public void solveSudoku(char[][] board) {
        dataArr = new int[9];
        this.board = board;
        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = i + 1;
        }
        int row = board.length;
        int col = board[0].length;
        visitedRow = new int[row];
        visitedCol = new int[col];
        visitedBoard = new int[row / 3][col / 3];
        whiteDotList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if (c == '.') {
                    whiteDotList.add(new int[] {i, j});
                } else {
                    int tmp = 1 << (c - '0');
                    visitedRow[i] += tmp;
                    visitedCol[j] += tmp;
                    visitedBoard[i / 3][j / 3] += tmp;
                }
            }
        }
        find = false;
        dfs(0);
    }
    private boolean find;
    private void dfs(int start) {
        if (start == whiteDotList.size()) {
            find = true;
            return;
        }
        int[] cur = whiteDotList.get(start);
        for (int j = 0; j < 9; j++) {
            if (find) {
                break;
            }
            int data = dataArr[j];
            int tmp = 1 << data;
            int x = cur[0];
            int y = cur[1];
            if ((visitedRow[x] & tmp) == 0
                    && (visitedCol[y] & tmp) == 0
                    && (visitedBoard[x / 3][y / 3] & tmp) == 0) {
                // 行没有这个数
                // 列没有这个数
                // 当前 3 * 3 方块儿没有这个数
                board[x][y] = (char) (data + '0');
                visitedRow[x] += tmp;
                visitedCol[y] += tmp;
                visitedBoard[x / 3][y / 3] += tmp;
                dfs(start + 1);
                if (find) {
                    break;
                }
                board[x][y] = '.';
                visitedRow[x] -= tmp;
                visitedCol[y] -= tmp;
                visitedBoard[x / 3][y / 3] -= tmp;
            }
        }
    }


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
    private void backtrace(char[][] src, int x, int y) {
        if (x == N - 1 && y == N) {
            res = true;
            return;
        }
        if (y == N) {
            // 换行
            x ++;
            y = 0;
        }
        if (src[x][y] != '.') {
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
                src[x][y] = (char) (i + '0');
                counts[i] ++;
                backtrace(src, x, y + 1);
                if (res) {
                    break;
                }
                counts[i] --;
                src[x][y] = '.';
                hs[y] -= tmp;
                vs[x] -= tmp;
                blocks[x / n][y / n] -= tmp;
            }
        }
    }
    public void generateSudoku(char[][] src) {
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = src[i][j];
                if (c != '.') {
                    int cur = c - '0';
                    counts[cur] ++;
                    int tmp = 1 << cur;
                    vs[i] += tmp;
                    hs[j] += tmp;
                    blocks[i / 3][j / 3] += tmp;
                }
            }
        }
        backtrace(src, 0, 0);
    }
    public void solveSudoku2(char[][] board) {
        generateSudoku(board);
    }


    public static void main(String[] args) {
        LeetCode0037 main = new LeetCode0037();
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        main.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
