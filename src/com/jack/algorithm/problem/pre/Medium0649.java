package com.jack.algorithm.problem.pre;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class Medium0649 {

    public String predictPartyVictory(String senate) {
        if (senate.length() == 1) {
            return "R".equals(senate) ? "Radiant" : "Dire";
        }
        char[] arr = senate.toCharArray();
        int[] tmp = new int[2];
        int[] people = new int[2];
        Queue<Integer> queue = new LinkedList<>();
        for (char c : arr) {
            int i = c == 'R' ? 0 : 1;
            people[i] ++;
            queue.add(i);
        }
        while (people[0] > 0 && people[1] > 0) {
            Integer cur = queue.poll();
            if (cur == null) {
                break;
            }
            if (tmp[cur] > 0) {
                tmp[cur] --;
                people[cur] --;
            } else {
                tmp[cur ^ 1] ++;
                queue.add(cur);
            }
        }
        return people[0] > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Medium0649 main = new Medium0649();
        System.out.println(main.predictPartyVictory("RD"));
        System.out.println(main.predictPartyVictory("RDD"));
    }
}