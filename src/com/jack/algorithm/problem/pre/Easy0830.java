package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class Easy0830 {

    public List<List<Integer>> largeGroupPositions(String S) {
        char[] arr = S.toCharArray();
        int l = 0, r = l + 1;
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        char pre = arr[l];
        while (r < n) {
            while (r < n && arr[r] == pre) {
                r ++;
            }
            if (r - l >= 3) {
                res.add(Arrays.asList(l, r - 1));
            }
            l = r;
            pre = arr[l];
            r = l + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Easy0830 main = new Easy0830();
        System.out.println(main.largeGroupPositions("abbxxxxzzy"));
        System.out.println(main.largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}