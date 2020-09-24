package com.jack.algorithm.problem.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0501 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Map<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;
        dfs(root);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cur = entry.getKey();
            int count = entry.getValue();
            if (count < maxCount) {
                continue;
            } else if (count > maxCount) {
                set.clear();
                maxCount = count;
            }
            set.add(cur);
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int cur : set) {
            res[i ++] = cur;
        }
        return res;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        int cur = node.val;
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        dfs(node.left);
        dfs(node.right);
    }
}
