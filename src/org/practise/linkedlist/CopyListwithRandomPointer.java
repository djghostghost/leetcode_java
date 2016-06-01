package org.practise.linkedlist;

import java.util.HashMap;

/**
 * Author: ghost
 * Date  : 2016-03-24
 * TIME  : 19:22
 * PACKAGE:org.practise.linkedlist
 * leetcode 138
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode p = dummyHead;


        while (head != null) {
            //copy the next point


            if (map.containsKey(head)) {
                p.next = map.get(head);
            } else {
                RandomListNode newNode = new RandomListNode(head.label);

                map.put(head, newNode);
                p.next = newNode;

            }
            p = p.next;

            //copy the random point
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    p.random = map.get(head.random);

                } else {
                    RandomListNode newNode = new RandomListNode(head.random.label);
                    map.put(head.random, newNode);
                    p.random = newNode;
                }
            }
            head = head.next;

        }
        return dummyHead.next;

    }

}


// * Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
