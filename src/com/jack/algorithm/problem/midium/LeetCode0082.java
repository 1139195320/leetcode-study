package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0082 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        List<Integer> dataList = new ArrayList<>();
        Set<Integer> removeSet = new HashSet<>();
        while (cur != null) {
            int val = cur.val;
            if (dataList.contains(val)) {
                removeSet.add(val);
            } else {
                dataList.add(val);
            }
            cur = cur.next;
        }
        for (Integer toRemove : removeSet) {
            dataList.remove(toRemove);
        }
        head = null;
        for (Integer data : dataList) {
            if (head == null) {
                head = new ListNode(data);
                cur = head;
            } else {
                cur.next = new ListNode(data);
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode(-1);
        vHead.next = head;
        ListNode pre = vHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                // cur.next 和 cur 重复了
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return vHead.next;
    }

    public static void main(String[] args) {
        LeetCode0082 main = new LeetCode0082();
        System.out.println(main.deleteDuplicates(
                main.getListNode(1, 2, 3, 3, 4, 4, 5)));
        System.out.println(main.deleteDuplicates(
                main.getListNode(1, 1, 1, 2, 3)));
    }
}