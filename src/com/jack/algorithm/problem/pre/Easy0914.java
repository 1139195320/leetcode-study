package com.jack.algorithm.problem.pre;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class Easy0914 {

    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        if (n < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int data : deck) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cur = entry.getValue();
            if (count == 0) {
                count = cur;
            } else {
                if (cur >= count) {
                    if (cur % count != 0) {
                        return false;
                    }
                } else {
                    if (count % cur != 0) {
                        return false;
                    }
                    count = cur;
                }
            }
            if (count == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Easy0914 main = new Easy0914();
        System.out.println(main.hasGroupsSizeX(
                new int[]{1, 1}
        ));
        System.out.println(main.hasGroupsSizeX(
                new int[]{1, 1, 1, 2, 2, 2, 3, 3}
        ));
        System.out.println(main.hasGroupsSizeX(
                new int[]{1, 1, 2, 2, 2, 2}
        ));
    }
}