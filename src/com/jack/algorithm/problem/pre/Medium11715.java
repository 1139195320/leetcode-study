package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium11715 {

    private static class TrieTree {
        TrieTree[] childArr;
        boolean isLeaf = false;
        TrieTree() {
            childArr = new TrieTree[26];
        }
        void add(String word) {
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
    public String longestWord(String[] words) {
        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.add(word);
        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (dfs(tree, word.toCharArray(), 0)) {
                set.add(word);
            }
        }
        return set.isEmpty() ? "" : set.iterator().next();
    }
    private boolean dfs(TrieTree root, char[] arr, int start) {
        TrieTree tree = root;
        for (int i = start; i < arr.length; i++) {
            char c = arr[i];
            if (tree.childArr[c - 'a'] != null) {
                tree = tree.childArr[c - 'a'];
                if (tree.isLeaf && dfs(root, arr, i + 1)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return tree.isLeaf && start != 0;
    }

    public static void main(String[] args) {
        Medium11715 main = new Medium11715();
        System.out.println(main.longestWord(
                new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"}
        ));
    }
}