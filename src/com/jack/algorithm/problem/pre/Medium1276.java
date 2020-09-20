package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        // 4x + 2y = tomatoSlices;
        // x + y = cheeseSlices;
        if ((tomatoSlices >> 1) < cheeseSlices) {
            return new ArrayList<>();
        }
        if (((tomatoSlices - (cheeseSlices << 1)) & 1) != 0) {
            return new ArrayList<>();
        }
        int x = (tomatoSlices - (cheeseSlices << 1)) >> 1;
        res.add(x);
        res.add(cheeseSlices - x);
        return res;
    }

    public static void main(String[] args) {
        Medium1276 main = new Medium1276();
        System.out.println(main.numOfBurgers(16, 7));
        System.out.println(main.numOfBurgers(17, 4));
        System.out.println(main.numOfBurgers(4, 17));
        System.out.println(main.numOfBurgers(0, 0));
        System.out.println(main.numOfBurgers(2, 1));
    }
}