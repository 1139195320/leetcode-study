package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null
                || s1.length() > s2.length()) {
            return false;
        }
        int l = 0;
        int r = s1.length() - 1;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a'] ++;
        }
        int[] curCount = new int[26];
        for (int i = 0; i <= r; i++) {
            curCount[s2.charAt(i) - 'a'] ++;
        }
        if (check(count, curCount)) {
            return true;
        }
        while (r < s2.length() - 1) {
            if (check(count, curCount)) {
                return true;
            }
            curCount[s2.charAt(l ++) - 'a'] --;
            curCount[s2.charAt(++ r) - 'a'] ++;
        }
        return false;
    }
    private boolean check(int[] count, int[] curCount) {
        if (count.length != curCount.length) {
            return false;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != curCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Medium0567 main = new Medium0567();
        System.out.println(main.checkInclusion("ab", "eidbaooo"));
        System.out.println(main.checkInclusion("ab", "eidboaoo"));
    }
}