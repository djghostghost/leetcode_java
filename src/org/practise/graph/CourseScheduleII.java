package org.practise.graph;

import java.util.*;

/**
 * Created by liguoxiang on 2017/02/09.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses==0){
            return new int[0];
        }

        if(prerequisites==null||prerequisites.length==0){
            int[] res=new int[numCourses];

            for(int i=0;i<numCourses;i++){
                res[i]=i;
            }


            return res;

        }


        List<List<Integer>> nodes=new ArrayList<>();
        int[] indegrees=new int[numCourses];

        Queue<Integer> queue=new LinkedList<>();


        for(int i=0;i<numCourses;i++){
            nodes.add(new ArrayList<>());
        }

        //initialize add edges to build the graph

        for(int[] prerequisite:prerequisites){

            nodes.get(prerequisite[1]).add(prerequisite[0]);
            ++indegrees[prerequisite[0]];
        }

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.add(i);
            }

        }

        List<Integer> res=new ArrayList<>();
        while(!queue.isEmpty()){
            int course=queue.poll();

            res.add(course);

            for(int node:nodes.get(course)){
                --indegrees[node];
                if(indegrees[node]==0){
                    queue.add(node);
                }
            }
        }

        if(res.size()<numCourses){
            return new int[0];
        }else{
            return res.stream().mapToInt(ele->ele.intValue()).toArray();
        }


    }

    public static void main(String[] args) {
        CourseScheduleII sol=new CourseScheduleII();


        for(int i=1;i<10000;i++){

            if(i%2==1&&i%3==0&&i%4==1&&i%5==4&&i%6==3&&i%7==0&&i%8==1&&i%9==0){
                System.out.println(i);
                break;
            }

        }
    }
}
