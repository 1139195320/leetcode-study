package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0086 {

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

    public ListNode partition(ListNode head, int x) {
        ListNode vNode = new ListNode(-1);
        vNode.next = head;
        ListNode cur = vNode;
        ListNode l = cur;
        boolean flag = false;
        int tag = 0;
        while (cur.next != null) {
            if (cur.next.val >= x) {
                // 找到第一个比 x 大的了
                if (tag == 0) {
                    l = cur;
                    tag = -1;
                    flag = true;
                }
            } else {
                if (flag) {
                    // 如果前面已经找到了比 x 大的节点
                    ListNode tmp = cur.next;
                    cur.next = cur.next.next;
                    tmp.next = l.next;
                    l.next = tmp;
                    l = l.next;
                    continue;
                }
            }
            cur = cur.next;
        }
        return vNode.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode vHead1 = new ListNode(0);
        ListNode head1 = vHead1;
        ListNode vHead2 = new ListNode(0);
        ListNode head2 = vHead2;
        while (head != null) {
            if (head.val < x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        head2.next = null;
        head1.next = vHead2.next;
        return vHead1.next;
    }

    public static void main(String[] args) {
        LeetCode0086 main = new LeetCode0086();
        System.out.println(main.getListNode(1,4,3,2,5,2));
        System.out.println(main.partition(
                main.getListNode(1,4,3,2,5,2), 3)
        );
    }
}