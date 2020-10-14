package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode1002 {

    public List<String> commonChars(List<String> list) {
        List<String> res = new ArrayList<>();
        int n = list.size();
        if (n == 0) {
            return res;
        }
        int max = 26;
        int[] arr = new int[max];
        Arrays.fill(arr, -1);
        int[][] tmp = new int[n][max];
        for (int i = 0; i < n; i++) {
            String cur = list.get(i);
            for (char c : cur.toCharArray()) {
                tmp[i][c - 'a'] ++;
            }
            for (int j = 0; j < max; j++) {
                if (arr[j] == -1) {
                    arr[j] = tmp[i][j];
                } else {
                    arr[j] = Math.min(arr[j], tmp[i][j]);
                }
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < arr[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1002 main = new LeetCode1002();
        System.out.println(main.commonChars(
                Arrays.asList("bella","label","roller")
        ));
        System.out.println(main.commonChars(
                Arrays.asList("cool","lock","cook")
        ));
    }
}
