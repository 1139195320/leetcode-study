package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode10048 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        int l = 0;
        int res = 1;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                // 当前 c 还未重复
                map.put(c, i);
                queue.add(c);
            } else {
                // 当前 c 已重复
                l = map.get(c) + 1;
                char tmp = c;
                // 重置上一个 c 及之前的字母
                while (!queue.isEmpty() && (tmp = queue.remove()) != c) {
                    map.remove(tmp);
                }
                map.remove(tmp);
                queue.add(c);
                map.put(c, i);
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int[] arr = new int[128];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c] > 0) {
                j = Math.max(j, arr[c]);
            }
            res = Math.max(res, i - j + 1);
            arr[c] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode10048 main = new LeetCode10048();
        System.out.println(main.lengthOfLongestSubstring2(
                "aab"
        ));
        System.out.println(main.lengthOfLongestSubstring2(
                "bbbbbb"
        ));
        System.out.println(main.lengthOfLongestSubstring2(
                "pwwkew"
        ));
        System.out.println(main.lengthOfLongestSubstring2(
                "abcabcbb"
        ));
    }
}