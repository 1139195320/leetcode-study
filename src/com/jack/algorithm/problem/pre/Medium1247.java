package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1247 {

    public int minimumSwap(String s1, String s2) {
        // 1 和 2 中分别错乱的 x 和 y 数
        int n = s1.length();
        if (n != s2.length()) {
            return -1;
        }
        int[][] arr = new int[2][2];
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (c1 == 'x') {
                arr[0][0] ++;
                arr[1][1] ++;
            } else {
                arr[0][1] ++;
                arr[1][0] ++;
            }
        }
        int countX = arr[0][0] + arr[1][0];
        int countY = arr[0][1] + arr[1][1];
        if (countX != countY
                || (countX & 1) != 0
                || (countY & 1) != 0) {
            return -1;
        }
        return arr[0][0] / 2 + arr[0][1] / 2 +
                Math.max(arr[0][0], arr[0][1]) % 2 * 2;
    }

    public int minimumSwap2(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return -1;
        }
        int xy = 0, yx = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (c1 == 'x') {
                xy ++;
            } else {
                yx ++;
            }
        }
        return ((xy + yx) & 1) != 0
                ? -1 : (xy + 1) / 2 + (yx + 1) / 2;
    }

    public static void main(String[] args) {
        Medium1247 main = new Medium1247();
        System.out.println(main.minimumSwap(
                "xx", "yy"
        ));
        System.out.println(main.minimumSwap(
                "xy", "yx"
        ));
        System.out.println(main.minimumSwap(
                "xy", "yy"
        ));
        System.out.println(main.minimumSwap(
                "xxyyxyxyxx", "xyyxyxxxyx"
        ));
        System.out.println(main.minimumSwap(
                "xxxxyyyy", "yyyyxxxx"
        ));
    }
}