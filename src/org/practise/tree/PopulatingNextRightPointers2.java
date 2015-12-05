package org.practise.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Author: ghost
 * Date  : 2015-12-03
 * TIME  : 20:53
 * PACKAGE:org.practise.tree
 */
class Node{
    private int generation;
    private TreeLinkNode node;

    public Node(int generation,TreeLinkNode node){
        this.generation=generation;
        this.node=node;
    }

    public int getGeneration(){
        return this.generation;
    }
    public TreeLinkNode getNode(){
        return this.node;
    }
}
public class PopulatingNextRightPointers2 {
    public void connect(TreeLinkNode root) {
        if(root==null || (root.right==null && root.right==null)) return;

        Queue<Node> queue=new ArrayDeque<>();
        Node node=new Node(1,root);
        queue.add(node);
        Node prev=null;
        while(!queue.isEmpty()){

            Node p=queue.poll();
            if(p.getNode().left!=null){
                queue.add(new Node(p.getGeneration()+1,p.getNode().left));
            }

            if(p.getNode().right!=null){
                queue.add(new Node(p.getGeneration()+1,p.getNode().right));
            }

            if(prev!=null&&prev.getGeneration()==p.getGeneration()){
                prev.getNode().next=p.getNode();
            }
            prev=p;
        }
    }
}
