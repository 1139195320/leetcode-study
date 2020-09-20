package com.jack.algorithm.problem.hard;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0996 {

    private Set<List<Integer>> res;
    private boolean[] visited;
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        visited = new boolean[A.length];
        res = new HashSet<>();
        firstSet = new HashSet<>();
        dfs(A, new ArrayList<>(), -1);
        System.out.println(res);
        return res.size();
    }
    private Set<Integer> firstSet;
    private void dfs(int[] A, List<Integer> curList, int pre) {
        if (curList.size() == A.length) {
            // 以元素个数来判断是否回溯出目标结果
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < A.length; i++) {
            if (visited[i]) {
                continue;
            }
            int cur = A[i];
            if (curList.size() == 0) {
                // curList 为空说明又到了一个回溯的头
                // 如果已经有遍历过以 cur 为首元素的情况就跳过
                if (firstSet.contains(cur)) {
                    continue;
                }
                firstSet.add(cur);
            }
            if (pre != -1) {
                int tmp = (int) Math.sqrt(cur + pre);
                if (tmp * tmp != cur + pre) {
                    continue;
                }
            }
            visited[i] = true;
            curList.add(cur);
            dfs(A, curList, cur);
            curList.remove(curList.size() - 1);
            visited[i] = false;
            if (pre == cur) {
                // 相邻两元素相同，并已回溯完此情况，剪枝
                i ++;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0996 main = new LeetCode0996();
        System.out.println(main.numSquarefulPerms(
                new int[]{7, 2, 2, 7, 2}
        ));
        System.out.println(main.numSquarefulPerms(
                new int[]{1, 17, 8}
        ));
        System.out.println(main.numSquarefulPerms(
                new int[]{2, 2}
        ));
        System.out.println(main.numSquarefulPerms(
                new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        ));
        System.out.println(main.numSquarefulPerms(
                new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        ));
        System.out.println(main.numSquarefulPerms(
                new int[]{2, 2, 2}
        ));
    }
}