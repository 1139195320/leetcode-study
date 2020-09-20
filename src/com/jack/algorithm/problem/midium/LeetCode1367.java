package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1367 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return check(head, root) || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }

    private boolean check(ListNode listNode, TreeNode treeNode) {
        if (listNode == null) {
            return true;
        }
        if (treeNode == null || listNode.val != treeNode.val) {
            return false;
        }
        return check(listNode.next, treeNode.left)
                || check(listNode.next, treeNode.right);
    }
}
