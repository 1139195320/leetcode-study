package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0530 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private int pre, res;
    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre != -1) {
            res = Math.min(res, node.val - pre);
        }
        pre = node.val;
        dfs(node.right);
    }
}
