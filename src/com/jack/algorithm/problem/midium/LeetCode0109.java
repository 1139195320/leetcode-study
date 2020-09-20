package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0109 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val).append(", ");
                cur = cur.next;
            }
            return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
        }
    }
    private ListNode getListNode(int ... dataArr) {
        return getListNode(dataArr, 0);
    }
    private ListNode getListNode(int[] dataArr, int i) {
        if (i >= dataArr.length) {
            return null;
        }
        ListNode res = new ListNode(dataArr[i]);
        res.next = getListNode(dataArr, i + 1);
        return res;
    }
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

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(list, 0, list.size() - 1);
    }
    private TreeNode sortedArrayToBST(List<Integer> list, int l, int r) {
        if (l == r) {
            return new TreeNode(list.get(l));
        }
        int mid = l + ((r - l) >> 1);
        TreeNode node = new TreeNode(list.get(mid));
        if (mid > l) {
            node.left = sortedArrayToBST(list, l, mid - 1);
        }
        if (mid < r) {
            node.right = sortedArrayToBST(list, mid + 1, r);
        }
        return node;
    }

    public static void main(String[] args) {
        LeetCode0109 main = new LeetCode0109();
        ListNode listNode = main.getListNode(-10, -3, 0, 5, 9);
        System.out.println(listNode);
        System.out.println(main.sortedListToBST(listNode));
    }
}