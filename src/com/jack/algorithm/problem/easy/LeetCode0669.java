package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0669 {

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

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        LeetCode0669 main = new LeetCode0669();
        TreeNode node1 = getNode1();
        TreeNode node2 = getNode2();
        System.out.println(node1);
        System.out.println(main.trimBST(node1, 1, 2));
        System.out.println(node2);
        System.out.println(main.trimBST(node2, 1, 3));
    }

    private static TreeNode getNode1() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(0);
        node1.right = new TreeNode(2);
        return node1;
    }
    private static TreeNode getNode2() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        node3.left = node0;
        node3.right = new TreeNode(4);
        node0.right = node2;
        node2.left= new TreeNode(1);
        return node3;
    }
}
