package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0047 {

    private int len;
    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[len];
        dfs(nums, 0, visited, deque);
        return res;
    }
    private void dfs(int[] nums, int depth,
                     boolean[] visited, Deque<Integer> deque) {
        if (depth == len) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            deque.addLast(nums[i]);
            visited[i] = true;
            dfs(nums, depth + 1, visited, deque);
            visited[i] = false;
            deque.removeLast();
        }
    }

    private List<List<Integer>> res;

    private int n;
    public List<List<Integer>> permuteUnique2(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        dfs2(nums, visited, new ArrayList<>());
        return res;
    }
    private void dfs2(int[] nums, boolean[] visited, List<Integer> curList) {
        if (curList.size() == n) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            visited[i] = true;
            dfs2(nums, visited, curList);
            visited[i] = false;
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0047 main = new LeetCode0047();
        System.out.println(main.permuteUnique(
                new int[]{1, 1, 2, 1, 3, 2, 3, 1, 4}
        ));
    }
}