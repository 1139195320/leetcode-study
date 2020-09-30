package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0701 {

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
    private static TreeNode getNode(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        return doGetNode(arr, 0);
    }
    private static TreeNode doGetNode(Integer[] arr, int i) {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        int cur = root.val;
        if (val > cur) {
            // 右边
            root.right = insertIntoBST(root.right, val);
        } else {
            // 左边
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public static void main(String[] args) {
        LeetCode0701 main = new LeetCode0701();
        //   8
        // 4   14
        //2 6 10
        TreeNode node = getNode(new Integer[]{8, 4, 14, 2, 6});
        System.out.println(main.insertIntoBST(node, 10));
        System.out.println(main.insertIntoBST(main.insertIntoBST(node, 5), 20));
    }
}
