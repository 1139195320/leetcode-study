package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0114 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                list.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur != null) {
                cur = cur.right;
            }
        }
        int size = list.size();
        root = null;
        while (size > 0) {
            TreeNode newCur = list.get(size - 1);
            size --;
            newCur.right = root;
            newCur.left = null;
            root = newCur;
        }
    }

    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.peek();
            // 不存在左子节点或左子节点已经访问过
            if (cur.left == null || cur.left == pre) {
                stack.pop();
                cur.right = pre;
                cur.left = null;
                pre = cur;
                cur = null;
            } else {
                cur = cur.left;
            }
        }
    }

    public void flatten3(TreeNode root) {
        doFlatten(root);
    }
    private TreeNode doFlatten(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            return node;
        }
        TreeNode l = doFlatten(left);
        TreeNode r = doFlatten(right);
        if (left == null) {
            return r;
        }
        if (right == null) {
            node.right = left;
            node.left = null;
            return l;
        }
        node.right = left;
        node.left = null;
        l.right = right;
        return r;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node5;
        node2.left = new TreeNode(3);
        node2.right = new TreeNode(4);
        node5.right = new TreeNode(6);
        LeetCode0114 main = new LeetCode0114();
        System.out.println(node1);
        main.flatten3(node1);
        System.out.println(node1);
    }
}
