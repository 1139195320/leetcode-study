package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0021 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val);
                cur = cur.next;
                if (cur != null) {
                    sb.append("->");
                }
            }
            return sb.toString();
        }
        public ListNode(int ... valArr) {
            if (valArr != null && valArr.length > 0) {
                this.val = valArr[0];
                ListNode curNext = null;
                for (int i = 1; i < valArr.length; i++) {
                    ListNode newNode = new ListNode(valArr[i]);
                    if (curNext == null) {
                        this.next = newNode;
                        curNext = this.next;
                    } else {
                        curNext.next = newNode;
                        curNext = newNode;
                    }
                }
            }
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        Queue<Integer> queue = new LinkedList<>();
        while (cur1 != null && cur2 != null) {
            int val1 = cur1.val;
            int val2 = cur2.val;
            if (val1 <= val2) {
                queue.add(val1);
                cur1 = cur1.next;
            } else {
                queue.add(val2);
                cur2 = cur2.next;
            }
        }
        ListNode res = new ListNode(queue.remove());
        ListNode temp = res;
        while (!queue.isEmpty()) {
            ListNode newNode = new ListNode(queue.remove());
            temp.next = newNode;
            temp = newNode;
        }
        if (cur1 != null) {
            temp.next = cur1;
        }
        if (cur2 != null) {
            temp.next = cur2;
        }
        return res;
    }

    public ListNode mergeTwoLists2(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        int data;
        if (node1.val <= node2.val) {
            data = node1.val;
            node1 = node1.next;
        } else {
            data = node2.val;
            node2 = node2.next;
        }
        ListNode head = new ListNode(data);
        ListNode cur = head;
        while (true) {
            if (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    data = node1.val;
                    node1 = node1.next;
                } else {
                    data = node2.val;
                    node2 = node2.next;
                }
                cur.next = new ListNode(data);
                cur = cur.next;
            }
            if (node1 == null) {
                cur.next = node2;
                break;
            }
            if (node2 == null) {
                cur.next = node1;
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode0021 main = new LeetCode0021();
        System.out.println(main.mergeTwoLists(
                new ListNode(1, 2, 4),
                new ListNode(1, 3, 4)));
    }
}
