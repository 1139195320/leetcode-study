package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0111 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null) {
            return minDepth(right) + 1;
        }
        if (right == null) {
            return minDepth(left) + 1;
        }
        return Math.min(minDepth(left),
                minDepth(right)) + 1;
    }

    public static void main(String[] args) {
        LeetCode0111 main = new LeetCode0111();
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = new TreeNode(5);
        System.out.println(main.minDepth(node1));
    }
}