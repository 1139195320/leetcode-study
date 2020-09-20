package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0777 {

    public boolean canTransform(String start, String end) {
        if (start == null && end == null) {
            return true;
        }
        if (start == null || end == null) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }
        if (!start.replace("X", "")
                .equals(end.replace("X", ""))) {
            // 去除所有的 X 后，只剩 L 和 R，二者应该相同
            return false;
        }
        List<Integer> sIndexList = new ArrayList<>();
        List<Integer> eIndexList = new ArrayList<>();
        List<Character> sCharList = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            char c = start.charAt(i);
            if (c == 'L' || c == 'R') {
                sCharList.add(c);
                sIndexList.add(i);
            }
        }
        for (int i = 0; i < end.length(); i++) {
            char c = end.charAt(i);
            if (c == 'L' || c == 'R') {
                eIndexList.add(i);
            }
        }
        for (int i = 0; i < sCharList.size(); i++) {
            char c = sCharList.get(i);
            if (c == 'L' && sIndexList.get(i) < eIndexList.get(i)) {
                // 如果是 L，在 start 中的位置必须在 end 中相应位置右边，才能左移
                return false;
            }
            if (c == 'R' && sIndexList.get(i) > eIndexList.get(i)) {
                // 如果是 R，在 start 中的位置必须在 end 中相应位置左边，才能右移
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Medium0777 main = new Medium0777();
        System.out.println(main.canTransform(
                "RXXLRXRXL", "XRLXXRRLX"
        ));
    }
}