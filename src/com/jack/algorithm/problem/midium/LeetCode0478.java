package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jack
 */
public class LeetCode0478 {

    static class Solution {
        private double radius;
        private double rx, ry;
        private Random random;
        public Solution(double radius, double rx, double ry) {
            this.radius = radius;
            this.rx = rx;
            this.ry = ry;
            random = new Random();
        }

        public double[] randPoint() {
            double tx = random.doubles()
                    .filter(x -> x <= radius * 2)
                    .iterator()
                    .next() - radius;
            if (tx == rx + radius || tx == rx - radius) {
                return new double[]{rx + tx, ry};
            }
            double maxTy = Math.sqrt(radius * radius - tx * tx);
            double ty = random.doubles()
                    .filter(x -> x <= maxTy * 2)
                    .iterator()
                    .next() - maxTy;
            return new double[]{rx + tx, ry + ty};
        }
    }

    public static void main(String[] args) {
        Solution main = new Solution(0.01, -73839.1, -3289891.3);
        System.out.println(Arrays.toString(main.randPoint()));
        System.out.println(Arrays.toString(main.randPoint()));
        System.out.println(Arrays.toString(main.randPoint()));
    }
}


