package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

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
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            if (list.contains(cur)) {
                return cur;
            }
            list.add(cur);
            cur = cur.next;
        }
        return null;
    }
}