package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1366 {

    public String rankTeams(String[] votes) {
        if (votes.length == 1) {
            // 只有一个人投票
            return votes[0];
        }
        int len = votes[0].length();
        int[][] arr = new int[26][26];
        for (String vote : votes) {
            for (int i = 0; i < len; i++) {
                arr[vote.charAt(i) - 'A'][i] ++;
            }
        }
        Integer[] tmp = new Integer[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = votes[0].charAt(i) - 'A';
        }
        Arrays.sort(tmp, (i, j) -> {
            for (int k = 0; k < 26; k++) {
                if (arr[i][k] != arr[j][k]) {
                    return arr[j][k] - arr[i][k];
                }
            }
            // 全部相同，按升序
            return i - j;
        });
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append((char) (tmp[i] + 'A'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium1366 main = new Medium1366();
        System.out.println(main.rankTeams(
                new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}
        ));
        System.out.println(main.rankTeams(
                new String[]{"WXYZ", "XYZW"}
        ));
        System.out.println(main.rankTeams(
                new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}
        ));
        System.out.println(main.rankTeams(
                new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}
        ));
        System.out.println(main.rankTeams(
                new String[]{"M", "M", "M", "M"}
        ));
    }
}
