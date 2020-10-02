package com.jack.algorithm.problem.easy;

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

    public static void main(String[] args) {
        LeetCode0771 main = new LeetCode0771();
        System.out.println(main.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(main.numJewelsInStones("z", "ZZ"));
    }
}
