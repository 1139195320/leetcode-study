package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0437 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root, 0, sum) +
                pathSum(root.left, sum) +
                pathSum(root.right, sum);
    }
    private int pathSum(TreeNode node, int pre, int target) {
        if (node == null) {
            return 0;
        }
        int cur = pre + node.val;
        int res = 0;
        if (cur == target) {
            res ++;
        }
        return res + pathSum(node.left, cur, target) +
                pathSum(node.right, cur, target);
    }
}
