package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium10105 {

    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        boolean opportunity = true;
        int i = 0;
        int j = 0;
        while (i < first.length() && j < second.length()) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if (c1 == c2) {
                i ++;
                j ++;
            } else {
                if (!opportunity) {
                    // 没有更换的机会
                    return false;
                }
                if (len1 > len2) {
                    // 只能删除
                    i ++;
                } else if (len1 == len2) {
                    // 只能修改
                    i ++;
                    j ++;
                } else {
                    // 只能插入
                    j ++;
                }
                // 机会已用
                opportunity = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Medium10105 main = new Medium10105();
        System.out.println(main.oneEditAway("pale", "ple"));
        System.out.println(main.oneEditAway("pales", "pal"));
        System.out.println(main.oneEditAway("pales", "pale"));
        System.out.println(main.oneEditAway("pales", "pales"));
    }
}