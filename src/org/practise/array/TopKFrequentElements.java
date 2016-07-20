package org.practise.array;

import java.util.*;

/**
 * Created by liguoxiang on 7/20/16.
 */
public class TopKFrequentElements {
    class Element {
        int val;
        int counter;

        public Element(int val, int counter) {
            this.val = val;
            this.counter = counter;
        }

        public int getCounter(){
            return this.counter;
        }
        public int getVal(){
            return this.val;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return res;
        }

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(k,
                Comparator.comparing(Element::getCounter,Comparator.reverseOrder()).
                        thenComparing(Element::getVal,Comparator.reverseOrder())
        );


        HashMap<Integer, Integer> hashTable = new HashMap<>();

        Arrays.stream(nums).forEach(num -> addElementToHashTable(hashTable, num));

        hashTable.keySet().stream().forEach(key ->
                priorityQueue.add(new Element(key, hashTable.get(key))));

        priorityQueue.stream().limit(k).forEach(element -> res.add(0,element.val));
        return res;

    }

    private void addElementToHashTable(HashMap<Integer, Integer> hashtable, Integer value) {

        if (hashtable.containsKey(value)) {
            hashtable.put(value, (hashtable.get(value) + 1));
        } else {
            hashtable.put(value, 1);
        }
    }

}
