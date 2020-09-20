package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0825 {

    public int numFriendRequests(int[] ages) {
        int[] countArr = new int[121];
        for (int age : ages) {
            countArr[age] ++;
        }
        int res = 0;
        for (int ageA = 0; ageA < countArr.length; ageA++) {
            int countA = countArr[ageA];
            for (int ageB = 0; ageB < countArr.length; ageB++) {
                int countB = countArr[ageB];
                if (ageB <= 0.5 * ageA + 7) {
                    continue;
                }
                if (ageB > ageA) {
                    continue;
                }
                res += countA * countB;
                if (ageA == ageB) {
                    res -= countA;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0825 main = new Medium0825();
        System.out.println(main.numFriendRequests(
                new int[] {16, 16}
        ));
        System.out.println(main.numFriendRequests(
                new int[] {16, 17, 18}
        ));
        System.out.println(main.numFriendRequests(
                new int[]{20, 30, 100, 110, 120}
        ));
    }
}
