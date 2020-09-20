package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium0947 {

    private static class DSU {
        int[] parent;
        DSU(int[] parent) {
            this.parent = parent;
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
    }

    public int removeStones(int[][] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }
        // 最大值是 10000
        // 将 j 用 10000 + j 展开
        // 将所有坐标展开到一个一维数组
        int MAX = 10000;
        int[] parent = new int[MAX * 2];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        DSU dsu = new DSU(parent);
        for (int[] stone : stones) {
            dsu.union(stone[0], stone[1] + MAX);
        }
        // 得到重叠之后，能剩下多少的数量
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(dsu.find(stone[0]));
        }
        return stones.length - set.size();
    }

    public static void main(String[] args) {
        Medium0947 main = new Medium0947();
        System.out.println(main.removeStones(
                new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}
        ));
        System.out.println(main.removeStones(
                new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}
        ));
    }
}