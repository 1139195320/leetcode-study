package com.jack.algorithm.problem.easy;

import java.util.Stack;

/**
 * @author jack
 * 比较含退格的字符串
 */
public class LeetCode0844 {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        arrToStack(arrS, stackS);
        arrToStack(arrT, stackT);
        if (stackS.size() != stackT.size()) {
            return false;
        }
        for (int i = 0; i < stackS.size(); i++) {
            if (!stackS.pop().equals(stackT.pop())) {
                return false;
            }
        }
        return true;
    }
    private void arrToStack(char[] arr, Stack<Character> stack) {
        // 将数组中的元素按规则压入栈
        for (char c : arr) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0844 main = new LeetCode0844();
        System.out.println(main.backspaceCompare("ab#c", "ad#c"));
        System.out.println(main.backspaceCompare("ab##", "c#d#"));
        System.out.println(main.backspaceCompare("a#c", "#b"));
    }
}
