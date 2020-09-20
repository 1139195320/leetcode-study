package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode10020 {

    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        byte countE = 0;
        byte countDot = 0;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                continue;
            }
            if (c == '.') {
                if (n == 1) {
                    return false;
                }
                if (countDot == 0 && i > 0){
                    char pre = arr[i - 1];
                    if((Character.isDigit(pre))) {
                        if (i == n - 1 || Character.isDigit(arr[i + 1])
                                || arr[i + 1] == 'E' || arr[i + 1] == 'e') {
                            countDot = 1;
                            continue;
                        }
                    }
                    if (pre == '+' || pre == '-') {
                        if (i != n - 1 && Character.isDigit(arr[i + 1])) {
                            countDot = 1;
                            continue;
                        }
                    }
                }
                if (i == 0 && Character.isDigit(arr[i + 1])) {
                    countDot = 1;
                    continue;
                }
            }
            if (i == n - 1) {
                return false;
            }
            if (c == '+' || c == '-') {
                if (i == 0 || arr[i - 1] == 'E'
                        || arr[i - 1] == 'e') {
                    continue;
                }
            }
            if (c == 'e' || c == 'E') {
                if (countE == 0 && i > 0) {
                    char pre = arr[i - 1];
                    if (Character.isDigit(pre) || pre == '.') {
                        countE = 1;
                        countDot = 1;
                        continue;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode10020 main = new LeetCode10020();
        String[] arr1 = new String[]{"+100", "5e2", "-123", "3.1416",
                "-1E-16", "0123", "+.8", ".1", "46.e3", " 005047e+6"};
        String[] arr2 = new String[]{"12e", "1a3.14", "1.2.3",
                "+-5", "12e+5.4", "6e6.5"};
        for (String s : arr1) {
            System.out.print(main.isNumber(s) + "\t");
        }
        System.out.println();
        for (String s : arr2) {
            System.out.print(main.isNumber(s) + "\t");
        }
    }

}