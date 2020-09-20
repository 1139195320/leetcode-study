package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0450 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            // delete cur
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) {
                return null;
            }
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            root = right;
            TreeNode cur = right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = left;
        }
        return root;
    }

}