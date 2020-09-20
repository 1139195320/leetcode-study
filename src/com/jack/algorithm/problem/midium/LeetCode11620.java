package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode11620 {

    public List<String> getValidT9Words(String num, String[] words) {
        List<Character>[] arr = new ArrayList[8];
        arr[0] = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        arr[1] = new ArrayList<>(Arrays.asList('d', 'e', 'f'));
        arr[2] = new ArrayList<>(Arrays.asList('g', 'h', 'i'));
        arr[3] = new ArrayList<>(Arrays.asList('j', 'k', 'l'));
        arr[4] = new ArrayList<>(Arrays.asList('m', 'n', 'o'));
        arr[5] = new ArrayList<>(Arrays.asList('p', 'q', 'r', 's'));
        arr[6] = new ArrayList<>(Arrays.asList('t', 'u', 'v'));
        arr[7] = new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z'));
        List<String> res = new ArrayList<>();
        int n = num.length();
        char[] numArr = num.toCharArray();
        for (String word : words) {
            char[] cs = word.toCharArray();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!arr[numArr[i] - '2'].contains(cs[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}
