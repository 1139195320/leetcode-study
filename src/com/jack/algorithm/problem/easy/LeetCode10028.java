package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode10028 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val
                && isSymmetric(node1.left, node2.right)
                && isSymmetric(node1.right, node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur1 = queue.remove();
            TreeNode cur2 = queue.remove();
            if (cur1 == null && cur2 == null) {
                continue;
            }
            if (cur1 == null || cur2 == null) {
                return false;
            }
            if (cur1.val != cur2.val) {
                return false;
            }
            queue.add(cur1.left);
            queue.add(cur2.right);
            queue.add(cur1.right);
            queue.add(cur2.left);
        }
        return true;
    }
}
