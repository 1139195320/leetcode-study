package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class Medium10802 {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        int row = obstacleGrid.length;
        if (row == 0) {
            return res;
        }
        int col = obstacleGrid[0].length;
        if (col == 0) {
            return res;
        }
        if (obstacleGrid[0][0] == 1
                || obstacleGrid[row - 1][col - 1] == 1) {
            return res;
        }
        // 1 不可走，2 可走
        obstacleGrid[0][0] = 2;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0
                    && obstacleGrid[i - 1][0] == 2) {
                obstacleGrid[i][0] = 2;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 0
                    && obstacleGrid[0][i - 1] == 2) {
                obstacleGrid[0][i] = 2;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0 &&
                        (obstacleGrid[i - 1][j] == 2
                                || obstacleGrid[i][j - 1] == 2)) {
                    obstacleGrid[i][j] = 2;
                } else {
                    obstacleGrid[i][j] = 1;
                }
            }
        }
        res.add(Arrays.asList(row - 1, col - 1));
        int i = row - 1;
        int j = col - 1;
        while (true) {
            if (i - 1 >= 0 && obstacleGrid[i - 1][j] == 2) {
                i --;
                res.add(Arrays.asList(i, j));
            } else if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 2) {
                j --;
                res.add(Arrays.asList(i, j));
            } else {
                if (i != 0 || j != 0) {
                    return new ArrayList<>();
                }
                break;
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Medium10802 main = new Medium10802();
        System.out.println(main.pathWithObstacles(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }
        ));
    }
}
