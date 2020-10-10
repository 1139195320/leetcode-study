package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0142 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode parNode = head;
                while (parNode != slow) {
                    parNode = parNode.next;
                    slow = slow.next;
                }
                return parNode;
            }
        }
        return null;
    }
}