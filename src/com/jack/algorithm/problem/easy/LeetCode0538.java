package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 *
 * 二叉树转换为累加树
 */
public class LeetCode0538 {

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

    private int num;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            num += root.val;
            root.val = num;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        LeetCode0538 main = new LeetCode0538();
        TreeNode node5 = new TreeNode(5);
        node5.left = new TreeNode(2);
        node5.right = new TreeNode(13);
        node5 = main.convertBST(node5);
        System.out.println(node5);
    }
}