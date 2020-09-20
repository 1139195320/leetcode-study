package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0738 {

    public int monotoneIncreasingDigits(int N) {
        StringBuilder res = new StringBuilder();
        String strN = String.valueOf(N);
        search:for (int i = 0; i < strN.length(); i++) {
            for (char j = '1'; j <= '9'; j++) {
                if (strN.compareTo(res +
                        repeat(j, strN.length() - i)) < 0) {
                    // 拼接的数大了
                    res.append((char) (j - 1));
                    continue search;
                }
            }
            res.append(9);
        }
        return Integer.parseInt(res.toString());
    }
    private String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public int monotoneIncreasingDigits2(int N) {
        char[] arr = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < arr.length && arr[i - 1] <= arr[i]) {
            i ++;
        }
        while (i > 0 && i < arr.length && arr[i - 1] > arr[i]) {
            arr[-- i] --;
        }
        for (int j = i + 1; j < arr.length; j++) {
            arr[j] = '9';
        }
        return Integer.parseInt(String.valueOf(arr));
    }

}
