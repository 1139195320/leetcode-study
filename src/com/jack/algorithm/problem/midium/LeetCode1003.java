package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode1003 {

    public boolean isValid(String S) {
        if (S == null || S.length() % 3 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char curC = S.charAt(i);
            if (stack.empty()) {
                stack.push(curC);
            } else {
                if (i != S.length() - 1
                        && stack.peek() == 'a'
                        && curC == 'b'
                        && S.charAt(i + 1) == 'c') {
                    // 前面有 a ，当前是 b 后面是 c
                    stack.pop();
                    i ++;
                    continue;
                }
                else if (stack.size() >= 2) {
                    char m = stack.pop();
                    if (stack.peek() == 'a'
                            && m == 'b'
                            && curC == 'c') {
                        // 前面有 ab ，当前是 c
                        stack.pop();
                        continue;
                    } else {
                        stack.push(m);
                    }
                }
                stack.push(curC);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        LeetCode1003 main = new LeetCode1003();
        System.out.println(main.isValid("aabcbc"));
        System.out.println(main.isValid("ababcc"));
        System.out.println(main.isValid("ababaabcbccc"));
        System.out.println(main.isValid("abcabcababcc"));
        System.out.println(main.isValid("abccba"));
        System.out.println(main.isValid("cababc"));
        System.out.println(main.isValid("abcabc"));
    }
}