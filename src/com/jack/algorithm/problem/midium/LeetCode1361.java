package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int rootSize = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(leftChild[i]);
            set.add(rightChild[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                rootSize ++;
            }
        }
        if (rootSize > 1 || rootSize == 0) {
            // 多棵树 或 有环
            return false;
        }

        Map<Integer, Set<Integer>> parentMap = new HashMap<>();
        allParentMap.clear();
        initParentMap(parentMap, leftChild);
        initParentMap(parentMap, rightChild);
        for (Map.Entry<Integer, Set<Integer>> entry : parentMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                // 该节点有多个父节点
                return false;
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : allParentMap.entrySet()) {
            if (entry.getValue().contains(entry.getKey())) {
                // 有环
                return false;
            }
        }

        return true;
    }
    private Map<Integer, Set<Integer>> allParentMap = new HashMap<>();
    private void initParentMap(Map<Integer, Set<Integer>> map, int[] childArr) {
        for (int i = 0; i < childArr.length; i++) {
            int j = childArr[i];
            if (j != -1) {
                Set<Integer> allParentSet;
                if (map.get(j) == null) {
                    Set<Integer> parentSet = new HashSet<>();
                    parentSet.add(i);
                    map.put(j, parentSet);
                } else {
                    Set<Integer> parentSet = map.get(j);
                    parentSet.add(i);
                }
                if (allParentMap.get(j) == null) {
                    allParentSet = new HashSet<>();
                } else {
                    allParentSet = allParentMap.get(j);
                }
                allParentSet.add(i);
                Set<Integer> curParentSet = map.get(j);
                for (int curParent : curParentSet) {
                    Set<Integer> curAllParent = allParentMap.get(curParent);
                    if (curAllParent != null) {
                        allParentSet.addAll(curAllParent);
                    }
                }
                allParentMap.put(j, allParentSet);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1361 main = new LeetCode1361();
        System.out.println(main.validateBinaryTreeNodes(4,
                new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        System.out.println(main.validateBinaryTreeNodes(4,
                new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        System.out.println(main.validateBinaryTreeNodes(2,
                new int[]{1, 0}, new int[]{-1, -1}));
        System.out.println(main.validateBinaryTreeNodes(6,
                new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1}));
        System.out.println(main.validateBinaryTreeNodes(4,
                new int[]{1, 2, 0, -1}, new int[]{-1, -1, -1, -1}));
    }
}
