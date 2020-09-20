package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            res ++;
            int cur = limit - people[j--];
            if (cur >= people[i]) {
                i ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0881 main = new Medium0881();
        System.out.println(main.numRescueBoats(
                new int[]{2, 1}, 3
        ));
        System.out.println(main.numRescueBoats(
                new int[]{3, 2, 2, 1}, 3
        ));
        System.out.println(main.numRescueBoats(
                new int[]{3, 5, 3, 4}, 5
        ));
    }
}