package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0051 {

    private List<List<String>> res;
    private int n;
    private char[][] dataArr;
    private boolean[] visitedRow;
    private boolean[] visitedCol;
    /**
     * ↗ 对角线 x - y + n
     * n * 2 - 1
     */
    private boolean[] visitedLine1;
    /**
     * ↘ 对角线 x + y
     * n * 2 - 1
     */
    private boolean[] visitedLine2;
    private int[][] dirs = new int[][] {
//            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private boolean isQueen(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && dataArr[x][y] == 'Q';
    }
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        this.n = n;
        dataArr = new char[n][n];
        for (char[] chars : dataArr) {
            Arrays.fill(chars, '.');
        }
        visitedRow = new boolean[n];
        visitedCol = new boolean[n];
        visitedLine1 = new boolean[(n << 1) + 1];
        visitedLine2 = new boolean[(n << 1) + 1];
        dfs(0, 0);
        return res;
    }
    private void dfs(int cur, int start) {
        if (cur == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : dataArr) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }
        for (int i = start; i < dataArr.length; i++) {
            for (int j = 0; j < dataArr[i].length; j++) {
                if (visitedRow[i] || visitedCol[j]
                        || visitedLine1[i - j + n]
                        || visitedLine2[i + j]) {
                    continue;
                }
                boolean flag = true;
                for (int[] dir : dirs) {
                    if (isQueen(i + dir[0], j + dir[1])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    visitedRow[i] = true;
                    visitedCol[j] = true;
                    visitedLine1[i - j + n] = true;
                    visitedLine2[i + j] = true;
                    dataArr[i][j] = 'Q';
                    dfs(cur + 1, i + 1);
                    dataArr[i][j] = '.';
                    visitedRow[i] = false;
                    visitedCol[j] = false;
                    visitedLine1[i - j + n] = false;
                    visitedLine2[i + j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0051 main = new LeetCode0051();
        List<List<String>> lists = main.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}