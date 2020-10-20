package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0143 {

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

    public void reorderList(ListNode head) {
        // 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
        // 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int size = list.size();
        int l = 0, r = size - 1;
        cur = head;
        ListNode tmp;
        while (l < r) {
            if (l > 0) {
                tmp = list.get(l);
                tmp.next = null;
                cur.next = tmp;
                cur = cur.next;
            }
            tmp = list.get(r--);
            tmp.next = null;
            cur.next = tmp;
            cur = cur.next;
            l ++;
        }
        if ((size & 1) != 0) {
            // 总结点个数为奇数
            // 正中间的节点放在新链表的最后
            tmp = list.get(size >> 1);
            tmp.next = null;
            cur.next = tmp;
        }
    }

    public static void main(String[] args) {
        LeetCode0143 main = new LeetCode0143();
        ListNode listNode1 = main.getListNode(1, 2, 3, 4);
        ListNode listNode2 = main.getListNode(1, 2, 3, 4, 5);
        main.reorderList(listNode1);
        main.reorderList(listNode2);
        System.out.println(listNode1);
        System.out.println(listNode2);
    }
}
