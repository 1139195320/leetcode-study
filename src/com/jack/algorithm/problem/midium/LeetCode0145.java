package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0145 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // 不通过
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                if (null == stack.peek().right) {
                    root = stack.pop();
                    res.add(root.val);
                    while (root == stack.peek().right) {
                        res.add(stack.peek().val);
                        root = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }
                if (stack.isEmpty()) {
                    root = null;
                } else {
                    root = stack.peek().right;
                }
            }
        }
        
        return res;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            TreeNode right = node.right;
            TreeNode left = node.left;
            if (left != null) {
                stack.push(left);
            }
            if (right != null) {
                stack.push(right);
            }
        }
        return res;
    }

    private List<Integer> res;
    public List<Integer> postorderTraversal2(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        res.add(node.val);
    }

    public static void main(String[] args) {
        //  3
        // 4  5
        //1 2 * *
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node3.left = node4;
        node3.right = node5;
        node4.left = node1;
        node4.right = node2;
        // 1, 2, 4, 5, 3
        LeetCode0145 main = new LeetCode0145();
        System.out.println(main.postorderTraversal(node3));
        System.out.println(main.postorderTraversal2(node3));
    }
}
