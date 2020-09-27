package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0003 {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        // 此处用 Set 优于 List
        Set<Character> set = new HashSet<>();
        int size = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            result = Math.max(size, result);
            if (set.contains(c)) {
                String str = sb.toString();
                i = index + str.indexOf(c);
                if (result >= (s.length() - i - 1)) {
                    break;
                }
                set.clear();
                sb = new StringBuilder();
                size = 0;
                index = i + 1;
            } else {
                set.add(c);
                size ++;
                sb.append(c);
            }
        }
        result = Math.max(size, result);
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int j = 0;
        for (int i = 0; i < len; i ++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)));
            }
            result = Math.max(result, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        int[] arr = new int[128];
        int len = s.length();
        int j = 0;
        for (int i = 0; i < len; i ++) {
            if (arr[s.charAt(i)] > 0) {
                j = Math.max(j, arr[s.charAt(i)]);
            }
            result = Math.max(result, i - j + 1);
            arr[s.charAt(i)] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0003 main = new LeetCode0003();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(main.lengthOfLongestSubstring("bbbbb"));
        System.out.println(main.lengthOfLongestSubstring("pwwkew"));
        System.out.println("=========");
        System.out.println(main.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(main.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(main.lengthOfLongestSubstring2("pwwkew"));
        System.out.println("=========");
        System.out.println(main.lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(main.lengthOfLongestSubstring3("bbbbb"));
        System.out.println(main.lengthOfLongestSubstring3("pwwkew"));
    }
}
