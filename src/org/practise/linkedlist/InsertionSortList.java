package org.practise.linkedlist;

/**
 * Author: ghost
 * Date  : 2015-11-10
 * TIME  : 19:44
 * PACKAGE:org.practise.linkedlist
 * leetcode 147
 */

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode p=head;
        ListNode q=head;
        while(p.next!=null){
            q=p.next;
            if(q.val<p.val){
                p.next=q.next;
                head=insertNodeToList(q,head,p);
                continue;
            }
            p=p.next;

        }

        return head;

    }
    public ListNode insertNodeToList(ListNode node,ListNode head,ListNode end){
        if(node.val<=head.val){
            node.next=head;
            return node;
        }else{
            ListNode p=head;
            while(p.next!=end){

                if(p.val<=node.val && p.next.val>=node.val ){
                    node.next=p.next;
                    p.next=node;
                    break;
                }
                p=p.next;
            }
            if(p.next==end){
                p.next=node;
                node.next=end;
            }

            return head;
        }
    }
}
