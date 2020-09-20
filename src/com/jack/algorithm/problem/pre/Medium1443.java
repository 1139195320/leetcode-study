package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Medium1443 {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer> visitedPar = new ArrayList<>();
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(hasApple.size());
        for (int[] edge : edges) {
            // 子 -> 父
            map.put(edge[1], edge[0]);
        }
        for (int i = 1; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                if (!visitedPar.contains(i)) {
                    int[] edge;
                    int cur = i;
                    res += 2;
                    visitedPar.add(i);
                    while (!visitedPar.contains(map.get(cur))) {
                        cur = map.get(cur);
                        if (cur == 0) {
                            break;
                        }
                        visitedPar.add(cur);
                        res += 2;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1443 main = new Medium1443();
        System.out.println(main.minTime(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                Arrays.asList(false, false, true, false, true, true, false)
        ));
        System.out.println(main.minTime(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                Arrays.asList(false, false, true, false, false, true, false)
        ));
        System.out.println(main.minTime(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                Arrays.asList(false, false, false, false, false, false, false)
        ));
    }
}
