package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10055 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return Math.abs(height(left) - height(right)) < 2
                && isBalanced(left) && isBalanced(right);
    }
}
