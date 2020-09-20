package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode10067 {

    public int strToInt(String str) {
        str = str.trim();
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        boolean flag = true;
        char[] arr = str.toCharArray();
        int end = 0;
        int start = 0;
        if (arr[0] == '-' || arr[0] == '+') {
            if (arr[0] == '-') {
                flag = false;
            }
            if (n == 1 || !Character.isDigit(arr[1])) {
                return 0;
            }
            start = 1;
            end = 1;
        }
        else if (!Character.isDigit(arr[0])) {
            return 0;
        }
        while (end < n
                && Character.isDigit(arr[end])) {
            end ++;
        }
        if (!flag && end == 1 || end == 0) {
            return 0;
        }
        end --;
        while (start < end && arr[start] == '0') {
            start ++;
        }
        int len = end - start + 1;
        int maxLen = 10;
        char[] max = "2147483647".toCharArray();
        if (len > maxLen) {
            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        else if (len == maxLen) {
            for (int i = 0; i < maxLen; i++) {
                char cur = arr[i + start];
                if (cur > max[i]) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else if (cur < max[i]) {
                    break;
                }
            }
        }
        int res = Integer.parseInt(str.substring(start, end + 1));
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        LeetCode10067 main = new LeetCode10067();
        System.out.println(main.strToInt(" 42"));
        System.out.println(main.strToInt("-42"));
        System.out.println(main.strToInt("hello 30"));
        System.out.println(main.strToInt("33 world"));
        System.out.println(main.strToInt("2147483647"));
        System.out.println(main.strToInt("2147483648"));
        System.out.println(main.strToInt("-2147483647"));
        System.out.println(main.strToInt("-2147483648"));
        System.out.println(main.strToInt("-2147483649"));
    }
}