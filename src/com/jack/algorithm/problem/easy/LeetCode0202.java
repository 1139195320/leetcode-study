package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fy
 */
public class LeetCode0202 {

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        int cur = n;
        list.add(cur);
        boolean res = false;
        while (true) {
            int temp = 0;
            int a = cur % 10;
            int b = cur / 10;
            temp += (a * a);
            while (b != 0) {
                a = b % 10;
                b = b / 10;
                temp += (a * a);
            }
            if (temp == 1) {
                res = true;
                break;
            }
            if (list.contains(temp)) {
                break;
            }
            list.add(temp);
            cur = temp;
        }
        return res;
    }

    public int getNext(int cur) {
        int temp = 0;
        int a = cur % 10;
        int b = cur / 10;
        temp += (a * a);
        while (b != 0) {
            a = b % 10;
            b = b / 10;
            temp += (a * a);
        }
        return temp;
    }
    public boolean isHappy2(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = n;
        boolean res = false;
        while (true) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (slow == 1 || fast == 1) {
                res = true;
                break;
            }
            if (slow == fast) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0202 main = new LeetCode0202();
        System.out.println(main.isHappy(19));
        System.out.println(main.isHappy(20));
        System.out.println(main.isHappy(2));
        System.out.println(main.isHappy2(19));
        System.out.println(main.isHappy2(20));
        System.out.println(main.isHappy2(2));
    }
}
