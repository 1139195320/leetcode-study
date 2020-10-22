package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int maxCount = 26;
        int[] cArr = new int[maxCount];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            cArr[c - 'a'] ++;
        }
        int pre = 0;
        Set<Character> curSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            cArr[c - 'a'] --;
            if (cArr[c - 'a'] == 0) {
                if (curSet.contains(c)) {
                    curSet.remove(c);
                }
                if (curSet.size() == 0) {
                    res.add(i - pre + 1);
                    pre = i + 1;
                }
            } else {
                curSet.add(c);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0763 main = new LeetCode0763();
        System.out.println(main.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(main.partitionLabels("aaa"));
        System.out.println(main.partitionLabels("aaabbacbbd"));
    }
}
