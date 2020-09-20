package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0853 {

    public int carFleet(int target, int[] position, int[] speed) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int n = position.length;
        for (int i = 1; i < n; i++) {
            boolean has = false;
            for (int pre : list) {
                int maxPosition = position[pre];
                int minPosition = position[i];
                int maxSpeed = speed[pre];
                int minSpeed = speed[i];
                if (maxPosition == minPosition) {
                    has = true;
                    break;
                }
                if ((maxPosition < minPosition) == (maxSpeed < minSpeed)) {
                    continue;
                }
                if (maxPosition < minPosition) {
                    maxPosition = position[i];
                    minPosition = position[pre];
                    maxSpeed = speed[i];
                    minSpeed = speed[pre];
                }
                while (maxPosition < target) {
                    maxPosition += maxSpeed;
                    minPosition += minSpeed;
                    if (minPosition >= maxPosition) {
                        has = true;
                        break;
                    }
                }
            }
            if (!has) {
                list.add(i);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        Medium0853 main = new Medium0853();
        System.out.println(main.carFleet(
                12,
                new int[]{10, 8, 0, 5, 3},
                new int[]{2, 4, 1, 1, 3}
        ));
    }
}