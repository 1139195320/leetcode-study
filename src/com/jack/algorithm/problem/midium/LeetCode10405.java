package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jack
 * 合法二叉搜索树
 */
public class LeetCode10405 {

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

    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        Stack<TreeNode> stack = new Stack<>();
        long preVal = Integer.MIN_VALUE;
        preVal -= 1;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            int curVal = root.val;
            if (curVal <= preVal) {
                return false;
            }
            preVal = curVal;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode10405 main = new LeetCode10405();
        System.out.println(main.isValidBST(
                main.getNode(
                        new Integer[] {2, 1, 3})));
        System.out.println(main.isValidBST(
                main.getNode(
                        new Integer[] {5, 1, 4, null, null, 3, 6})));
    }

    private TreeNode getNode(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        return doGetNode(arr, 0);
    }
    private TreeNode doGetNode(Integer[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        Integer data = arr[i];
        if (data == null) {
            return null;
        }
        TreeNode node = new TreeNode(data);
        node.left = doGetNode(arr, (i << 1) + 1);
        node.right = doGetNode(arr, (i << 1) + 2);
        return node;
    }
}