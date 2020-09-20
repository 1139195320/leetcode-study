package com.jack.algorithm.problem.pre;

import java.util.HashMap;

/**
 * @author jack
 */
public class Medium0659 {

    private static class Counter extends HashMap<Integer, Integer> {
        @Override
        public Integer get(Object key) {
            return containsKey(key) ? super.get(key) : 0;
        }
        void add(int key, int count) {
            super.put(key, get(key) + count);
        }
    }
    public boolean isPossible(int[] nums) {
        Counter counter = new Counter();
        Counter tails = new Counter();
        for (int num : nums) {
            counter.add(num, 1);
        }
        for (int x: nums) {
            if (counter.get(x) == 0) {
                continue;
            } else if (tails.get(x) > 0) {
                tails.add(x, -1);
                tails.add(x + 1, 1);
            } else if (counter.get(x + 1) > 0
                    && counter.get(x + 2) > 0) {
                counter.add(x + 1, -1);
                counter.add(x + 2, -1);
                tails.add(x + 3, 1);
            } else {
                return false;
            }
            counter.add(x, -1);
        }
        return true;
    }

    public static void main(String[] args) {
        Medium0659 main = new Medium0659();
        System.out.println(main.isPossible(
                new int[] {1, 2, 3, 3, 4, 4, 5}
        ));
        System.out.println(main.isPossible(
                new int[] {1, 2, 3, 4, 5}
        ));
        System.out.println(main.isPossible(
                new int[] {1, 2, 3, 4, 4, 5}
        ));
    }
}