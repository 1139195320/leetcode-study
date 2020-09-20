package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode10812 {

    private List<List<String>> res;
    private int n;
    private char[][] dataArr;
    private boolean[] visitedRow;
    private boolean[] visitedCol;
    private int[][] dirs = new int[][] {
//            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private boolean isQueen(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && dataArr[x][y] == 'Q';
    }
    private boolean checkObliqueLine(int x, int y) {
        return checkObliqueLine1(x, y)
                && checkObliqueLine2(x, y)
                && checkObliqueLine3(x, y)
                && checkObliqueLine4(x, y);
    }
    private boolean checkObliqueLine1(int x, int y) {
        boolean flag = true;
        if (x > 0 && y > 0) {
            flag = checkObliqueLine1(x - 1, y - 1);
        }
        return dataArr[x][y] != 'Q' && flag;
    }
    private boolean checkObliqueLine2(int x, int y) {
        boolean flag = true;
        if (x < n - 1 && y < n - 1) {
            flag = checkObliqueLine2(x + 1, y + 1);
        }
        return dataArr[x][y] != 'Q' && flag;
    }
    private boolean checkObliqueLine3(int x, int y) {
        boolean flag = true;
        if (x > 0 && y < n - 1) {
            flag = checkObliqueLine3(x - 1, y + 1);
        }
        return dataArr[x][y] != 'Q' && flag;
    }
    private boolean checkObliqueLine4(int x, int y) {
        boolean flag = true;
        if (x < n - 1 && y > 0) {
            flag = checkObliqueLine4(x + 1, y - 1);
        }
        return dataArr[x][y] != 'Q' && flag;
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
                if (visitedRow[i] || visitedCol[j] || !checkObliqueLine(i, j)) {
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
                    dataArr[i][j] = 'Q';
                    dfs(cur + 1, i + 1);
                    dataArr[i][j] = '.';
                    visitedRow[i] = false;
                    visitedCol[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode10812 main = new LeetCode10812();
        List<List<String>> lists = main.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}