package org.practise.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liguoxiang on 2017/02/09.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<List<Integer>> nodes = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            nodes.add(new ArrayList<>());
        }


        Queue<Integer> queue = new ArrayDeque<>();

        //add edges
        for (int[] prerequisite : prerequisites) {
            nodes.get(prerequisite[1]).add(prerequisite[0]);
            ++indegree[prerequisite[0]];
        }


        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int poll = queue.poll();

            ++count;


            for (Integer pointToNode : nodes.get(poll)) {
                --indegree[pointToNode];

                if (indegree[pointToNode] == 0) {
                    queue.add(pointToNode);
                }
            }

        }


        if (count < numCourses) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        CourseSchedule sol = new CourseSchedule();

        int[][] courses = {{1, 0}, {0, 1}};

        System.out.println(sol.canFinish(2, courses));

    }
}
