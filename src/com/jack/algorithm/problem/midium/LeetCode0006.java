package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0006 {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int dir = (numRows - 1) << 1;
        int cur = 0;
        while (cur < s.length()) {
            sb.append(s.charAt(cur));
            cur += dir;
        }
        for (int i = 1; i < numRows - 1; i++) {
            cur = i;
            int dir2 = i << 1;
            int dir1 = dir - dir2;
            boolean flag = true;
            while (cur < s.length()) {
                sb.append(s.charAt(cur));
                if (flag) {
                    cur += dir1;
                    flag = false;
                } else {
                    cur += dir2;
                    flag = true;
                }
            }
        }
        if (numRows > 1) {
            cur = numRows - 1;
            while (cur < s.length()) {
                sb.append(s.charAt(cur));
                cur += dir;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0006 main = new LeetCode0006();
        System.out.println(main.convert(
                "LEETCODEISHIRING", 3
        ));
        System.out.println(main.convert(
                "LEETCODEISHIRING", 4
        ));
    }
}
