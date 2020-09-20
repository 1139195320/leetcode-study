package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0148 {

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

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            addData(list, head.val);
            head = head.next;
        }
        head = new ListNode(list.get(0));
        ListNode cur = head;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    private void addData(List<Integer> list, int data) {
        int n = list.size();
        if (n == 0) {
            list.add(data);
            return;
        }
        if (data >= list.get(n - 1)) {
            list.add(data);
            return;
        }
        if (data <= list.get(0)) {
            list.add(0, data);
            return;
        }
        int tIdx = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (l + r) >> 1;
            if (m == l || data == list.get(m)) {
                tIdx = m + 1;
                break;
            } else if (data > list.get(m)) {
                l = m;
            } else {
                r = m;
            }
        }
        list.add(tIdx, data);
    }

    public static void main(String[] args) {
        LeetCode0148 main = new LeetCode0148();
        System.out.println(main.sortList(
                main.getListNode(
                        -1, 5, 3, 4, 0
                )
        ));
    }
}