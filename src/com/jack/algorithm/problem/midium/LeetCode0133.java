package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0133 {

    static class Node {
        int val;
        List<Node> neighbors;
        public Node() {
        }
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    private Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        List<Node> neighbors = node.neighbors;
        if (neighbors == null || neighbors.size() == 0) {
            return new Node(node.val);
        }
        ArrayList<Node> newNeighbors = new ArrayList<>();
        for (Node neighbor : neighbors) {
            Node newNeighbor = cloneGraph(neighbor);
            newNeighbors.add(newNeighbor);
        }
        newNode.neighbors = newNeighbors;
        return newNode;
    }

    public static void main(String[] args) {
        LeetCode0133 main = new LeetCode0133();
    }
}