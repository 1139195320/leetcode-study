package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int sum = 0;
            for (char c : str.toCharArray()) {
                sum += (1 << (c - '0'));
            }
            arr[i] = sum;
        }
        Map<Integer, List<String>> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] countArr = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(countArr, 0);
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                countArr[c - 'a'] ++;
            }
            for (int count : countArr) {
                sb.append(count).append(".");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        LeetCode0049 main = new LeetCode0049();
        System.out.println(main.groupAnagrams(
                new String[] {
                        "eat", "tea", "tan", "ate", "nat", "bat"
                }
        ));
    }
}