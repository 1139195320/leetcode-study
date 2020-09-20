package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode10027 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            TreeNode left = curNode.left;
            TreeNode right = curNode.right;
            curNode.left = right;
            curNode.right = left;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return root;
    }
}
