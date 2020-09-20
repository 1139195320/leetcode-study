package com.jack.algorithm.problem.pre;

import java.util.Stack;

/**
 * @author jack
 */
public class Medium1209 {

    public String removeDuplicates(String s, int k) {
        // 0: 字符 - 'a' 1:个数
        Stack<Integer[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek()[0] == (c - 'a')) {
                Integer[] arr = stack.pop();
                if (arr[1] + 1 < k) {
                    arr[1] += 1;
                    stack.push(arr);
                }
            } else {
                Integer[] arr = new Integer[2];
                arr[0] = c - 'a';
                arr[1] = 1;
                stack.push(arr);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer[] arr : stack) {
            for (Integer i = 0; i < arr[1]; i++) {
                sb.append((char) (arr[0] + 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium1209 main = new Medium1209();
        System.out.println(main.removeDuplicates(
                "abcd", 2
        ));
        System.out.println(main.removeDuplicates(
                "deeedbbcccbdaa", 3
        ));
        System.out.println(main.removeDuplicates(
                "pbbcggttciiippooaais", 2
        ));
    }
}