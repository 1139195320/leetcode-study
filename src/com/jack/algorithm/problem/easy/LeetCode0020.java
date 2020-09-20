package com.jack.algorithm.problem.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jack
 * 有效的括号
 */
public class LeetCode0020 {

    public boolean isValid(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.keySet().contains(c)) {
                // 是左括号
                stack.add(c);
            }
            if (map.values().contains(c)) {
                // 是右括号
                if (stack.empty()) {
                    return false;
                }
                char left = stack.pop();
                if (map.get(left) != c) {
                    // 括号不对应
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        LeetCode0020 main = new LeetCode0020();
        System.out.println(main.isValid(""));
        System.out.println(main.isValid("{"));
        System.out.println(main.isValid("[}"));
        System.out.println(main.isValid("([)]"));
        System.out.println(main.isValid("([{}])"));
    }
}
