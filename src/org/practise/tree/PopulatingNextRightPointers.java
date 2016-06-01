package org.practise.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: ghost
 * Date  : 2015-12-03
 * TIME  : 20:49
 * PACKAGE:org.practise.tree
 */
class TreeLinkNodeX{
    public TreeLinkNodeX right;
    public TreeLinkNodeX left;
    public TreeLinkNodeX next;
}

public class PopulatingNextRightPointers {
    public void connect(TreeLinkNodeX root) {
        if(root==null || (root.right==null && root.left==null)) return;

        Queue<TreeLinkNodeX> queue=new LinkedList<>();

        queue.add(root);
        TreeLinkNodeX prev=null;
        int n=1;
        while(!queue.isEmpty()){

            TreeLinkNodeX p=queue.poll();
            if(p.left!=null){
                queue.add(p.left);
            }

            if(p.right!=null){
                queue.add(p.right);
            }

            if((n&(n-1))!=0) {
                prev.next = p;
            }
            prev=p;
            n++;
        }
    }
}
