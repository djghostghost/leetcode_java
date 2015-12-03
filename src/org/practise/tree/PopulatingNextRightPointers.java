package org.practise.tree;

/**
 * Author: ghost
 * Date  : 2015-12-03
 * TIME  : 20:49
 * PACKAGE:org.practise.tree
 */
public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        if(root==null || (root.right==null && root.right==null)) return;

        Queue<TreeLinkNode> queue=new LinkedList<>();

        queue.add(root);
        TreeLinkNode prev=null;
        int n=1;
        while(!queue.isEmpty()){

            TreeLinkNode p=queue.poll();
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
