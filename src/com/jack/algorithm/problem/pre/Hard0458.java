package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard0458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // states 的 x 次方 >= buckets
        // states = minutesToTest / minutesToDie + 1
        return (int) Math.ceil(Math.log(buckets) /
                Math.log(minutesToTest * 1.0 / minutesToDie + 1));
    }

    public static void main(String[] args) {
        Hard0458 main = new Hard0458();
        System.out.println(main.poorPigs(1000,
                15, 60));
    }
}
