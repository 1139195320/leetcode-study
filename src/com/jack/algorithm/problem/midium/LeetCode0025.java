package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0025 {

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
                if (cur.next != null) {
                    sb.append(", ");
                }
                cur = cur.next;
            }
            return sb.toString();
        }
        private ListNode(int ... valArr) {
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

    /**
     * arr 中存 1-3 个元素
     * 第一个：截取出的长度为 n 的子链表，若总长度小于 n，则为原链表
     * 第二个：截取 n 的子链表之后剩余的链表，可空
     * 第三个：flag 可空，若有值，表示第一个子链表需要翻转
     **/
    private ListNode[] checkNodeN(ListNode leftNode, int n) {
        int i = 0;
        ListNode[] res = new ListNode[3];
        ListNode leftEndNode = leftNode;
        while (leftEndNode != null) {
            i ++;
            if (i == n) {
                ListNode tmpNode = leftEndNode.next;
                leftEndNode.next = null;
                res[0] = leftNode;
                res[1] = tmpNode;
                res[2] = new ListNode();
                return res;
            }
            leftEndNode = leftEndNode.next;
        }
        if (i != 0) {
            res[0] = leftNode;
            return res;
        }
        return null;
    }

    /**
     * arr 中存 2 个元素
     * 第一个：该链表的翻转链表
     * 第二个：翻转之后的链表尾
     **/
    private ListNode[] reverseNodeN(ListNode node) {
        ListNode[] res = new ListNode[2];
        ListNode preNode = node;
        ListNode curNode = node.next;
        ListNode nextNode;
        boolean flag = true;
        while (curNode != null) {
            nextNode = curNode.next;
            if (flag) {
                preNode.next = null;
                flag = false;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        res[0] = preNode;
        res[1] = node;
        return res;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curNode = head;
        ListNode res = null;
        ListNode tail = null;
        while (curNode != null) {
            ListNode[] nodeArr = checkNodeN(curNode, k);
            if (nodeArr == null) {
                break;
            }
            ListNode leftNode = nodeArr[0];
            curNode = nodeArr[1];
            if (curNode != null || nodeArr[2] != null) {
                ListNode[] reverseNodeArr = reverseNodeN(leftNode);
                if (res == null) {
                    res = reverseNodeArr[0];
                } else {
                    tail.next = reverseNodeArr[0];
                }
                tail = reverseNodeArr[1];
            } else {
                if (tail != null) {
                    tail.next = leftNode;
                } else {
                    res = leftNode;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0025 main = new LeetCode0025();
        System.out.println(main.reverseKGroup(new ListNode(), 1));
        System.out.println(main.reverseKGroup(new ListNode(3), 0));
        System.out.println(main.reverseKGroup(new ListNode(3), 2));
        System.out.println(main.reverseKGroup(new ListNode(1, 2, 3, 4, 5), 2));
        System.out.println(main.reverseKGroup(new ListNode(1, 2, 3, 4, 5), 3));
        System.out.println(main.reverseKGroup(new ListNode(1, 2, 3, 4, 5), 4));
        System.out.println(main.reverseKGroup(new ListNode(1, 2, 3, 4, 5), 5));
        System.out.println(main.reverseKGroup(new ListNode(1, 2, 3, 4, 5), 6));
    }

}
