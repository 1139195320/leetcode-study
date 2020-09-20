package com.jack.algorithm.problem.midium;

/**
 * @author jack
 *
 * 模式匹配（官方解）
 */
public class LeetCode11618 {

    public boolean patternMatching(String pattern, String value) {
        int countA = 0;
        int countB = 0;
        for (char c : pattern.toCharArray()) {
            if (c == 'a') {
                countA ++;
            } else {
                countB ++;
            }
        }
        if (countA < countB) {
            int tmp = countA;
            countA = countB;
            countB = tmp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0) {
            return countB == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int i = 0; i * countA <= value.length(); i++) {
            int res = value.length() - countA * i;
            if (countB == 0 && res == 0 || countB != 0 && res % countB == 0) {
                int j = countB == 0 ? 0 : res / countB;
                int pos = 0;
                boolean flag = true;
                String valA = "";
                String valB = "";
                for (char c : pattern.toCharArray()) {
                    if (c == 'a') {
                        String sub = value.substring(pos, pos + i);
                        if (valA.length() == 0) {
                            valA = sub;
                        } else if (!valA.equals(sub)) {
                            flag = false;
                            break;
                        }
                        pos += i;
                    } else {
                        String sub = value.substring(pos, pos + j);
                        if (valB.length() == 0) {
                            valB = sub;
                        } else if (!valB.equals(sub)) {
                            flag = false;
                            break;
                        }
                        pos += j;
                    }
                }
                if (flag && !valA.equals(valB)) {
                    return true;
                }
            }
        }
        return false;
    }
}
