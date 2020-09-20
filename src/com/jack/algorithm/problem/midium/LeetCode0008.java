package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0008 {

    private long iMax = Integer.MAX_VALUE;
    private long max = iMax + 1;
    public int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        int res = 0;
        char firstCh = str.charAt(0);
        if (firstCh == '-') {
            if (len > 1) {
                long val = doAtoi(str, 1);
                if (val >= max) {
                    res = Integer.MIN_VALUE;
                } else {
                    res = - (int) val;
                }
            }
        }else if (firstCh == '+') {
            if (len > 1) {
                long val = doAtoi(str, 1);
                if (val >= max) {
                    res = Integer.MAX_VALUE;
                } else {
                    res = (int) val;
                }
            }
        } else if (isNum(firstCh)) {
            long val = doAtoi(str, 0);
            if (val >= max) {
                res = Integer.MAX_VALUE;
            } else {
                res = (int) val;
            }
        }
        return res;
    }
    private boolean isNum ( char ch){
        return ch >= '0' && ch <= '9';
    }
    private long doAtoi(String str, int startIndex) {
        char ch = str.charAt(startIndex);
        if (isNum(ch)) {
            int endIndex = startIndex;
            for (int i = startIndex + 1; i < str.length(); i++) {
                ch = str.charAt(i);
                if (!isNum(ch)) {
                    break;
                }
                endIndex = i;
            }
            try {
                return Long.valueOf(str.substring(startIndex, endIndex + 1));
            } catch (NumberFormatException e) {
                return max;
            }
        }
        return 0;
    }

    public int myAtoi2(String str) {
        str = str.trim();
        long res = 0;
        boolean flag = true;
        if (str.length() == 0) {
            return 0;
        }
        char firstCh = str.charAt(0);
        if (firstCh == '-') {
            flag = false;
        } else if (Character.isDigit(firstCh)) {
            res = firstCh - '0';
        } else {
            if (firstCh != '+') {
                return 0;
            }
        }
        int i = 1;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            res = res * 10 + (str.charAt(i) - '0');
            if (flag && res >= Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
                break;
            }
            if (!flag && res >= (Integer.MAX_VALUE + 1L)) {
                res = Integer.MAX_VALUE + 1L;
                break;
            }
            i ++;
        }
        return flag ? (int) res : - (int) res;
    }

    public static void main(String[] args) {
        LeetCode0008 main = new LeetCode0008();
        System.out.println(main.myAtoi("42"));
        System.out.println(main.myAtoi("       -42"));
        System.out.println(main.myAtoi("4193 with words"));
        System.out.println(main.myAtoi("words and 987"));
        System.out.println(main.myAtoi("-91283472332"));
        System.out.println(main.myAtoi("+1"));
        System.out.println(main.myAtoi("20000000000000000000"));
        System.out.println(main.myAtoi("9223372036854775807"));
        System.out.println("=======================");
        System.out.println(main.myAtoi2("42"));
        System.out.println(main.myAtoi2("       -42"));
        System.out.println(main.myAtoi2("4193 with words"));
        System.out.println(main.myAtoi2("words and 987"));
        System.out.println(main.myAtoi2("-91283472332"));
        System.out.println(main.myAtoi2("+1"));
        System.out.println(main.myAtoi2("20000000000000000000"));
        System.out.println(main.myAtoi2("9223372036854775807"));
    }
}