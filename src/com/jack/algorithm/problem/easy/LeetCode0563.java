package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0563 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }
    private int tilt(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.abs(sum(node.left) - sum(node.right));
    }
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return tilt(root) + findTilt(root.left) + findTilt(root.right);
    }


    private int res = 0;
    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left);
        int right = traverse(node.right);
        res += Math.abs(left - right);
        return left + right + node.val;
    }
    public int findTilt2(TreeNode root) {
        traverse(root);
        return res;
    }
}
