package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0677 {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

class MapSum {

    private MapSum[] childArr;
    private boolean isLeaf = false;
    private int val;
    private void add(String key, int val) {
        if (key == null) {
            return;
        }
        int n = key.length();
        MapSum tree = this;
        int i = 0;
        while (i < n) {
            char c = key.charAt(i ++);
            MapSum[] childArr = tree.childArr;
            tree = childArr[c - 'a'];
            if (tree == null) {
                tree = new MapSum();
                childArr[c - 'a'] = tree;
            }
        }
        tree.isLeaf = true;
        tree.val = val;
    }
    private int match(char[] arr, MapSum tree, int pos) {
        int sum = 0;
        int n = arr.length;
        if (pos == n) {
            if (tree.isLeaf) {
                sum += tree.val;
            }
            MapSum[] childArr = tree.childArr;
            for (int i = 0; i < 26; i++) {
                tree = childArr[i];
                if (tree != null) {
                    sum += match(arr, tree, pos);
                }
            }
            return sum;
        }
        char c = arr[pos];
        MapSum[] childArr = tree.childArr;
        tree = childArr[c - 'a'];
        if (tree == null) {
            return sum;
        }
        return match(arr, tree, pos + 1);
    }

    /** Initialize your data structure here. */
    public MapSum() {
        childArr = new MapSum[26];
    }

    public void insert(String key, int val) {
        add(key, val);
    }

    public int sum(String prefix) {
        return match(prefix.toCharArray(), this, 0);
    }
}