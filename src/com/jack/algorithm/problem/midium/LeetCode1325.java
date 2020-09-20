package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode1325 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            sb.append(this.val).append(",");
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    queue.add(cur.left);
                    sb.append(cur.left.val).append(",");
                } else {
                    sb.append("#,");
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    sb.append(cur.right.val).append(",");
                } else {
                    sb.append("#,");
                }
            }
            return sb.toString();
        }

    }

    public TreeNode getNode(String src) {
        String[] arr = src.split(",");
        String val = arr[0];
        if (val != null && !"#".equals(val)) {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    String leftVal = arr[index ++];
                    if (leftVal != null && !"#".equals(leftVal)) {
                        cur.left = new TreeNode(Integer.parseInt(leftVal));
                        queue.add(cur.left);
                    }
                    String rightVal = arr[index ++];
                    if (rightVal != null && !"#".equals(rightVal)) {
                        cur.right = new TreeNode(Integer.parseInt(rightVal));
                        queue.add(cur.right);
                    }
                }
            }
            return root;
        }
        return null;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null || doRemoveLeafNodes(root, target)) {
            return null;
        }
        return root;
    }
    private boolean doRemoveLeafNodes(TreeNode cur, int target) {
        if (cur == null) {
            return true;
        }
        boolean leftFlag = doRemoveLeafNodes(cur.left, target);
        boolean rightFlag = doRemoveLeafNodes(cur.right, target);
        if (leftFlag) {
            cur.left = null;
        }
        if (rightFlag) {
            cur.right = null;
        }
        return cur.val == target && leftFlag && rightFlag;
    }

    public static void main(String[] args) {
        LeetCode1325 main = new LeetCode1325();
        System.out.println(main.removeLeafNodes(
                main.getNode("1,2,3,2,#,2,4,#,#,#,#,#,#"), 2
        ));
        System.out.println(main.removeLeafNodes(
                main.getNode("1,3,3,3,2,#,#,#,#,#,#"), 3
        ));
        System.out.println(main.removeLeafNodes(
                main.getNode("1,2,#,2,#,2,#,#,#"), 2
        ));
        System.out.println(main.removeLeafNodes(
                main.getNode("1,1,#,1,#,#,#"), 1
        ));
    }
}