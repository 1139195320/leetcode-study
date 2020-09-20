package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author fy
 */
public class LeetCode0098 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double minData = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= minData) {
                return false;
            }
            minData = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int rootData = root.val;
        int maxRight = rootData;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            int curData = curNode.val;
            TreeNode leftNode = curNode.left;
            TreeNode rightNode = curNode.right;
            if (leftNode != null) {
                int leftVal = leftNode.val;
                if (leftVal >= curData
                        || (curData > rootData && leftVal <= rootData)) {
                    res = false;
                    break;
                }
                queue.add(leftNode);
            }
            if (rightNode != null) {
                int rightVal = rightNode.val;
                if (rightVal <= curData
                        || (curData < rootData && rightVal >= rootData)) {
                    res = false;
                    break;
                }
                if (curData < maxRight && rightVal >= maxRight) {
                    res = false;
                    break;
                }
                maxRight = Math.max(maxRight, rightVal);
                queue.add(rightNode);
            }
        }
        return res;
    }
}
