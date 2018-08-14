package org.practise.tree;

import java.util.*;

class RangeModule {

    private TreeMap<Integer, Integer> treeMap;

    public RangeModule() {
        treeMap = new TreeMap<>();

    }

    public void addRange(int left, int right) {

        int minLeft = left;
        int maxRight = right;

        Map<Integer, Integer> subMap = treeMap.subMap(left, true, right, true);

        if (subMap != null) {

            List<Integer> keys = new ArrayList<>(subMap.keySet());
            for (Integer key : keys) {
                maxRight = Math.max(maxRight, subMap.get(key));
                treeMap.remove(key);
            }
        }
        Map.Entry<Integer, Integer> lowerEntry = treeMap.lowerEntry(left);

        if (lowerEntry != null) {
            if (lowerEntry.getValue() >= left && lowerEntry.getValue() < right) {
                minLeft = lowerEntry.getKey();
            } else if (lowerEntry.getValue() >= right) {
                minLeft = lowerEntry.getKey();
                maxRight = Math.max(maxRight, lowerEntry.getValue());
            }
        }

        treeMap.put(minLeft, maxRight);

    }

    public boolean queryRange(int left, int right) {

        Map.Entry<Integer, Integer> lowerEntry = treeMap.floorEntry(left);
        if (lowerEntry != null && lowerEntry.getValue() >= right) {
            return true;
        } else {
            return false;
        }
    }

    public void removeRange(int left, int right) {

        SortedMap<Integer, Integer> subMap = treeMap.subMap(left, right);
        if (subMap != null) {

            List<Integer> keys = new ArrayList<>(subMap.keySet());
            for (Integer key : keys) {
                if (subMap.get(key) > right) {
                    treeMap.put(right, subMap.get(key));
                }
                treeMap.remove(key);
            }
        }

        Map.Entry<Integer, Integer> lowerEntry = treeMap.lowerEntry(left);

        if (lowerEntry != null) {
            if (lowerEntry.getValue() > left && lowerEntry.getValue() <= right) {
                treeMap.put(lowerEntry.getKey(), left);
            } else if (lowerEntry.getValue() > left && lowerEntry.getValue() > right) {
                treeMap.put(lowerEntry.getKey(), left);
                treeMap.put(right, lowerEntry.getValue());
            }
        }

    }

    public static void main(String[] args) {
        RangeModule sol = new RangeModule();
        sol.addRange(10, 180);
        sol.addRange(180, 200);
        sol.addRange(190, 300);

        sol.removeRange(120,130);
        sol.removeRange(110,140);
        sol.removeRange(140,160);
        sol.removeRange(100,250);


        System.out.println(sol.queryRange(1, 7));
        sol.addRange(2, 3);
        System.out.println(sol.queryRange(2, 3));

    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
