package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fy
 */
public class LeetCode0046 {

    private boolean[] visited;
    private int[] nums;
    private int len;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        visited = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(0, path, res);
        return res;
    }
    private void dfs(int depth,
                     List<Integer> path,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                dfs(depth + 1, path, res);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0046 main = new LeetCode0046();
        System.out.println(main.permute(new int[]{1, 2, 3}));
    }
}
