package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode11626 {

    public int calculate(String s) {
        int i = 0;
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()) {
            char c = arr[i];
            if (c == ' ') {
                // 过滤掉空格
                i ++;
                continue;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                i ++;
                while (i < s.length() && arr[i] == ' ') {
                    // 过滤掉空格
                    i ++;
                }
            }
            int num = 0;
            if (Character.isDigit(arr[i])) {
                // 拼出数字
                while (i < s.length() && Character.isDigit(arr[i])) {
                    num = num * 10 + (arr[i ++] - '0');
                }
            }
            if (c == '-') {
                num = - num;
            }
            else if (c == '*') {
                num *= stack.pop();
            }
            else if (c == '/') {
                num = stack.pop() / num;
            }
            stack.push(num);
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode11626 main = new LeetCode11626();
        System.out.println(main.calculate("1+222*1 + 2- 5 / 5+ 10 * 2+1+1+2*3"));
    }
}