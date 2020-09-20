package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0112 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }
    private boolean hasPathSum(TreeNode node, int pre, int target) {
        if (node == null) {
            return false;
        }
        int cur = pre + node.val;
        return (cur == target && node.left == null && node.right == null)
                || hasPathSum(node.left, cur, target)
                || hasPathSum(node.right, cur, target);
    }
}
