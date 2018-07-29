package org.practise.math;

import java.util.*;
//https://leetcode.com/problems/random-pick-with-weight/description/
class RandomPickWithWeight {
    class Node {
        private int weight;
        private int index;

        public Node(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getIndex() {
            return this.getIndex();
        }
    }

    private List<Node> nodes;
    private TreeMap<Long, Integer> tree;
    private long total;
    Random random;

    public RandomPickWithWeight(int[] w) {
        nodes = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            nodes.add(new Node(w[i], i));
        }

        Comparator<Node> comparator = Comparator.comparing(Node::getWeight);
        nodes.sort(comparator);

        total = 0L;
        tree = new TreeMap<>();
        for (Node node : nodes) {

            total += node.getWeight();
            tree.put(total, node.index);
        }

        random = new Random();

    }

    public int pickIndex() {
        long randomRes = Math.abs(random.nextLong()) % total + 1;
        Map.Entry<Long,Integer> entry=tree.ceilingEntry(randomRes);
        return entry.getValue();
    }

    public static void main(String[] args) {

        RandomPickWithWeight sol = new RandomPickWithWeight(new int[]{1, 3});

        for (int i = 0; i < 10; i++) {
            System.out.println(sol.pickIndex());
        }
    }
}