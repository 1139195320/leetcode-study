package com.jack.algorithm.problem.still;

import java.util.Arrays;

/**
 * @author jack
 * medium
 */
public class LeetCode0684 {

    private static class DSU {
        int find(int[] parent, int z) {
            while (parent[z] != z) {
                z = parent[z];
            }
            return z;
        }
        void union(int[] parent, int x, int y) {
            int px = find(parent, x);
            int py = find(parent, y);
            if (px != py) {
                parent[px] = py;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        DSU dsu = new DSU();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (dsu.find(parent, x) == dsu.find(parent, y)) {
                return edge;
            }
            dsu.union(parent, x, y);
        }
        return edges[edges.length - 1];
    }

    public static void main(String[] args) {
        LeetCode0684 main = new LeetCode0684();
        System.out.println(Arrays.toString(main.findRedundantConnection(
                new int[][] {
                        {1, 2},
                        {1, 3},
                        {2, 3},
                }
        )));
        System.out.println(Arrays.toString(main.findRedundantConnection(
                new int[][] {
                        {1, 2},
                        {2, 3},
                        {3, 4},
                        {1, 4},
                        {1, 5},
                }
        )));
    }
}