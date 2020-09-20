package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium10045 {

    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium10045 main = new Medium10045();
        System.out.println(main.minNumber(
                new int[]{3, 30, 34, 5, 9}
        ));
    }
}