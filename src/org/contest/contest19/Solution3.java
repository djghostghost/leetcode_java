package org.contest.contest19;

import java.util.*;

import org.practise.tree.TreeNode;

/**
 * Created by liguoxiang on 2017/02/12.
 */
public class Solution3 {

    public int[] findValueMostElement(TreeNode root) {


        if(root==null){
            return new int[0];
        }


        Queue<Queue<TreeNode>> queue=new LinkedList<>();


        Queue<TreeNode> firstLevel=new LinkedList<>();
        firstLevel.add(root);

        queue.add(firstLevel);


        List<Integer> res=new ArrayList<>();
        while(!queue.isEmpty()){

            Queue<TreeNode> queue1=new PriorityQueue<>();

            Queue<TreeNode> level=queue.poll();

            int max=Integer.MIN_VALUE;
            while(!level.isEmpty()){
                //POP UP MAX

                TreeNode top=level.poll();
                max=Math.max(max,top.val);


                if(top.right!=null){
                    queue1.add(top.right);
                }

                if(top.left!=null){
                    queue1.add(top.left);
                }
            }
            res.add(max);

            if(!queue1.isEmpty()){
                queue.add(queue1);
            }

        }

        return res.stream().mapToInt(i->i.intValue()).toArray();



    }
}
