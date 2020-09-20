package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0130 {

    public static void main(String[] args) {
        LeetCode0130 main = new LeetCode0130();
        main.test1();
        main.test2();
    }
    private void test2() {
        char[][] data = new char[][] {
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'X', 'X'},
                {'O', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'},
        };
        for (char[] aData : data) {
            System.out.println(Arrays.toString(aData));
        }
        solve(data);
        System.out.println();
        System.out.println("=== solve ===");
        System.out.println();
        for (char[] aData : data) {
            System.out.println(Arrays.toString(aData));
        }
        System.out.println();
    }
    private void test1() {
        char[][] data = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        for (char[] aData : data) {
            System.out.println(Arrays.toString(aData));
        }
        solve(data);
        System.out.println();
        System.out.println("=== solve ===");
        System.out.println();
        for (char[] aData : data) {
            System.out.println(Arrays.toString(aData));
        }
        System.out.println();
    }

    public void solve(char[][] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        List<int[]> whiteList = new ArrayList<>();
        List<int[]> boardWhiteList = new ArrayList<>();
        int row = data.length;
        int col = data[0].length;
        if (col <= 1) {
            return;
        }
        for (int i = 0; i < row; i++) {
            if (data[i][col - 1] == 'O') {
                boardWhiteList.add(new int[] {i, col - 1});
            }
        }
        for (int i = 0; i < col; i++) {
            if (data[row - 1][i] == 'O') {
                boardWhiteList.add(new int[] {row - 1, i});
            }
        }
        for (int i = 0; i < row; i++) {
            if (data[i][0] == 'O') {
                boardWhiteList.add(new int[] {i, 0});
            }
        }
        for (int i = 0; i < col; i++) {
            if (data[0][i] == 'O') {
                boardWhiteList.add(new int[] {0, i});
            }
        }
        boolean[][] visited = new boolean[row][col];
        for (int[] boardWhite : boardWhiteList) {
            int x = boardWhite[0];
            int y = boardWhite[1];
            dfs(data, whiteList, visited, x, y);
        }
        for (char[] aData : data) {
            Arrays.fill(aData, 'X');
        }
        for (int[] white : whiteList) {
            int x = white[0];
            int y = white[1];
            data[x][y] = 'O';
        }
    }
    private void dfs(char[][] data, List<int[]> whiteList,
                     boolean[][] visited, int x, int y) {
        int row = data.length;
        int col = data[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (data[x][y] == 'O') {
            whiteList.add(new int[] {x, y});
            for (int[] dir : dirs) {
                dfs(data, whiteList, visited, x + dir[0], y + dir[1]);
            }
        }
    }
    private int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    public void solve2(char[][] board) {
        int row = board.length;
        if (row < 3) {
            return;
        }
        int col = board[0].length;
        if (col < 3) {
            return;
        }
        boolean[][] visited = new boolean[row][col];
        List<int[]> tmpWhiteList = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                tmpWhiteList.add(new int[] {0, i});
                visited[0][i] = true;
            }
            if (board[row - 1][i] == 'O') {
                tmpWhiteList.add(new int[]{row - 1, i});
                visited[row - 1][i] = true;
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                tmpWhiteList.add(new int[] {i, 0});
                visited[i][0] = true;
            }
            if (board[i][col - 1] == 'O') {
                tmpWhiteList.add(new int[]{i, col - 1});
                visited[i][col - 1] = true;
            }
        }
        List<int[]> whiteList = new ArrayList<>(tmpWhiteList);
        for (int[] white : tmpWhiteList) {
            search(board, visited, whiteList, white[0], white[1]);
        }
        for (char[] arr : board) {
            Arrays.fill(arr, 'X');
        }
        for (int[] white : whiteList) {
            board[white[0]][white[1]] = 'O';
        }
    }
    private void search(char[][] board, boolean[][] visited,
                        List<int[]> whiteList, int x, int y) {
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX > 0 && nextX < board.length - 1
                    && nextY > 0 && nextY < board[0].length - 1) {
                if (visited[nextX][nextY]) {
                    continue;
                }
                visited[nextX][nextY] = true;
                if (board[nextX][nextY] == 'O') {
                    whiteList.add(new int[]{nextX, nextY});
                    search(board, visited, whiteList, nextX, nextY);
                }
            }
        }
    }
}