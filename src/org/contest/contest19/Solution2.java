package org.contest.contest19;

import org.practise.tree.TreeNode;

import java.util.*;

/**
 * Created by liguoxiang on 2017/02/12.
 */
public class Solution2 {


    public int findLeftMostNode(TreeNode root) {

        if(root==null){
            return 0;
        }


        Queue<Queue<TreeNode>> queue=new LinkedList<>();


        Queue<TreeNode> firstLevel=new LinkedList<>();
        firstLevel.add(root);

        queue.add(firstLevel);

        TreeNode mostLeft=null;

        while(!queue.isEmpty()){

            Queue<TreeNode> queue1=new LinkedList<>();

            Queue<TreeNode> level=queue.poll();

            boolean flag=false;
            while(!level.isEmpty()){
                //POP UP MAX

                TreeNode top=level.poll();

                if(!flag){
                    mostLeft=top;
                    flag=true;
                }


                if(top.left!=null){
                    queue1.add(top.left);
                }


                if(top.right!=null){
                    queue1.add(top.right);
                }
            }

            if(!queue1.isEmpty()){
                queue.add(queue1);
            }

        }


        return (mostLeft!=null)?mostLeft.val:-1;

    }

    public static void main(String[] args) {

        Solution2 sol=new Solution2();
        sol.findLeftMostNode(null);

    }





}
