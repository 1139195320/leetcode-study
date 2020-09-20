package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode007102 {

    public String simplifyPath(String path) {
        path = path.trim();
        String[] strArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strArr) {
            if ("..".equals(str)) {
                if (!stack.empty()) {
                    stack.pop();
                }
                continue;
            }
            if ("".equals(str) || ".".equals(str)) {
                continue;
            }
            stack.push(str);
        }
        StringBuilder sb = new StringBuilder();
        if (stack.empty()) {
            return "/";
        }
        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode007102 main = new LeetCode007102();
        System.out.println(main.simplifyPath("/home/"));
        System.out.println(main.simplifyPath("/../"));
        System.out.println(main.simplifyPath("/home//foo/"));
        System.out.println(main.simplifyPath("/a/./b/../../c/"));
        System.out.println(main.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(main.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(main.simplifyPath("/a//c..b////c/d//././/.."));
    }
}
