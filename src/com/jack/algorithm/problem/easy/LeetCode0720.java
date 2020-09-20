package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0720 {

    private static class TrieTree {
        TrieTree[] childArr;
        boolean isLeaf = false;
        TrieTree() {
            childArr = new TrieTree[26];
        }
        void add(String word) {
            if (word == null) {
                return;
            }
            int n = word.length();
            TrieTree tree = this;
            int i = 0;
            while (i < n) {
                char c = word.charAt(i ++);
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
    private void find(TrieTree curTree, String cur) {
        TrieTree[] childArr = curTree.childArr;
        for (int i = 0; i < 26; i++) {
            TrieTree tmp = childArr[i];
            if (tmp != null && tmp.isLeaf) {
                String curRes = cur + ((char) ('a' + i));
                save(curRes);
                find(tmp, curRes);
            }
        }
    }
    private String res;
    private void save(String cur) {
        if (cur.length() > res.length()) {
            res = cur;
        }
    }
    public String longestWord(String[] words) {
        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.add(word);
        }
        res = "";
        find(tree, "");
        return res;
    }

    public static void main(String[] args) {
        LeetCode0720 main = new LeetCode0720();
        System.out.println(main.longestWord(
                new String[]{"w", "wo", "wor", "worl", "world"}
        ));
        System.out.println(main.longestWord(
                new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}
        ));
    }
}