package com.jack.algorithm.problem.midium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jack
 */
public class LeetCode0402 {

    public String removeKdigits(String num, int k) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (queue.size() > 0 && k > 0
                    && queue.peekLast() > c) {
                queue.removeLast();
                k --;
            }
            queue.addLast(c);
        }
        for (int i = 0; i < k; i++) {
            queue.removeLast();
        }
        if (queue.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.remove();
            sb.append(cur);
        }
        int i = 0;
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == '0') {
                i ++;
            } else {
                break;
            }
        }
        return i == sb.length() ? "0" : sb.substring(i);
    }

    public static void main(String[] args) {
        LeetCode0402 main = new LeetCode0402();
        System.out.println(main.removeKdigits("1432239", 3));
        System.out.println(main.removeKdigits("10200", 1));
        System.out.println(main.removeKdigits("10", 2));
    }
}