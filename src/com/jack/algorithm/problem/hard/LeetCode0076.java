package com.jack.algorithm.problem.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0076 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        while (left < s.length()) {
            if (checked(needs, windows)) {
                // 找到了符合的
                if (minLen > right - left) {
                    // 更短
                    minLeft = left;
                    minRight = right;
                    minLen = minRight - minLeft;
                }
                char cLeft = s.charAt(left);
                if (windows.containsKey(cLeft)) {
                    int cVal = windows.get(cLeft);
                    windows.put(cLeft, cVal == 0 ? cVal : cVal - 1);
                }
                left ++;
            } else {
                if (right == s.length()) {
                    break;
                }
                char c = s.charAt(right);
                if (t.indexOf(c) != -1) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                }
                right ++;
            }
        }
        return s.substring(minLeft, minRight);
    }
    private boolean checked(Map<Character, Integer> needs,
                            Map<Character, Integer> windows) {
        for (Map.Entry<Character, Integer> entry : needs.entrySet()) {
            char key = entry.getKey();
            if (!windows.containsKey(key)
                    || windows.get(key) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0076 main = new LeetCode0076();
        System.out.println(main.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(main.minWindow("aa", "aa"));
        System.out.println(main.minWindow("abcd", "ae"));
    }
}
