package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode11712 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            sb.append(this.val).append(",");
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    queue.add(cur.left);
                    sb.append(cur.left.val).append(",");
                } else {
                    sb.append("#,");
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    sb.append(cur.right.val).append(",");
                } else {
                    sb.append("#,");
                }
            }
            return sb.toString();
        }
    }

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode vHead = new TreeNode(-1);
        TreeNode head = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (head == null) {
                head = root;
                vHead.right = head;
            } else {
                head.right = root;
                head = root;
            }
            head.left = null;
            root = root.right;
        }
        return vHead.right;
    }

    public static void main(String[] args) {
        LeetCode11712 main = new LeetCode11712();
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node5;
        TreeNode node1 = new TreeNode(1);
        node2.left = node1;
        node2.right = new TreeNode(3);
        node5.right = new TreeNode(6);
        node1.left = new TreeNode(0);
        System.out.println(main.convertBiNode(root));
    }
}