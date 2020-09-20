package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0925 {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        char preC = name.charAt(0);
        while (i < name.length()) {
            if (j >= typed.length()) {
                // typed 没有匹配完全的 name
                return false;
            }
            char c = name.charAt(i);
            char typedC = typed.charAt(j);
            if (c == typedC) {
                // 当前相同，未重复
                i ++;
                j ++;
                preC = c;
            }
            else if (preC == typedC) {
                // 当前是上个字符的重复
                j ++;
            }
            else {
                return false;
            }

        }
        while (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(name.length() - 1)) {
                return false;
            }
            j ++;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0925 main = new LeetCode0925();
        System.out.println(main.isLongPressedName(
                "alex", "aaleex"
        ));
        System.out.println(main.isLongPressedName(
                "saeed", "ssaaedd"
        ));
        System.out.println(main.isLongPressedName(
                "leelee", "lleeelee"
        ));
        System.out.println(main.isLongPressedName(
                "laiden", "laiden"
        ));
    }
}