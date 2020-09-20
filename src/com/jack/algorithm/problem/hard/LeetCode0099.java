package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0099 {

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
    }

    private List<Integer> inOrder(TreeNode curNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null || !stack.empty()) {
            while (curNode != null) {
                stack.add(curNode);
                curNode = curNode.left;
            }
            if (!stack.empty()) {
                curNode = stack.pop();
                list.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return list;
    }
    public void recoverTree(TreeNode root) {
        // 先中序遍历
        // 如果正确的二叉搜索树，应该是递增集合
        // 找到两个位置不对的数，即为等待交换的数值
        List<Integer> inOrderList = inOrder(root);
        // 1, 2, 3, 4, 5
        // 1, 4, 3, 2, 5
        // 1, 3, 2, 4, 5
        int a = 0;
        int b = 0;
        boolean findA = false;
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) < inOrderList.get(i - 1)) {
                if (!findA) {
                    a = inOrderList.get(i - 1);
                    b = inOrderList.get(i);
                    findA = true;
                } else {
                    b = inOrderList.get(i);
                    break;
                }
            }
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        // 遍历一次，将不正确数值的位置换上正确的数值
        while (curNode != null || !stack.empty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.empty()) {
                curNode = stack.pop();
                if (curNode.val == a) {
                    curNode.val = b;
                } else if (curNode.val == b) {
                    curNode.val = a;
                }
                curNode = curNode.right;
            }
        }
    }
}
