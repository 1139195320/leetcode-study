package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jack
 */
public class LeetCode1451 {

    public String arrangeWords(String text) {
        String[] wordArr = text.split(" ");
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String word : wordArr) {
            List<String> list = map.computeIfAbsent(word.length(),
                    k -> new ArrayList<>());
            list.add(word);
        }
        StringBuilder sb = new StringBuilder(text.length());
        boolean isFirst = true;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            for (String word : list) {
                char firstC = word.charAt(0);
                if (isFirst) {
                    if (firstC >= 'a') {
                        word = ((char) (firstC - 32)) + word.substring(1);
                    }
                    isFirst = false;
                } else {
                    if (firstC <= 'Z') {
                        word = ((char) (firstC + 32)) + word.substring(1);
                    }
                }
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LeetCode1451 main = new LeetCode1451();
        System.out.println(main.arrangeWords("Keep calm and code on"));
        System.out.println(main.arrangeWords("To be or not to be"));
        System.out.println('A' - 'a');
    }
}