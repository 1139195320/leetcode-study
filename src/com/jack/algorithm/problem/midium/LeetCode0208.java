package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 * @author jack
 */
public class LeetCode0208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie {

    private boolean isTrie;
    private Map<Character, Trie> childMap;

    /** Initialize your data structure here. */
    public Trie() {
        childMap = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int i = 0;
        Map<Character, Trie> map = childMap;
        Trie cur = this;
        while (i < word.length()) {
            char c = word.charAt(i);
            cur = map.get(c);
            if (cur == null) {
                cur = new Trie();
                map.put(c, cur);
            }
            map = cur.childMap;
            i ++;
        }
        cur.isTrie = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int i = 0;
        Trie cur = this;
        while (i < word.length()) {
            char c = word.charAt(i);
            Map<Character, Trie> map = cur.childMap;
            cur = map.get(c);
            if (cur == null) {
                return false;
            }
            i ++;
        }
        return cur.isTrie;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int i = 0;
        Trie cur = this;
        while (i < prefix.length()) {
            char c = prefix.charAt(i);
            Map<Character, Trie> map = cur.childMap;
            cur = map.get(c);
            if (cur == null) {
                return false;
            }
            i ++;
        }
        return true;
    }
}