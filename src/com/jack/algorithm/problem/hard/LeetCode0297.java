package com.jack.algorithm.problem.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 *
 */
public class LeetCode0297 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            sb.append(root.val).append(",");
            queue.add(root);
        }
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
    public TreeNode deserialize(String src) {
        if (src == null || src.trim().length() == 0) {
            return null;
        }
        String[] arr = src.split(",");
        String val = arr[0];
        if (val != null && !"#".equals(val)) {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    String leftVal = arr[index ++];
                    if (leftVal != null && !"#".equals(leftVal)) {
                        cur.left = new TreeNode(Integer.parseInt(leftVal));
                        queue.add(cur.left);
                    }
                    String rightVal = arr[index ++];
                    if (rightVal != null && !"#".equals(rightVal)) {
                        cur.right = new TreeNode(Integer.parseInt(rightVal));
                        queue.add(cur.right);
                    }
                }
            }
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode0297 main = new LeetCode0297();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = new TreeNode(2);
        node1.right = node3;
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);
        System.out.println(main.serialize(node1));
        System.out.println(main.serialize(main.deserialize(main.serialize(node1))));
    }
}
