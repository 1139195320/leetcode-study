package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fy
 */
public class LeetCode0542 {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int row, col;
    private boolean inArr(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    private boolean[][] visited;
    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        matrixArr = matrix;
        int[][] res = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                minDeep = Integer.MAX_VALUE;
                doFindZero2(i, j, i, j);
                res[i][j] = minDeep;
                queue.clear();
                initVisited();
            }
        }
        return res;
    }
    private void initVisited() {
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }
    }
    private int[][] matrixArr;
    int minDeep = Integer.MAX_VALUE;
    private void doFindZero(int tX, int tY, int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        int deep = Math.abs(tX - x) + Math.abs(tY - y);
        if (deep >= minDeep) {
            return;
        }
        if (matrixArr[x][y] == 0) {
            minDeep = deep;
            return;
        }
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (!inArr(nextX, nextY)) {
                continue;
            }
            doFindZero(tX, tY, nextX, nextY);
        }
    }

    Queue<int[]> queue = new LinkedList<>();
    private void doFindZero2(int tX, int tY, int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        int deep = Math.abs(tX - x) + Math.abs(tY - y);
        if (deep >= minDeep) {
            return;
        }
        if (matrixArr[x][y] == 0) {
            minDeep = deep;
            return;
        }
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArr(nextX, nextY)) {
                queue.add(new int[]{nextX, nextY});
            }
        }
        while (!queue.isEmpty()) {
            int[] next = queue.remove();
            int nextX = next[0];
            int nextY = next[1];
            deep = Math.abs(tX - nextX) + Math.abs(tY - nextY);
            if (deep >= minDeep) {
                break;
            }
            doFindZero2(tX, tY, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        testDo(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println("==========================================");
        testDo(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        System.out.println("==========================================");
        testDo(new int[][]{{1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}});
    }

    private static void testDo(int[][] matrix) {
        LeetCode0542 main = new LeetCode0542();
        int[][] res = main.updateMatrix(matrix);
        for (int[] r : res) {
            for (int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
