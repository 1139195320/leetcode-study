package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1154 {

    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        boolean isRn = (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
        int res = 0;
        int curM = 1;
        while (curM <= m) {
            if (curM == m) {
                res += d;
            } else {
                if (curM == 1 || curM == 3 || curM == 5
                        || curM == 7 || curM == 8
                        || curM == 10 || curM == 12) {
                    res += 31;
                } else if (curM == 2) {
                    res += isRn ? 29 : 28;
                } else {
                    res += 30;
                }
            }
            curM ++;
        }
        return res;
    }
}
