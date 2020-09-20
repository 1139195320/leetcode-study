package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0124 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
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

    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return res;
    }
    private int doMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 子节点路径和大于 0 则取，否则舍弃
        int left = Math.max(doMaxPathSum(node.left), 0);
        int right = Math.max(doMaxPathSum(node.right), 0);
        // 判断是否以当前节点为枢纽和最大
        res = Math.max(res, left + right + node.val);
        // 返回以当前节点为连接点的最大路径和
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        LeetCode0124 main = new LeetCode0124();
        System.out.println(main.maxPathSum(
                main.getNode(new Integer[]{-10, 9, 20, null, null, 15, 7})
        ));
    }
}
