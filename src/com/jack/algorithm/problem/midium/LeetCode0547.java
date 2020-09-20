package com.jack.algorithm.problem.midium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0547 {

    public static void main(String[] args) {
        LeetCode0547 main = new LeetCode0547();
        System.out.println(main.findCircleNum(
                new int[][] {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1},
                }
        ));
        System.out.println(main.findCircleNum(
                new int[][] {
                        {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1},
                }
        ));
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i : parent) {
            set.add(find(parent, i));
        }
        return set.size();
    }
    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
    private int find(int[] parent, int z) {
        while (parent[z] != z) {
            z = parent[z];
        }
        return z;
    }
}