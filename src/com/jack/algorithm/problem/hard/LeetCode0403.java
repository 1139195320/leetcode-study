package com.jack.algorithm.problem.hard;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0403 {

    private int[] dirs = {-1, 0, 1};
    public boolean canCross(int[] stones) {
        // 超时
        List<Integer> dataList = new ArrayList<>();
        for (int stone : stones) {
            dataList.add(stone);
        }
        Map<Integer, List<Integer>> map = new HashMap<>(stones.length);
        map.put(0, Collections.singletonList(1));
        for (int cur : stones) {
            List<Integer> list = map.get(cur);
            if (list != null) {
                for (int next : list) {
                    List<Integer> nextList =
                            map.computeIfAbsent(next, k -> new ArrayList<>());
                    // 遍历这一次可以跳跃到的石块
                    int step = next - cur;
                    for (int dir : dirs) {
                        int nextStep = step + dir;
                        if (nextStep <= 0) {
                            continue;
                        }
                        int nextTo = next + nextStep;
                        if (dataList.contains(nextTo)) {
                            // 下一次可以跳跃到的石块存在
                            if (!nextList.contains(nextTo)) {
                                nextList.add(nextTo);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(map);
        return map.containsKey(stones[stones.length - 1]);
    }
    public boolean canCross2(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int cur : stones) {
            for (int k : map.get(cur)) {
                for (int dir : dirs) {
                    int step = k + dir;
                    int nextStone = cur + step;
                    if (step > 0 && map.containsKey(nextStone)) {
                        map.get(nextStone).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    public static void main(String[] args) {
        LeetCode0403 main = new LeetCode0403();
        System.out.println(main.canCross2(
                new int[] {0,1,3,5,6,8,12,17}
        ));
        System.out.println(main.canCross2(
                new int[] {0,1,2,3,4,8,9,11}
        ));
    }
}