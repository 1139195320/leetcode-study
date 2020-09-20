package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium0781 {

    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int answer : answers) {
            set.add(answer);
        }
        int res = 0;
        for (int data : set) {
            res += data + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0781 main = new Medium0781();
        System.out.println(main.numRabbits(
                new int[] {1, 1, 2}
        ));
        System.out.println(main.numRabbits(
                new int[] {10, 10, 10}
        ));
    }
}