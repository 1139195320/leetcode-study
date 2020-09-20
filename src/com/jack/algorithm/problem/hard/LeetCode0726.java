package com.jack.algorithm.problem.hard;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author jack
 *
 * 未解决
 */
public class LeetCode0726 {

    public static void main(String[] args) {
        LeetCode0726 main = new LeetCode0726();
        System.out.println(main.countOfAtoms(
                ""
        ));
        System.out.println(main.countOfAtoms(
                "H11He49NO35B7N46Li20"
        ));
        System.out.println(main.countOfAtoms(
                "()K1((O)3)1"
        ));
        System.out.println(main.countOfAtoms(
                "KMgH3O5"
        ));
        System.out.println(main.countOfAtoms(
                "(KMgH3O5)"
        ));
        System.out.println(main.countOfAtoms(
                "Mg(OH)2"
        ));
        System.out.println(main.countOfAtoms(
                "K4(ON(SO3)2)2"
        ));
    }

    public String countOfAtoms(String formula) {
        Stack<String> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                String tmpStr = "";
                if (!stack.empty() && !"(".equals(stack.peek())) {
                    tmpStr = stack.pop();
                }
                if (start != i) {
                    // 两个 '(' 之间的字符串
                    tmpStr += formula.substring(start, i);
                }
                stack.push(tmpStr);
                stack.push("(");
                start = i + 1;
            } else if (c == ')') {
                TreeMap<String, Integer> tmpMap =
                        doCountOfString(formula.substring(start, i));
                int nextI = i + 1;
                if (nextI < formula.length()) {
                    // 存在下一个字符
                    char tmpC = formula.charAt(nextI);
                    if (Character.isDigit(tmpC)) {
                        // 下一个字符是数字
                        if (start == i && !"(".equals(stack.peek())) {
                            tmpMap = doCountOfString(stack.pop());
                        }
                        cal(tmpMap, tmpC - '0');
                        i ++;
                    }
                }
                if ("(".equals(stack.peek())) {
                    // 删去对应的 '('
                    stack.pop();
                }
                if (!"(".equals(stack.peek())) {
                    // 当前这个 "( ... )" 前面还有字符串
                    TreeMap<String, Integer> preMap = doCountOfString(stack.pop());
                    addMap(tmpMap, preMap);
                }

                stack.push(map2str(tmpMap));
                start = i + 1;
            }
        }
        if (start != formula.length()) {
            stack.push(formula.substring(start));
        }
        return stack.empty() ? "" : stack.pop();
    }

    private TreeMap<String, Integer> doCountOfString(String str) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isUpper(c)) {
                // 当前字符是大写字符
                int nextI = i + 1;
                if (nextI < str.length()) {
                    // 存在下一个字符
                    if (isUpper(str.charAt(nextI))) {
                        // 下一个字符是大写
                        map.put(c + "", map.getOrDefault(c + "", 0) + 1);
                    } else if (isLower(str.charAt(nextI))) {
                        // 下一个字符是小写
                        String tmp = str.substring(i, i + 2);
                        nextI ++;
                        i ++;
                        if (nextI < str.length()) {
                            // 下下一个字符存在（只能是大写字符或数字）
                            c = str.charAt(nextI);
                            if (Character.isDigit(c)) {
                                // 下下一个字符是数字
                                map.put(tmp,
                                        map.getOrDefault(tmp, 0) + (c - '0'));
                                i ++;
                            } else {
                                // 下下一个字符不是数字
                                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                            }
                        } else {
                            // 下下一个字符不存在
                            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                        }
                    } else {
                        // 下一个字符是数字
                        map.put(c + "",
                                map.getOrDefault(c + "", 0) + (str.charAt(nextI) - '0'));
                        i ++;
                    }
                } else {
                    // 不存在下一个字符
                    map.put(c + "", map.getOrDefault(c + "", 0) + 1);
                }
            } else {
                System.out.println(" => " + c);
            }
        }
        return map;
    }
    private boolean isUpper(char c) {
        return c <='Z' && c >= 'A';
    }
    private boolean isLower(char c) {
        return c <='z' && c >= 'a';
    }
    private void cal(TreeMap<String, Integer> map, int n) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() * n);
        }
    }
    private String map2str(TreeMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            sb.append(entry.getKey());
            if (val > 1) {
                sb.append(val);
            }
        }
        return sb.toString();
    }
    private void addMap(TreeMap<String, Integer> allMap, TreeMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            allMap.put(entry.getKey(),
                    allMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
}