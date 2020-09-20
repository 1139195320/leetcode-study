package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode1032 {

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(
                new String[]{"cd", "f", "kl"});
        // 初始化字典
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));
    }
}

class StreamChecker {

    private static class TrieTree {
        private TrieTree[] childArr = new TrieTree[26];
        private boolean isLeaf = false;
        private void addReverse(char[] arr) {
            TrieTree tree = this;
            int i = arr.length - 1;
            while (i >= 0) {
                char c = arr[i --];
                TrieTree[] childArr = tree.childArr;
                tree = childArr[c - 'a'];
                if (tree == null) {
                    tree = new TrieTree();
                    childArr[c - 'a'] = tree;
                }
            }
            tree.isLeaf = true;
        }
        private boolean find(char[] arr) {
            int n = arr.length;
            TrieTree tree = this;
            int i = 0;
            while (i < n) {
                char c = arr[i ++];
                TrieTree[] childArr = tree.childArr;
                tree = childArr[c - 'a'];
                if (tree == null) {
                    return false;
                }
            }
            return tree.isLeaf;
        }
        private boolean startsWith(String prefix) {
            int i = 0;
            TrieTree cur = this;
            while (i < prefix.length()) {
                char c = prefix.charAt(i ++);
                TrieTree[] childArr = cur.childArr;
                cur = childArr[c - 'a'];
                if (cur == null) {
                    return false;
                }
            }
            return true;
        }
    }

    private TrieTree tree;
    private List<Character> list;

    public StreamChecker(String[] words) {
        list = new ArrayList<>();
        tree = new TrieTree();
        for (String word : words) {
            // 倒置插入
            tree.addReverse(word.toCharArray());
        }
    }
    public boolean query(char letter) {
        list.add(letter);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            String cur = sb.toString();
            if (!tree.startsWith(cur)) {
                return false;
            }
            if (tree.find(cur.toCharArray())) {
                return true;
            }
        }
        return false;
    }
}