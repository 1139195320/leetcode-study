package com.jack.algorithm.problem.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0771 {

    public int numJewelsInStones(String jStr, String sStr) {
        if (jStr.length() == 0 || sStr.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean[] arr = new boolean[26 + 32];
        for (char j : jStr.toCharArray()) {
            arr[j - 'A'] = true;
        }
        for (char s : sStr.toCharArray()) {
            if (arr[s - 'A']) {
                res ++;
            }
        }
        return res;
    }

    public int doNumJewelsInStones2(String J, String S) {
        int res = 0;
        if (J != null && S != null && J.length() > 0 && S.length() > 0) {
            for (char s : S.toCharArray()) {
                if (J.indexOf(s) != -1) {
                    res ++;
                }
            }
        }
        return res;
    }
    public int doNumJewelsInStones3(String J, String S) {
        int res = 0;
        if (J != null && S != null && J.length() > 0 && S.length() > 0) {
            Set<Character> set = new HashSet<>(J.length());
            for (char j : J.toCharArray()) {
                set.add(j);
            }
            for (char s : S.toCharArray()) {
                if (set.contains(s)) {
                    res ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0771 main = new LeetCode0771();
        System.out.println(main.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(main.numJewelsInStones("z", "ZZ"));
    }
}
