package com.jack.algorithm.problem.still;

/**
 * @author jack
 */
public class Hard0745 {

    public static void main(String[] args) {
        WordFilter filter = new WordFilter(new String[] {"apple"});
        System.out.println(filter.f("a", "e"));
        System.out.println(filter.f("b", ""));
    }
}

class WordFilter {

    private String[] words;
    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String prefix, String suffix) {
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.startsWith(prefix) && word.endsWith(suffix)) {
                return i;
            }
        }
        return -1;
    }
}