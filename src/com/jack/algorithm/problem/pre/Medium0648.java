package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class Medium0648 {

    private static class TrieTree {
        TrieTree[] childArr;
        boolean isLeaf = false;
        public TrieTree() {
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
        String match(String target) {
            if (target == null) {
                return null;
            }
            int n = target.length();
            TrieTree tree = this;
            int i = 0;
            while (i < n) {
                char c = target.charAt(i ++);
                TrieTree[] childArr = tree.childArr;
                tree = childArr[c - 'a'];
                if (tree == null) {
                    break;
                }
                if (tree.isLeaf) {
                    // match success
                    return target.substring(0, i);
                }
            }
            return target;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieTree tree = new TrieTree();
        for (String word : dict) {
            tree.add(word);
        }
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder(sentence.length());
        for (int i = 0; i < arr.length; i++) {
            sb.append(tree.match(arr[i]));
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium0648 main = new Medium0648();
        System.out.println(main.replaceWords(
                Arrays.asList("cat", "bat", "rat"),
                "the cattle was rattled by the battery"
        ));
    }
}