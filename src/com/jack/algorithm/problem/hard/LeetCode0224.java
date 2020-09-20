package com.jack.algorithm.problem.hard;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0224 {

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        StringBuilder preSb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                if (preSb.length() != 0) {
                    stack.push(preSb.toString());
                    preSb = new StringBuilder();
                }
                doCalculate(stack);
            } else if (c >= '0' && c <= '9') {
                // 是数字
                preSb.insert(0, c);
                if (i == 0) {
                    stack.push(preSb.toString());
                }
            } else {
                // 是 + - )
                if (preSb.length() != 0) {
                    stack.push(preSb.toString());
                    preSb = new StringBuilder();
                }
                stack.push(c + "");
            }
        }
        doCalculate(stack);
        return Integer.parseInt(stack.pop());
    }
    private void doCalculate(Stack<String> stack) {
        if (stack.empty()) {
            return;
        }
        // 有 "(" 进来，到 ")" 结束
        String cur = stack.pop();
        boolean init = false;
        String pre = "";
        int res = -1;
        while (!")".equals(cur)) {
            if ("(".equals(cur)) {
                doCalculate(stack);
            } else if ("+".equals(cur) || "-".equals(cur)) {
                pre = cur;
            } else {
                if (res == -1 && !init) {
                    res = Integer.parseInt(cur);
                    init = true;
                } else {
                    if ("+".equals(pre)) {
                        res += Integer.parseInt(cur);
                    } else {
                        res -= Integer.parseInt(cur);
                    }
                }
            }
            if (stack.size() == 0) {
                break;
            }
            cur = stack.pop();
        }
        stack.push(res + "");
    }

    public static void main(String[] args) {
        LeetCode0224 main = new LeetCode0224();
        System.out.println(main.calculate(" 1 "));
        System.out.println(main.calculate("2147483647"));
        System.out.println(main.calculate("1 + 4"));
        System.out.println(main.calculate("(1 + 4)"));
        System.out.println(main.calculate("(1 + 4)-2"));
        System.out.println(main.calculate("8-((1 + 4)-2)+5"));
        System.out.println(main.calculate("(1 + 2 + 3) - (1 + 2) + 4"));
        System.out.println(main.calculate("(9568+(9040-(380+(2042-(7115)+(6294)-(4395-(5183+9744+(7746-(1099+2718))-(9370-(8561+(9302)-(7632+(8451-(1759+(7760))-(3377+5363+9093+(8332-(4492-(1151+(1165-8833+(775+(3749)+9399))+9112+(6273+(7285-(6112-(668-(7756-4316-(582+1835-(6644+690+1204-(7197+(7897))+(7009-(7262))-7782-(7858+(7644+(9461+(2224)-(7531-1095-(891+1022)+2197-(9855)))+(6663-(7417-(6158-(3610))+(1481))-(4182+(4761)))+(5017))+(9990)+(6218)))-(2904)+(5631)-(8888)+3401+(3569))+(1135))-(3695-(7713+(3479)-(9813+(8171+(8616-8026+(4634-(6973))-(9761-(623-4782)+(2514)+(6233)))))+(6140))-(6641)-8611+(8389)+8074-(4412))-(3703)+(9688+(9513))))-(4987)))+(9647)))))))))-(2299))-(4785))))))"));
        System.out.println(main.calculate("0-(1+(2))"));
    }
}