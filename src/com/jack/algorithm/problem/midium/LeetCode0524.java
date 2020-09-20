package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0524 {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        int tN = s.length();
        int maxLen = 0;
        for (String str : d) {
            int curLen = str.length();
            if (curLen > tN) {
                continue;
            }
            int i = 0, j = 0;
            while (j < curLen && tN - i >= curLen - j) {
                char c = s.charAt(i);
                if (tN - i < curLen - j) {
                    break;
                }
                while (tN - i >= curLen - j
                        && (c = s.charAt(i)) != str.charAt(j)) {
                    i ++;
                }
                if (tN - i < curLen - j || c != str.charAt(j)) {
                    break;
                }
                j ++;
                i ++;
            }
            if (j == curLen) {
                if (curLen > maxLen ||
                        (curLen == maxLen
                                && str.compareTo(res) < 0)) {
                    maxLen = curLen;
                    res = str;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0524 main = new LeetCode0524();
        System.out.println(main.findLongestWord(
                "wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi",
                Arrays.asList("nbmxgkduynigvzuyblwjepn","jpthiudqzzeugzwwsngebdeai")
        ));
        System.out.println(main.findLongestWord(
                "abpcplea",
                Arrays.asList("ale","apple","monkey","plea")
        ));
        System.out.println(main.findLongestWord(
                "abpcplea",
                Arrays.asList("a","b","c")
        ));
    }
}