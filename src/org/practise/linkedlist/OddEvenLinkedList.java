package org.practise.linkedlist;

/**
 * Author: ghost
 * Date  : 2016-02-09
 * TIME  : 19:12
 * PACKAGE:org.practise.linkedlist
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null ||head.next==null){
            return head;
        }

        ListNode dummyHead=new ListNode(Integer.MAX_VALUE);
        ListNode dummyEven=new ListNode(Integer.MAX_VALUE);
        dummyHead.next=head;
        ListNode odd=dummyHead;
        ListNode even=dummyEven;
        int count=1;
        while(odd.next!=null){

            if(count%2==0){
                even.next=odd.next;
                odd.next=odd.next.next;
                even=even.next;
                even.next=null;
            }else{
                odd=odd.next;
            }
            count++;
        }
        odd.next=dummyEven.next;

        odd=dummyHead.next;
        dummyEven=null;
        dummyHead=null;
        return odd;

    }
}
