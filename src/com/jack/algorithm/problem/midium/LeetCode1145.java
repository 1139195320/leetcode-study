package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode1145 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode tNode = null;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                if (x == cur.val) {
                    tNode = cur;
                    break;
                }
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            if (tNode == null) {
                return true;
            }
            int leftSize = getNodeSize(tNode.left);
            int rightSize = getNodeSize(tNode.right);
            int k = n >> 1;
            // 1、选 x 的左子节点
            // 2、选 x 的右子节点
            // 3、选 x 的父节点
            return leftSize > k || rightSize > k
                    || (n - (leftSize + rightSize + 1)) > k;
        }
        return false;
    }
    private int getNodeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getNodeSize(node.left) + getNodeSize(node.right) + 1;
    }

    public static void main(String[] args) {
        LeetCode1145 main = new LeetCode1145();
        System.out.println(main.btreeGameWinningMove(
                main.getNode(
                        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}),
                11, 1));
        System.out.println(main.btreeGameWinningMove(
                main.getNode(
                        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}),
                11, 2));
        System.out.println(main.btreeGameWinningMove(
                main.getNode(
                        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}),
                11, 3));
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