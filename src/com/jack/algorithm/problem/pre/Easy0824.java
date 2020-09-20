package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0824 {

    public String toGoatLatin(String S) {
        if (S.trim().length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = S.split(" ");
        for (int i = 0; i < arr.length; i++) {
            sb.append(toGoatLatin(arr[i], i));
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String toGoatLatin(String s, int index) {
        if (s.length() == 0) {
            return "";
        }
        char c = s.charAt(0);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            s = s + "ma";
        } else {
            s = s.substring(1) + c + "ma";
        }
        return s + getNumA(index + 1);
    }
    private String getNumA(int num) {
        if (num < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append("a");
            num --;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Easy0824 main = new Easy0824();
        System.out.println(main.toGoatLatin(
                "I speak Goat Latin"));
        System.out.println(main.toGoatLatin(
                "The quick brown fox jumped over the lazy dog"));
    }
}