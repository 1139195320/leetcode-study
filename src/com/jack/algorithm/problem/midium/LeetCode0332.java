package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0332 {

    private List<String> res;
    private Map<String, PriorityQueue<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        map = new HashMap<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> queue = map.computeIfAbsent(ticket.get(0),
                    k -> new PriorityQueue<>());
            queue.offer(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }
    private void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            dfs(map.get(cur).poll());
        }
        res.add(cur);
    }

    public static void main(String[] args) {
        LeetCode0332 main = new LeetCode0332();
        System.out.println(main.findItinerary(
                Arrays.asList(
                        Arrays.asList("MUC", "LHR"),
                        Arrays.asList("JFK", "MUC"),
                        Arrays.asList("SFO", "SJC"),
                        Arrays.asList("LHR", "SFO")
                )
        ));
        System.out.println(main.findItinerary(
                Arrays.asList(
                        Arrays.asList("JFK", "SFO"),
                        Arrays.asList("JFK", "ATL"),
                        Arrays.asList("SFO", "ATL"),
                        Arrays.asList("ATL", "JFK"),
                        Arrays.asList("ATL", "SFO")
                )
        ));
    }

}