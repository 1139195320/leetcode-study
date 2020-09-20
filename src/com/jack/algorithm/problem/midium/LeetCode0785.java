package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0785 {

    /**
     * 判断一个图是不是二分图
     */
    public boolean isBipartite(int[][] graph) {
        UF uf = new UF(graph.length);
        // 遍历每个顶点，将当前顶点的所有邻接点进行合并
        for (int i = 0; i < graph.length; i++) {
            int[] adjs = graph[i];
            for (int adj : adjs) {
                // 若某个邻接点与当前顶点已经在一个集合中，说明不是二分图
                if (uf.isConnected(i, adj)) {
                    return false;
                }
                uf.union(adjs[0], adj);
            }
        }
        return true;
    }
    private static class UF {
        int[] parent;
        UF(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int z) {
            if (parent[z] != z) {
                parent[z] = find(parent[z]);
                return parent[z];
            } else {
                return z;
            }
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }
        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
