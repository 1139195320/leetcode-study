package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode1329 {

    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        if (row == 1 || col == 1) {
            return mat;
        }
        for (int i = 0; i < col - 1; i++) {
            int j = 0;
            int tmpI = i;
            List<Integer> list = new ArrayList<>();
            while (j < row && tmpI < col) {
                list.add(mat[j ++][tmpI ++]);
            }
            Collections.sort(list);
            j = 0;
            tmpI = i;
            for (int data : list) {
                mat[j ++][tmpI ++] = data;
            }
        }
        for (int i = 1; i < row - 1; i++) {
            int j = 0;
            int tmpI = i;
            List<Integer> list = new ArrayList<>();
            while (j < col && tmpI < row) {
                list.add(mat[tmpI ++][j ++]);
            }
            Collections.sort(list);
            j = 0;
            tmpI = i;
            for (int data : list) {
                mat[tmpI++][j++] = data;
            }
        }
        return mat;
    }
}
