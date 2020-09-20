package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0814 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                sb.append(cur.val).append(", ");
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        return isZeroNode(root) ? null : root;
    }
    private boolean isZeroNode(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean zeroLeft = isZeroNode(node.left);
        boolean zeroRight = isZeroNode(node.right);
        if (zeroLeft) {
            node.left = null;
        }
        if (zeroRight) {
            node.right = null;
        }
        return node.val == 0 && zeroLeft && zeroRight;
    }

    public static void main(String[] args) {
        LeetCode0814 main = new LeetCode0814();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(main.pruneTree(node1));
    }
}
