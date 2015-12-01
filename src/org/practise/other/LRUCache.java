package org.practise.other;

import java.util.HashMap;

/**
 * Author: ghost
 * Date  : 2015-12-01
 * TIME  : 19:58
 * PACKAGE:org.practise.other
 * leetcode 146
 */
class  ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key,int val){
        this.key=key;
        this.val=val;
    }
}


class DoubleLinekdList{
    ListNode head=null;
    ListNode tail=null;

    public void addFirst(ListNode node){
        if(head==null && tail==null) {
            head = node;
            tail = node;
        }else{
            head.prev=node;
            node.next=head;
            node.prev=null;
            head=node;
        }

    }

    public int removeLastNode(){
        int key=0;
        if(head!=null &&head==tail){
            key=head.key;
            head=null;
            tail=null;
        }else {
            ListNode p = tail;
            tail = tail.prev;
            tail.next = null;
            key=p.key;

        }
        return key;
    }

    public void promote(ListNode node){
        if(head==node){
            return;
        }

        ListNode prev=node.prev;

        node.prev.next=node.next;
        if(node.next!=null){
            node.next.prev=node.prev;
        }else{
            tail=node.prev;
        }

        head.prev=node;
        node.next=head;
        node.prev=null;
        head=node;
    }


}

public class LRUCache {
    private final HashMap<Integer,ListNode> cache=new HashMap<>();
    private final DoubleLinekdList cachedList=new DoubleLinekdList();
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {

        if(!cache.containsKey(key)) return -1;
        ListNode node=cache.get(key);
        cachedList.promote(node);

        return node.val;

    }

    public void set(int key, int value) {

        if(cache.containsKey(key)){
            ListNode target=cache.get(key);
            target.val=value;
            cachedList.promote(target);
            return;
        }

        if(cache.size()==this.capacity){
            int lastKey=cachedList.removeLastNode();
            cache.remove(lastKey);
        }

        ListNode node=new ListNode(key,value);
        cache.put(key,node);
        cachedList.addFirst(node);

    }


}
