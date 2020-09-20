package com.jack.algorithm.problem.easy;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0083 {

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
        Set<Integer> dataSet = new HashSet<>();
        while (cur != null) {
            dataSet.add(cur.val);
            cur = cur.next;
        }
        head = null;
        List<Integer> list = new ArrayList<>(dataSet);
        Collections.sort(list);
        for (Integer data : list) {
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
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        List<Integer> dataList = new ArrayList<>();
        dataList.add(cur.val);
        while (cur.next != null) {
            if (dataList.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                dataList.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode0083 main = new LeetCode0083();
        System.out.println(main.deleteDuplicates(
                main.getListNode(-3, -1, 0, 0, 0, 3, 3)));
        System.out.println(main.deleteDuplicates2(
                main.getListNode(1, 2, 3, 3, 4, 4, 5)));
        System.out.println(main.deleteDuplicates2(
                main.getListNode(1, 1, 1, 2, 3)));
    }
}