package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode10046 {

    public int translateNum(int num) {
        // 0 ~ 25
        // 'a' ~ 'z'
        int res = 1;
        // 0 1 2 3 4
        // 1 2 3 5 8
        String str = num + "";
        int l;
        int r = 0;
        for (int i = 0; i < str.length(); i++) {
            l = r;
            r = res;
            res = r;
            if (i == 0) {
                continue;
            }
            String pre = str.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0
                    && pre.compareTo("10") >= 0) {
                res += l;
            }
        }
        return res;
    }

    public int translateNum2(int num) {
        if (num < 10) {
            return 1;
        }
        int tmp = num % 100;
        if (tmp >= 10 && tmp <= 25) {
            return translateNum2(num / 10)
                    + translateNum2(num / 100);
        } else {
            return translateNum2(num / 10);
        }
    }

    public static void main(String[] args) {
        LeetCode10046 main = new LeetCode10046();
        // 5
        System.out.println(main.translateNum(12258));
        // 2
        System.out.println(main.translateNum(1333));
        // 3
        System.out.println(main.translateNum(18822));
        System.out.println("=================");
        // 5
        System.out.println(main.translateNum2(12258));
        // 2
        System.out.println(main.translateNum2(1333));
        // 3
        System.out.println(main.translateNum2(18822));
    }
}