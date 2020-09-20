package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode11619 {

    public int[] pondSizes(int[][] land) {
        row = land.length;
        col = land[0].length;
        visited = new boolean[row][col];
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (land[i][j] == 0) {
                    int count = findConnect(land, i, j);
                    if (count > 0) {
                        resList.add(count);
                    }
                }
                visited[i][j] = true;
            }
        }
        int size = resList.size();
        if (size == 0) {
            return new int[]{};
        }
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = resList.get(i);
        }
        Arrays.sort(res);
        return res;
    }
    private int row, col;
    private boolean[][] visited;
    private int[][] dirs = {{-1, 0}, {-1, -1}, {-1, 1},
            {1, 0}, {1, -1}, {1, 1}, {0, 1}, {0, -1}};
    private int findConnect(int[][] land, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col
                || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        if (land[x][y] != 0) {
            return 0;
        }
        int count = 1;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            count += findConnect(land, nextX, nextY);
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode11619 main = new LeetCode11619();
        System.out.println(Arrays.toString(main.pondSizes(
                new int[][]{
                        {0, 2, 1, 0},
                        {0, 1, 0, 1},
                        {1, 1, 0, 1},
                        {0, 1, 0, 1}
                }
        )));
    }
}