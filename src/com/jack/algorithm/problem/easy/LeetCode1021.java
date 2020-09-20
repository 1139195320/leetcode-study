package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1021 {

    public String removeOuterParentheses(String S) {
        int start = 0;
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left != 0 && left == right) {
                sb.append(S, start + 1, i);
                left = 0;
                right = 0;
                start = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1021 main = new LeetCode1021();
        System.out.println(main.removeOuterParentheses("(()())(())"));
        System.out.println(main.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(main.removeOuterParentheses("()()"));
        System.out.println("()()".substring(1, 1));
    }
}