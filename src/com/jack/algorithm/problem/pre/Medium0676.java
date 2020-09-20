package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0676 {

    public static void main(String[] args) {
        MagicDictionary tree = new MagicDictionary();
        tree.buildDict(
                new String[] {"hello", "leetcode"}
        );
        System.out.println(tree.search("hello"));
        System.out.println(tree.search("hhllo"));
        System.out.println(tree.search("hell"));
        System.out.println(tree.search("leetcoded"));
    }
}

class MagicDictionary {
    private MagicDictionary[] childArr;
    private void add(String word) {
        if (word == null) {
            return;
        }
        int n = word.length();
        MagicDictionary tree = this;
        int i = 0;
        while (i < n) {
            char c = word.charAt(i ++);
            MagicDictionary[] childArr = tree.childArr;
            tree = childArr[c - 'a'];
            if (tree == null) {
                tree = new MagicDictionary();
                childArr[c - 'a'] = tree;
            }
        }
    }
    private boolean match(char[] arr, MagicDictionary tree,
                  int pos, int changeCount) {
        int n = arr.length;
        if (pos == n) {
            // 必须修改过一次
            return changeCount == 1;
        }
        char c = arr[pos];
        MagicDictionary[] childArr = tree.childArr;
        tree = childArr[c - 'a'];
        if (tree == null) {
            if (changeCount == 0) {
                // 还没修改过
                for (int i = 0; i < 26; i++) {
                    if (c - 'a' == i) {
                        continue;
                    }
                    tree = childArr[i];
                    if (tree != null) {
                        if (match(arr, tree, pos + 1,
                                changeCount + 1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return match(arr, tree, pos + 1, changeCount);
    }

    /** Initialize your data structure here. */
    public MagicDictionary() {
        childArr = new MagicDictionary[26];
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String data : dict) {
            add(data);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return match(word.toCharArray(), this, 0, 0);
    }
}