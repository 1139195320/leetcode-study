package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode1190 {

    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (start != i) {
                    stack.push(s.substring(start, i));
                }
                stack.push("(");
                start = i + 1;
            } else if (c == ')') {
                if (start != i) {
                    stack.push(s.substring(start, i));
                }
                doReverseParentheses(stack);
                start = i + 1;
            } else {
                if (i == s.length() - 1) {
                    if (start != i + 1) {
                        stack.push(s.substring(start));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append(str);
        }
        return sb.toString();
    }
    private void doReverseParentheses(Stack<String> stack) {
        String cur = stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!"(".equals(cur)) {
            sb.insert(0, cur);
            cur = stack.pop();
        }
        if (sb.length() > 0) {
            stack.push(reverseString(sb.toString()));
        }
    }
    private String reverseString(String target) {
        StringBuilder sb = new StringBuilder(target.length());
        for (int i = target.toCharArray().length - 1; i >= 0; i--) {
            sb.append(target.charAt(i));
        }
        return sb.toString();
    }



    public String reverseParentheses2(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[n];
        // 寻找匹配的括号
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                // 遇到括号，开始颠倒方向
                i = pair[i];
                d = -d;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LeetCode1190 main = new LeetCode1190();
        // "dcba"
        System.out.println(main.reverseParentheses("(abcd)"));
        // "iloveu"
        System.out.println(main.reverseParentheses("(u(love)i)"));
        // "leetcode"
        System.out.println(main.reverseParentheses("(ed(et(oc))el)"));
        // "apmnolkjihgfedcbq"
        System.out.println(main.reverseParentheses("a(bcdefghijkl(mno)p)q"));

        System.out.println(main.reverseParentheses("()"));
        System.out.println(main.reverseParentheses(""));
        System.out.println(main.reverseParentheses("abc"));
    }
}