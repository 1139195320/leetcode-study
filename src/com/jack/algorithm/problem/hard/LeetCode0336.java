package com.jack.algorithm.problem.hard;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0336 {

    private static class TrieTree {
        TrieTree[] childArr = new TrieTree[26];
        int wordIndex = -1;
        void add(String word, int index) {
            int n = word.length();
            int i = 0;
            TrieTree tree = this;
            while (i < n) {
                TrieTree[] childArr = tree.childArr;
                char c = word.charAt(i ++);
                if (c > 'z' || c < 'a') {
                    return;
                }
                if (childArr[c - 'a'] == null) {
                    childArr[c - 'a'] = new TrieTree();
                }
                tree = childArr[c - 'a'];
            }
            tree.wordIndex = index;
        }
        /**
         * 顺序查找
         **/
        int find(String word) {
            int n = word.length();
            if (n == 0) {
                return -1;
            }
            int i = 0;
            TrieTree tree = this;
            while (i < n) {
                char c = word.charAt(i ++);
                if (c > 'z' || c < 'a') {
                    return -1;
                }
                TrieTree[] childArr = tree.childArr;
                if (childArr[c - 'a'] == null) {
                    return -1;
                }
                tree = childArr[c - 'a'];
            }
            return tree.wordIndex;
        }
        /**
         * 倒序查找
         **/
        int findReverse(String word) {
            int n = word.length();
            int i = n - 1;
            TrieTree tree = this;
            while (i >= 0) {
                char c = word.charAt(i --);
                if (c > 'z' || c < 'a') {
                    return -1;
                }
                TrieTree[] childArr = tree.childArr;
                if (childArr[c - 'a'] == null) {
                    return -1;
                }
                tree = childArr[c - 'a'];
            }
            return tree.wordIndex;
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int n = words.length;
        if (n == 0) {
            return res;
        }
        TrieTree tree = new TrieTree();
        for (int i = 0; i < n; i++) {
            tree.add(words[i], i);
        }
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 0; j <= len; j++) {
                String l = word.substring(0, j);
                String r = word.substring(j);
                int lIdx = tree.findReverse(r);
                String key = lIdx + "-" + i;
                if (!visited.contains(key)) {
                    if (isPalindrome(l) && lIdx != -1 && lIdx != i) {
                        visited.add(key);
                        res.add(Arrays.asList(lIdx, i));
                    }
                }
                int rIdx = tree.findReverse(l);
                key = i + "-" + rIdx;
                if (!visited.contains(key)) {
                    if (isPalindrome(r) && rIdx != -1 && rIdx != i) {
                        visited.add(key);
                        res.add(Arrays.asList(i, rIdx));
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0336 main = new LeetCode0336();
        System.out.println(main.palindromePairs(
                new String[] {"abcd", "dcba", "lls", "s", "sssll"}
        ));
        System.out.println(main.palindromePairs(
                new String[] {"bat", "tab", "cat"}
        ));
        System.out.println(main.palindromePairs(
                new String[] {"", "a"}
        ));
        TrieTree tree = new TrieTree();
        tree.add("", 0);
        System.out.println(tree.findReverse(""));
    }
}