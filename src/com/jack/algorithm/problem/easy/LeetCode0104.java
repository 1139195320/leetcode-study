package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0104 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        LeetCode0104 main = new LeetCode0104();
    }
}