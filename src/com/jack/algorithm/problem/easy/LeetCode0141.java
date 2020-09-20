package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0141 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = first.next;
        while (first != second) {
            if (second == null || second.next == null) {
                return false;
            }
            first = first.next;
            second = second.next.next;
        }
        return true;
    }
}