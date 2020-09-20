package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0147 {

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

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head.next;
        vHead.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode tmp = vHead;
                // 找到一个位置使得 tmp < cur  < tmp.next
                while (tmp.next.val < cur.val) {
                    tmp = tmp.next;
                }
                // 将 cur 插入 tmp 和 tmp.next 之间
                pre.next = cur.next;
                cur.next = tmp.next;
                tmp.next = cur;
                // 完成插入后，cur 回到 pre 前面
                cur = pre.next;
            }
        }
        return vHead.next;
    }
}
