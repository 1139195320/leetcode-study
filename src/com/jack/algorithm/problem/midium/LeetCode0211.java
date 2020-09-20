package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0211 {

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));
    }
}

class WordDictionary {

    private boolean isDictionary;
    private Map<Character, WordDictionary> childMap;

    /** Initialize your data structure here. */
    public WordDictionary() {
        childMap = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int i = 0;
        Map<Character, WordDictionary> map = childMap;
        WordDictionary cur = this;
        while (i < word.length()) {
            char c = word.charAt(i);
            cur = map.get(c);
            if (cur == null) {
                cur = new WordDictionary();
                map.put(c, cur);
            }
            map = cur.childMap;
            i ++;
        }
        cur.isDictionary = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        // 递归方式
        return search(this, word);
    }
    public boolean search(WordDictionary dictionary, String word) {
        char c = word.charAt(0);
        Map<Character, WordDictionary> map = dictionary.childMap;
        dictionary = map.get(c);
        if (dictionary == null) {
            if (c == '.') {
                if (word.length() == 1) {
                    for (Map.Entry<Character, WordDictionary> entry : map.entrySet()) {
                        if (entry.getValue().isDictionary) {
                            return true;
                        }
                    }
                } else {
                    for (Map.Entry<Character, WordDictionary> entry : map.entrySet()) {
                        if (search(entry.getValue(), word.substring(1))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else if (word.length() == 1) {
            return dictionary.isDictionary;
        } else {
            return search(dictionary, word.substring(1));
        }
    }
}