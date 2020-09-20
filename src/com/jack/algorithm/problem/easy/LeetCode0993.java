package com.jack.algorithm.problem.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0993 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        return (depthMap.get(x).equals(depthMap.get(y))
                && !parMap.get(x).equals(parMap.get(y)));
    }
    private Map<Integer, Integer> depthMap = new HashMap<>();
    private Map<Integer, TreeNode> parMap = new HashMap<>();
    private void dfs(TreeNode node, TreeNode parNode) {
        if (node != null) {
            depthMap.put(node.val, parNode != null ? depthMap.get(parNode.val) + 1 : 1);
            parMap.put(node.val, parNode);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}