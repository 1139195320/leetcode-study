package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 * 找出二叉树最大数的所在位置（深度，横向位置）
 */
public class LeetCode00001 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }

    public int[] getMaxPos(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int maxDepth = 1;
        int maxIndex = 1;
        int maxNum = - Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.remove();
                // compare
                if (curNode.val > maxNum) {
                    maxIndex = i + 1;
                    maxDepth = depth;
                }
                TreeNode left = curNode.left;
                TreeNode right = curNode.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            depth ++;
        }
        return new int[]{maxDepth, maxIndex};
    }

    public static void main(String[] args) {
        LeetCode00001 main = new LeetCode00001();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        System.out.println(Arrays.toString(main.getMaxPos(node1)));
    }
}
