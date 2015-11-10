package org.practise.linkedlist;

/**
 * Author: ghost
 * Date  : 2015-11-10
 * TIME  : 19:47
 * PACKAGE:org.practise.linkedlist
 * leetcode 148
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        if(head.next.next==null){
            ListNode p=head.next;
            if(p.val<head.val){
                p.next=head;
                head.next=null;
                return p;
            }else{
                return head;
            }


        }

        ListNode slow=head;
        ListNode faster=head;
        ListNode prev=null;

        while(faster!=null){
            prev=slow;
            slow=slow.next;
            faster=faster.next;

            if(faster!=null) faster=faster.next;
        }
        prev.next=null;

        ListNode list1=sortList(head);
        ListNode list2=sortList(slow);

        return meargetSort(list1,list2);

    }

    public ListNode meargetSort(ListNode list1,ListNode list2){
        ListNode head=new ListNode(0);

        ListNode p=head;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                p.next=list1;
                list1=list1.next;
            }else{
                p.next=list2;
                list2=list2.next;
            }
            p=p.next;
        }

        p.next=(list1==null)?list2:list1;

        return head.next;
    }
}
