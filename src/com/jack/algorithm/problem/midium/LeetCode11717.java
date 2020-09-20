package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode11717 {

    private static class TrieTree {
        TrieTree[] childArr;
        int val = -1;
        public TrieTree() {
            childArr = new TrieTree[26];
        }
        void add(String word, int val) {
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
            tree.val = val;
        }
        List<Integer> find(String target) {
            List<Integer> list = new ArrayList<>();
            doFind(list, target.toCharArray(), 0, this);
            return list;
        }
        void doFind(List<Integer> list, char[] arr, int pos, TrieTree tree) {
            if (arr == null || tree == null) {
                return;
            }
            int n = arr.length;
            if (pos == n) {
                return;
            }
            tree = tree.childArr[arr[pos] - 'a'];
            if (tree == null) {
                return;
            }
            if (tree.val != -1) {
                list.add(tree.val);
            }
            doFind(list, arr, pos + 1, tree);
        }
    }
    public int[][] multiSearch(String big, String[] smalls) {
        TrieTree tree = new TrieTree();
        int n = smalls.length;
        for (int i = 0; i < n; i++) {
            tree.add(smalls[i], i);
        }
        int len = big.length();
        Map<Integer, List<Integer>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            List<Integer> list = tree.find(big.substring(i));
            if (list.size() > 0) {
                map.put(i, list);
            }
        }
        List<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int key = entry.getKey();
            for (int i : list) {
                arr[i].add(key);
            }
        }
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            List<Integer> list = arr[i];
            if (list.size() > 0) {
                res[i] = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    res[i][j] = list.get(j);
                }
            } else {
                res[i] = new int[] {};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode11717 main = new LeetCode11717();
        System.out.println(Arrays.deepToString(main.multiSearch(
                "mississippi",
                new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"}
        )));
    }
}