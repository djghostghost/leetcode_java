package org.practise.array;

/**
 * Created by liguoxiang on 9/18/16.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;
        int[] res = new int[2];

        while (start < end) {
            if (numbers[start] + numbers[end] < target) {
                start++;

            } else if (numbers[start] + numbers[end] > target) {
                end--;

            } else {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }


        }

        return res;

    }

}
