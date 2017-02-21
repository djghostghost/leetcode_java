package org.practise.backtracking;

import java.util.*;

/**
 * Created by liguoxiang on 2017/01/22.
 */
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> ress = new HashSet<>();


        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<Integer>();
        findSubsequencesHelper(nums, 0, ress, stack);
        List result = new ArrayList(ress);
        return result;

    }

    public void findSubsequencesHelper(int nums[], int index, Set<List<Integer>> ress, Stack<Integer> stack) {


        if (stack.size() >= 2) {
            List<Integer> res = new ArrayList<>();

            res.addAll(stack);
            ress.add(res);

        }

        for (int i = index; i < nums.length; i++) {


            if (stack.isEmpty() || nums[i] >= stack.peek()) {

                stack.push(nums[i]);
                findSubsequencesHelper(nums, i + 1, ress, stack);
                stack.pop();
            }
        }


    }


    public static void main(String[] args) {
        IncreasingSubsequences sol = new IncreasingSubsequences();

        int[] nums = {-100, -100, 0, 0, 0, 100, 100, 0, 0};

        List<List<Integer>> ress = sol.findSubsequences(nums);


        for (List<Integer> res : ress) {


            for (Integer num : res) {
                System.out.print(num + " ");
            }

            System.out.println();
        }


    }


}
