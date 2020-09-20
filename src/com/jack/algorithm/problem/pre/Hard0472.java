package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Hard0472 {

    private static class TrieTree {
        private TrieTree[] childArr = new TrieTree[26];
        private boolean isLeaf = false;
        private void add(char[] arr) {
            TrieTree tree = this;
            int i = 0;
            while (i < arr.length) {
                char c = arr[i ++];
                TrieTree[] childArr = tree.childArr;
                tree = childArr[c - 'a'];
                if (tree == null) {
                    tree = new TrieTree();
                    childArr[c - 'a'] = tree;
                }
            }
            tree.isLeaf = true;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        TrieTree tree = new TrieTree();
        for (String word : words) {
            if (!"".equals(word)) {
                tree.add(word.toCharArray());
            }
        }
        for (String word : words) {
            if (dfs(word.toCharArray(), 0, tree)) {
                res.add(word);
            }
        }
        return res;
    }
    private boolean dfs(char[] arr, int start, TrieTree tree) {
        int n = arr.length;
        TrieTree cur = tree;
        for (int i = start; i < n; i++) {
            if (cur.childArr[arr[i] - 'a'] == null) {
                return false;
            }
            cur = cur.childArr[arr[i] - 'a'];
            // start - i 是一个完全体
            if (cur.isLeaf && dfs(arr, i + 1, tree)) {
                return true;
            }
        }
        // 找到一个完全体，且不是从 start 开始的
        return cur.isLeaf && start != 0;
    }

    public static void main(String[] args) {
        Hard0472 main = new Hard0472();
        System.out.println(main.findAllConcatenatedWordsInADict(
                new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog",
                        "hippopotamuses", "rat", "ratcatdogcat"}
        ));
    }
}