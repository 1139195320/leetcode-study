package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0654 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l < 0 || l > r) {
            return null;
        }
        int maxNum = Integer.MIN_VALUE;
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        root.left = buildTree(nums, l, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, r);
        return root;
    }
}
