package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0110 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        return 1 + Math.max(height(left), height(right));
    }


    private static class TreeInfo {
        private int height;
        private boolean isBalanced;
        TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    private TreeInfo isBalancedHelper(TreeNode node) {
        if (node == null) {
            return new TreeInfo(-1, true);
        }
        TreeInfo leftInfo = isBalancedHelper(node.left);
        if (!leftInfo.isBalanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo rightInfo = isBalancedHelper(node.right);
        if (!rightInfo.isBalanced) {
            return new TreeInfo(-1, false);
        }
        if (Math.abs(leftInfo.height - rightInfo.height) < 2) {
            return new TreeInfo(
                    Math.max(leftInfo.height, rightInfo.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }
    public boolean isBalanced2(TreeNode root) {
        return isBalancedHelper(root).isBalanced;
    }

    public boolean isBalanced3(TreeNode root) {
        res = true;
        getDepth(root);
        return res;
    }
    private boolean res;
    private int getDepth(TreeNode node) {
        if (!res || node == null) {
            return 0;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            return 1;
        }
        int l = getDepth(left);
        int r = getDepth(right);
        if (Math.abs(l - r) > 1) {
            res = false;
            return 0;
        }
        return Math.max(l, r);
    }

    public static void main(String[] args) {
    }
}
