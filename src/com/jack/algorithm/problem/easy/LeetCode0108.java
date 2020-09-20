package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid > l) {
            node.left = sortedArrayToBST(nums, l, mid - 1);
        }
        if (mid < r) {
            node.right = sortedArrayToBST(nums, mid + 1, r);
        }
        return node;
    }

    public static void main(String[] args) {
        LeetCode0108 main = new LeetCode0108();
        TreeNode node = main.sortedArrayToBST(
                new int[]{-10, -3, 0, 5, 9}
        );
        System.out.println(node);
    }
}