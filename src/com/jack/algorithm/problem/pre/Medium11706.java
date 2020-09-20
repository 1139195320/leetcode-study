package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11706 {

    public int numberOf2sInRange(int n) {
        String str = n + "";
        char[] arr = str.toCharArray();
        int len = arr.length;
        int[] dp = new int[len];
        int i = 0;
        if (arr[len - 1 - i] >= '2') {
            dp[i] = 1;
        }
        int pre = arr[len - 1 - i] - '0';
        i ++;
        while (i < len) {
            int pos = i + 1;
            int cur = arr[len - 1 - i] - '0';
            int preMultiple = getMultiple(pos - 1);
            int multiple = getMultiple(pos);
            if (cur < 2) {
                dp[i] = cur * preMultiple + dp[i - 1];
            }
            else if (cur == 2) {
                dp[i] = cur * preMultiple + (pre + 1) + dp[i - 1];
            }
            else {
                dp[i] = cur * preMultiple + multiple / (pos) + dp[i - 1];
            }
            pre = pre * 10 + cur;
            i ++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[i - 1];
    }
    private int getMultiple(int i) {
        int multiple = i;
        while (i > 1) {
            multiple *= 10;
            i --;
        }
        return multiple;
    }

    public static void main(String[] args) {
        Medium11706 main = new Medium11706();
        System.out.println(main.numberOf2sInRange(8));
        System.out.println(main.numberOf2sInRange(78));
        System.out.println(main.numberOf2sInRange(478));
        System.out.println(main.numberOf2sInRange(25));
    }
}