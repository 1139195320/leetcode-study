package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0212 {

    private boolean flag;
    private Set<String> res;
    private int row, col;
    private char[][] board;
    private boolean[][] visited;
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.visited = new boolean[row][col];
        this.flag = false;
        res = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        flag = false;
                        visited[i][j] = true;
                        dfs(i, j, word, 1);
                        visited[i][j] = false;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    private void dfs(int x, int y, String word, int nextIndex) {
        if (nextIndex == word.length()) {
            flag = true;
            res.add(word);
            return;
        }
        for (int[] dir : dirs) {
            if (flag) {
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
        LeetCode0212 main = new LeetCode0212();
        System.out.println(main.findWords(
                new char[][]{
                        {'a', 'a'},
                }, new String[]{"aaa"}
        ));
        System.out.println(main.findWords(
                new char[][]{
                        {'a', 'a'},
                }, new String[]{"aa"}
        ));
        System.out.println(main.findWords(
                new char[][]{
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'},
                }, new String[]{"oath", "pea", "eat", "rain"}
        ));
    }
}