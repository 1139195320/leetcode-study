package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1221 {

    public int balancedStringSplit(String s) {
        int res = 0;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l ++;
            } else {
                r ++;
            }
            if (l == r) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1221 main = new LeetCode1221();
        System.out.println(main.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(main.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(main.balancedStringSplit("LLLLRRRR"));
    }
}