package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0071 {

    public String simplifyPath(String path) {
        // 过滤多个连续的 '/'
        path = path.replaceAll("/+", "/");
        // 过滤掉 '/./'
        path = path.replaceAll("/(\\./)+", "/");
        // 过滤掉 '../'
        StringBuilder res = new StringBuilder("/");
        for (int i = 1; i < path.length(); i++) {
            int r1index = i + 1;
            int r2index = i + 2;
            if (path.charAt(i) == '.'
                    && (path.charAt(i - 1) == '/')
                    && (r1index < path.length() && path.charAt(r1index) == '.')
                    && (r2index >= path.length() || path.charAt(r2index) == '/')) {
                if (res.length() > 1) {
                    res = new StringBuilder(res.substring(0, res.length() - 1));
                    res = new StringBuilder(res.substring(0, res.lastIndexOf("/") + 1));
                }
                i += 2;
            } else {
                res.append(path.charAt(i));
            }
        }
        path = res.toString();
        // 过滤末尾的 '/.'
        if (path.endsWith("/.")) {
            path = path.substring(0, path.length() - 1);
        }
        // 过滤末尾的 '/'
        int index = path.lastIndexOf("/");
        if (path.length() > 1 && index == path.length() - 1) {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }

    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (String str : arr) {
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!"".equals(str) && !".".equals(str)) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder(path.length());
        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0071 main = new LeetCode0071();
        System.out.println(main.simplifyPath("/home/"));
        System.out.println(main.simplifyPath("/../"));
        System.out.println(main.simplifyPath("/home//foo/"));
        System.out.println(main.simplifyPath("/a/./b/../../c/"));
        System.out.println(main.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(main.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(main.simplifyPath("/..."));
        System.out.println(main.simplifyPath("/...a"));
        System.out.println(main.simplifyPath("/.../b"));
        System.out.println(main.simplifyPath("/c.../b"));
        System.out.println(main.simplifyPath("//./."));
        System.out.println();
        System.out.println("================================");
        System.out.println();
        System.out.println(main.simplifyPath2("/home/"));
        System.out.println(main.simplifyPath2("/../"));
        System.out.println(main.simplifyPath2("/home//foo/"));
        System.out.println(main.simplifyPath2("/a/./b/../../c/"));
        System.out.println(main.simplifyPath2("/a/../../b/../c//.//"));
        System.out.println(main.simplifyPath2("/a//b////c/d//././/.."));
        System.out.println(main.simplifyPath2("/..."));
        System.out.println(main.simplifyPath2("/...a"));
        System.out.println(main.simplifyPath2("/.../b"));
        System.out.println(main.simplifyPath2("/c.../b"));
        System.out.println(main.simplifyPath2("//./."));
    }
}
