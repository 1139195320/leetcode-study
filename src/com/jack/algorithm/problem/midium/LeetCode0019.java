package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0019 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val).append(", ");
            ListNode cur = next;
            while (cur != null) {
                sb.append(cur.val).append(", ");
                cur = cur.next;
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head.next;
        }
        Queue<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size ++;
            if (queue.size() == n + 1) {
                queue.remove();
            }
            queue.add(cur);
            cur = cur.next;
        }
        if (size < n + 1) {
            return head.next;
        }
        cur = queue.remove();
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < (n + 1); i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode0019 main = new LeetCode0019();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = new ListNode(5);
        System.out.println(main.removeNthFromEnd(head, 2));
    }
}