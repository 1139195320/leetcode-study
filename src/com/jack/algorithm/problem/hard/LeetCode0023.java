package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0023 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val);
                cur = cur.next;
                if (cur != null) {
                    sb.append("->");
                }
            }
            return sb.toString();
        }
        public ListNode(int ... valArr) {
            if (valArr != null && valArr.length > 0) {
                this.val = valArr[0];
                ListNode curNext = null;
                for (int i = 1; i < valArr.length; i++) {
                    ListNode newNode = new ListNode(valArr[i]);
                    if (curNext == null) {
                        this.next = newNode;
                        curNext = this.next;
                    } else {
                        curNext.next = newNode;
                        curNext = newNode;
                    }
                }
            }
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        ListNode curNext = null;
        int sizeLen = lists.length;
        while (sizeLen > 0) {
            sizeLen = lists.length;
            int tIndex = 0;
            int curVal = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode curNode = lists[i];
                if (curNode != null) {
                    if (curNode.val < curVal) {
                        curVal = curNode.val;
                        tIndex = i;
                    }
                } else {
                    sizeLen --;
                }
            }
            ListNode oldNode = lists[tIndex];
            if (oldNode != null) {
                ListNode newNode = new ListNode(oldNode.val);
                if (res == null) {
                    res = newNode;
                } else {
                    if (curNext == null) {
                        res.next = newNode;
                        curNext = res.next;
                    } else {
                        curNext.next = newNode;
                        curNext = newNode;
                    }
                }
                lists[tIndex] = oldNode.next;
                if (lists[tIndex] == null) {
                    sizeLen --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0023 main = new LeetCode0023();
        System.out.println(main.mergeKLists(getLists()));
    }

    private static ListNode[] getLists() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, 4, 5);
        lists[1] = new ListNode(1, 3, 4);
        lists[2] = new ListNode(2, 6);
        return lists;
    }
}
