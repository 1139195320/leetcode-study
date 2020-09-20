package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0423 {

    /**
     * zero -
     * one -
     * two -
     * three -
     * four -
     * five -
     * six -
     * seven -
     * eight -
     * nine
     *
     * z x w g s h u o v i
     **/
    public String originalDigits(String s) {
        int n = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] ++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr['z' - 'a']; i++) {
            arr['e' - 'a'] --;
            arr['r' - 'a'] --;
            arr['o' - 'a'] --;
            list.add(0);
        }
        for (int i = 0; i < arr['x' - 'a']; i++) {
            arr['s' - 'a'] --;
            arr['i' - 'a'] --;
            list.add(6);
        }
        for (int i = 0; i < arr['w' - 'a']; i++) {
            arr['t' - 'a'] --;
            arr['o' - 'a'] --;
            list.add(2);
        }
        for (int i = 0; i < arr['g' - 'a']; i++) {
            arr['e' - 'a'] --;
            arr['i' - 'a'] --;
            arr['h' - 'a'] --;
            arr['t' - 'a'] --;
            list.add(8);
        }
        for (int i = 0; i < arr['s' - 'a']; i++) {
            arr['e' - 'a'] -= 2;
            arr['v' - 'a'] --;
            arr['n' - 'a'] --;
            list.add(7);
        }
        for (int i = 0; i < arr['h' - 'a']; i++) {
            arr['t' - 'a'] --;
            arr['r' - 'a'] --;
            arr['e' - 'a'] -= 2;
            list.add(3);
        }
        for (int i = 0; i < arr['u' - 'a']; i++) {
            arr['f' - 'a'] --;
            arr['o' - 'a'] --;
            arr['r' - 'a'] --;
            list.add(4);
        }
        for (int i = 0; i < arr['o' - 'a']; i++) {
            arr['n' - 'a'] --;
            arr['e' - 'a'] --;
            list.add(1);
        }
        for (int i = 0; i < arr['v' - 'a']; i++) {
            arr['f' - 'a'] --;
            arr['i' - 'a'] --;
            arr['e' - 'a'] --;
            list.add(5);
        }
        for (int i = 0; i < arr['i' - 'a']; i++) {
            arr['n' - 'a'] -= 2;
            arr['e' - 'a'] --;
            list.add(9);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder(list.size());
        for (int num : list) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0423 main = new LeetCode0423();
        System.out.println(main.originalDigits("owoztneoer"));
    }
}