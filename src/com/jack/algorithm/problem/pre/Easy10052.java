package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy10052 {

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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        boolean flag = false;
        while (node1.val != node2.val) {
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == null) {
                if (flag) {
                    return null;
                }
                flag = true;
                node1 = headB;
            }
            if (node2 == null) {
                node2 = headA;
            }
        }
        return node1;
    }

    public static void main(String[] args) {
        Easy10052 main = new Easy10052();
        System.out.println(main.getIntersectionNode(
                main.getListNode(2, 4, 3, 5, 6),
                main.getListNode(1, 2, 3, 5, 6)
        ));
    }
}