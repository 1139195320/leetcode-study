package com.jack.algorithm.problem.pre;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class Medium1286 {

    public static void main(String[] args) {
        // 创建迭代器 iterator
        CombinationIterator iterator =
                new CombinationIterator("abc", 2);
        // 返回 "ab"
        System.out.println(iterator.next());
        // 返回 true
        System.out.println(iterator.hasNext());
        // 返回 "ac"
        System.out.println(iterator.next());
        // 返回 true
        System.out.println(iterator.hasNext());
        // 返回 "bc"
        System.out.println(iterator.next());
        // 返回 false
        System.out.println(iterator.hasNext());
    }
}

class CombinationIterator {
    private Queue<String> queue;
    private int combinationLength;
    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        this.combinationLength = combinationLength;
        char[] arr = characters.toCharArray();
        dfs(arr, "", 0);
    }
    private void dfs(char[] arr, String curStr, int start) {
        if (curStr.length() == combinationLength) {
            queue.add(curStr);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            char cur = arr[i];
            dfs(arr, curStr + cur, i + 1);
        }
    }

    public String next() {
        return queue.remove();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}