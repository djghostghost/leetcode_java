package org.practise.linkedlist;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){


            slow=slow.next;
            fast=fast.next;

            if(fast!=null){
                fast=fast.next;
            }

        }

        return slow;
    }
}
