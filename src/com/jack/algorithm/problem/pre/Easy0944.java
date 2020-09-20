package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0944 {

    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < A[0].length(); i++) {
            int pre = 'a';
            for (String a : A) {
                char cur = a.charAt(i);
                if (cur < pre) {
                    res ++;
                    break;
                }
                pre = cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Easy0944 main = new Easy0944();
        System.out.println(main.minDeletionSize(
                new String[] {"cba", "daf", "ghi"}
        ));
        System.out.println(main.minDeletionSize(
                new String[] {"a", "b"}
        ));
        System.out.println(main.minDeletionSize(
                new String[] {"zyx", "wvu", "tsr"}
        ));
    }
}