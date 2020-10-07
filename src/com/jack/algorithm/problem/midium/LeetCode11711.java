package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode11711 {

    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        if (words == null || words.length <= 1) {
            return res;
        }
        int i = 0;
        // true 表示 前为 1 后为 2
        // false 表示 前为 2 后为 1
        boolean flag = true;
        while (i < words.length
                && !word1.equals(words[i])
                && !word2.equals(words[i])) {
            i ++;
        }
        if (i == words.length - 1) {
            return res;
        }
        else if (word2.equals(words[i])) {
            flag = false;
        }
        int j = i + 1;
        while (j < words.length) {
            if (flag) {
                if (word2.equals(words[j])) {
                    res = Math.min(res, j - i);
                    i = j;
                    flag = false;
                } else if (word1.equals(words[j])) {
                    i = j;
                    flag = true;
                }
            } else {
                if (word1.equals(words[j])) {
                    res = Math.min(res, j - i);
                    i = j;
                    flag = true;
                } else if (word2.equals(words[j])) {
                    i = j;
                    flag = false;
                }
            }
            j ++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode11711 main = new LeetCode11711();
        System.out.println(main.findClosest(
                new String[] {
                        "I","am","a","student","from","a","university","in","a","city"
                }, "a", "student"
        ));
    }
}