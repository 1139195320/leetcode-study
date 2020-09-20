package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium1319 {

    private static class DSU {
        private int[] parent;
        DSU(int[] parent) {
            this.parent = parent;
        }
        int find(int z) {
            while (z != parent[z]) {
                z = parent[z];
            }
            return z;
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            // 已有线数不够
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        DSU dsu = new DSU(parent);
        for (int[] connection : connections) {
            dsu.union(connection[0], connection[1]);
        }
        // 记录连通分量的数目
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(dsu.find(i));
        }
        return set.size() - 1;
    }

    public static void main(String[] args) {
        Medium1319 main = new Medium1319();
        System.out.println(main.makeConnected(
                4,
                new int[][]{
                        {0, 1}, {0, 2}, {1, 2}
                }
        ));
        System.out.println(main.makeConnected(
                6,
                new int[][]{
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}
                }
        ));
        System.out.println(main.makeConnected(
                6,
                new int[][]{
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}
                }
        ));
        System.out.println(main.makeConnected(
                5,
                new int[][]{
                        {0, 1}, {0, 2}, {3, 4}, {2, 3}
                }
        ));
    }
}
