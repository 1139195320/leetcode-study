package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Medium0692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = map.size();
        String[] wordArr = new String[n];
        int[][] arr = new int[n][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            wordArr[i] = key;
            arr[i][0] = entry.getValue();
            arr[i][1] = i;
            i ++;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        for (int j = 0; j < k && j < n; j++) {
            res.add(wordArr[arr[j][1]]);
        }
        Collections.sort(res);
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = map.size();
        List<String> res = new ArrayList<>(map.keySet());
        res.sort((w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));

        return res.subList(0, k);
    }

    public static void main(String[] args) {
        Medium0692 main = new Medium0692();
        System.out.println(main.topKFrequent(
                new String[]{"i", "love", "leetcode",
                        "i", "love", "coding"}, 2
        ));
        System.out.println(main.topKFrequent(
                new String[]{"the", "day", "is", "sunny", "the",
                        "the", "the", "sunny", "is", "is"}, 4
        ));
    }
}