package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy1491 {

    public double average(int[] salary) {
        double res = 0;
        int min = salary[0];
        int max = salary[0];
        int n = salary.length - 2;
        for (int data : salary) {
            min = Math.min(min, data);
            max = Math.max(max, data);
            res += data * 1.0 / n;
        }
        return res - (min + max) * 1.0 / n;
    }

    public static void main(String[] args) {
        Easy1491 main = new Easy1491();
        System.out.println(main.average(
                new int[]{4000, 3000, 1000, 2000}
        ));
        System.out.println(main.average(
                new int[]{8000, 9000, 2000, 3000, 6000, 1000}
        ));
    }
}