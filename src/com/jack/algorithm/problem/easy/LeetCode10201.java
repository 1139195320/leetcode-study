package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode10201 {

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

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            if (!list.contains(head.val)) {
                list.add(head.val);
            }
            head = head.next;
        }
        ListNode cur = null;
        for (int i : list) {
            if (head == null) {
                head = new ListNode(i);
            } else if (cur == null) {
                cur = new ListNode(i);
                head.next = cur;
            } else {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
        }
        return head;
    }
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(cur.val);
        while (cur.next != null) {
            if (!set.contains(cur.next.val)) {
                set.add(cur.next.val);
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode10201 main = new LeetCode10201();
        System.out.println(main.removeDuplicateNodes2(
                main.getListNode(1, 2, 3, 3, 2, 1)
        ));
    }
}
