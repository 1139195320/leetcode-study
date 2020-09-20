package com.jack.algorithm.problem.pre;

import java.util.Stack;

/**
 * @author jack
 */
public class Medium11626 {

    public int calculate(String s) {
        int i = 0;
        int preChar = ' ';
        Stack<String> stack = new Stack<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            i ++;
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                stack.push(c + "");
            } else if (c == '+' || c == '-') {
                if (preChar != ' ') {
                    // 往前计算前面的 + -
                    calc(stack, false);
                }
                preChar = c;
                stack.push(c + "");
            } else if (c == '*' || c == '/') {
                // 计算前面的一个 * /
                if (preChar == '*' || preChar == '/') {
                    calc(stack, true);
                }
                preChar = c;
                stack.push(c + "");
            }
        }
        calc(stack, false);
        return stack.empty() ? 0 : Integer.parseInt(stack.pop());
    }
    private void calc(Stack<String> stack, boolean once) {
        if (stack.size() <= 1) {
            return;
        }
        Integer right = null;
        int ten = 10;
        while (!stack.empty()) {
            int tmp = 1;
            if (right == null) {
                right = 0;
                while (!stack.empty()) {
                    if (!Character.isDigit(stack.peek().charAt(0))) {
                        break;
                    }
                    right += Integer.parseInt(stack.pop()) * tmp;
                    tmp *= ten;
                }
            }
            char preChar = stack.pop().charAt(0);
            int left = 0;
            tmp = 1;
            while (!stack.empty()) {
                if (!Character.isDigit(stack.peek().charAt(0))) {
                    break;
                }
                left += Integer.parseInt(stack.pop()) * tmp;
                tmp *= ten;
            }
            if (preChar == '*') {
                right = left * right;
            }
            else if (preChar == '/'){
                right = left / right;
            }
            else if (preChar == '+') {
                right = left + right;
            } else {
                right = left - right;
            }
            if (once) {
                break;
            }
        }
        stack.push(right + "");
    }

    public int calculate2(String s) {
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
        Medium11626 main = new Medium11626();
        System.out.println(main.calculate("1+222*1 + 2- 5 / 5+ 10 * 2+1+1+2*3"));
        System.out.println(main.calculate2("1+222*1 + 2- 5 / 5+ 10 * 2+1+1+2*3"));
    }
}